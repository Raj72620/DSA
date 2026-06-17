package Graphs.shortestPaths;
import java.util.*;

public class dijkstraAlgo {

   static class Pair{
        int dest;
        int weigth;

        public Pair(int dest , int weight) {
            this.dest=dest;
            this.weigth=weight;
        }  
    }
    public static int[] dijkstra(int[][] arr,int v, int e){
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for(int i=0;i<v;i++){
            graph.add(new ArrayList<>());
        }
       for(int i=0;i<e;i++){

        int src = arr[i][0];
        int d = arr[i][1];
        int w =arr[i][2];

        graph.get(src).add(new Pair(d, w));
       }
       PriorityQueue<Pair> pq = new PriorityQueue<>(((a, b) -> a.weigth - b.weigth));
       int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);

       dist[0]=0;

       pq.add(new Pair(0, 0));

       while(!pq.isEmpty()){

        Pair curr = pq.remove();
        int node =curr.dest;
        int wt = curr.weigth;

         if(dist[node]!=Integer.MAX_VALUE){
        for(Pair neig : graph.get(node)){
            int toalDist = wt+neig.weigth;

            if(dist[neig.dest] > toalDist){
                dist[neig.dest]=toalDist;
                pq.add(new Pair(neig.dest, toalDist));
            }
        }
       }
    }
       return dist;
    }
    public static void main(String[] args) {
        int[][] arr={{0,1,4},{0,2,4},{1,0,4},{1,2,4},{2,0,4},{2,1,2},{2,3,3},{2,4,1},{2,5,6},{3,2,3},{3,5,2},{4,2,1},{4,5,3}};
        int v=6;
        int e = arr.length;
        int[] ans = dijkstra(arr, v, e);
     System.out.print(Arrays.toString(ans));
    }
}
