package Graphs;

import java.util.*;

public class graphPractice {

    static class Pairs {
       
        int dest;
        int wt;

        Pairs(int dest, int wt) {
      
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static int getMin(int v , ArrayList<ArrayList<Pairs>> graph,int sr){
            PriorityQueue<Pairs> pq = new PriorityQueue<>((a,b)->a.wt-b.wt);
            boolean[] visited = new boolean[v];
         
            pq.add(new Pairs(sr, 0));
            int sum=0;

            while(!pq.isEmpty()){
          
                Pairs curr = pq.remove();

                int node = curr.dest;
                int weight = curr.wt;

                if(visited[node]) continue;

                visited[node]=true;
                sum+=weight;
                
                for(Pairs neig : graph.get(node)){

                    int AdjNode = neig.dest;
                    int wt = neig.wt;
                    
                  if(!visited[AdjNode]){
                    pq.add(new Pairs(AdjNode, wt));
                  }
                }
            }
            return sum;
    }
    public static void main(String[] args) {
        int v= 5;
      int[][] arr = {
    {0, 1, 1},
    {0, 2, 1},

    {1, 0, 2},
    {1, 2, 1},

    {2, 0, 1},
    {2, 1, 1},
    {2, 3, 2},
    {2, 4, 2},

    {3, 2, 2},
    {3, 4, 1},

    {4, 2, 2},
    {4, 3, 1}
};
        ArrayList<ArrayList<Pairs>> graph = new ArrayList<>();
        for(int i=0;i<v;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : arr){
            int u=edge[0];
            int vx=edge[1];
            int wt=edge[2];

            graph.get(u).add(new Pairs(vx, wt));
        }
        System.out.println(getMin(v, graph, 0));
    }
}