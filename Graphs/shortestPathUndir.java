package Graphs;
//shortest path in undirected graph -> BFS

import java.util.*;

public class shortestPathUndir {

    static class pairs{
        int dest;
        int wt;

        public pairs(int dest,int wt) {
            this.dest=dest;
            this.wt=wt;
        }        
    }
    public static int[] shortestPath(int v , int e , int[][] arr){
        ArrayList<ArrayList<pairs>>graph = new ArrayList<>();
        for(int i=0;i<v;i++){
            graph.add(new ArrayList<>());
        }
       for(int i=0;i<e;i++){
        int u=arr[i][0];
        int vd = arr[i][1];
        int wt = arr[i][2];
        graph.get(u).add(new pairs(vd, wt));
       }
       Queue<Integer>q = new LinkedList<>();
       q.add(0);
       int[] dist = new int[v];
       Arrays.fill(dist, Integer.MAX_VALUE);
       dist[0]=0;

       while(!q.isEmpty()){
        int curr = q.poll();
        
        if(dist[curr]!=Integer.MAX_VALUE){
            for(pairs neig : graph.get(curr)){
                int newDist = dist[curr]+neig.wt;

                if(newDist < dist[neig.dest]){
                    dist[neig.dest]=newDist;
                    q.add(neig.dest);
                }
            }
        }
       }
       for(int i=0;i<v;i++){
        if(dist[i]==Integer.MAX_VALUE){
            dist[i]=-1;
        }
       }
       return dist;
    }
    public static void main(String[] args) {
         int v=9;
        int e=20;
        
        int[][] arr={{0,1,1},{0,3,1},{1,0,1},{1,2,1},{2,1,1},{2,6,1},{3,0,1},{3,4,1},{4,3,1},{4,5,1},{5,4,1},{5,6,1},{6,2,1},{6,5,1},{6,7,1},{6,8,1},{7,6,1},{7,8,1},{8,6,1},{8,7,1}};
        int[] ans = shortestPath(v, e, arr);
        System.out.print(Arrays.toString(ans));
    }
}
