package Graphs;
import java.util.*;

public class bellmanFordAlgo {

    public static int[] bellmanford(int v , int[][] edges,int src){
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]=0;

        for(int i=1;i<=v-1;i++){
            for(int[] edge : edges){
                int u=edge[0];
                int vt = edge[1];
                int wt = edge[2];

                if(dist[u]!= Integer.MAX_VALUE && dist[u]+wt < dist[vt]){
                    dist[vt]=dist[u]+wt;
                }
            }
        }
        for(int[] edge : edges){
            int u=edge[0];
            int vt =edge[1];
            int wt =edge[2];

            if(dist[u]!=Integer.MAX_VALUE && dist[u]+wt < dist[vt]){
                return new int[]{-1};
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int v =5;
        int[][] edges = {{0,1,2},{0,2,4},{1,2,-4},{2,3,2},{3,4,4},{4,1,-1}};
        int[] ans = bellmanford(v, edges, 0);
        System.out.print(Arrays.toString(ans));

    }
}
