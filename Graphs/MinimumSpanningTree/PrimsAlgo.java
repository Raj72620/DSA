package Graphs.MinimumSpanningTree;
import java.util.*;

public class PrimsAlgo {

    static class pairs{
   
        int dest;
        int weight;

        public pairs(int dest,int weight) {
            this.dest=dest;
            this.weight=weight;
        }
    }
static class Info{
    int node ;
    int wt;
    int parent;

        public Info(int node , int wt, int parent) {
            this.node=node;
            this.wt=wt;
            this.parent=parent;
        }
    
    }
    public static int getMin(int v ,ArrayList<ArrayList<pairs>> graph){
        PriorityQueue<Info>pq = new PriorityQueue<>((a,b)->a.wt-b.wt);
        boolean[] visited = new boolean[v];
        pq.add(new Info(0, 0, -1));
                int sum=0;

        while(!pq.isEmpty()){
            Info info = pq.remove();
            int node = info.node;
            int wt=info.wt;
            int par=info.parent;
            
            if(visited[node]) continue;

            visited[node]=true;
            sum+=wt;

            for(pairs neig : graph.get(node)){
                if(!visited[neig.dest]){
                    pq.add(new Info(neig.dest, neig.weight, node));
                }
            }
        }
        return sum;
    } 
    public static void main(String[] args) {
         int v= 5;
      int[][] arr = {{0, 1, 1},{0, 2, 1}, {1, 0, 2},{1, 2, 1},{2, 0, 1},{2, 1, 1},{2, 3, 2},{2, 4, 2},{3, 2, 2},{3, 4, 1},{4, 2, 2},{4, 3, 1}
};
        ArrayList<ArrayList<pairs>> graph = new ArrayList<>();
        for(int i=0;i<v;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : arr){
            int u=edge[0];
            int vx=edge[1];
            int wt=edge[2];

            graph.get(u).add(new pairs(vx, wt));
        }
        System.out.println(getMin(v, graph));
    }
}
