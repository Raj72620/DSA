package Graphs.shortestPaths;
import java.util.*;

public class cityWithSmallestThreshold {

    public static int findCity(int n , int[][] edges,int distThreshold){
        int INF = (int)1e9;
        int[][] dist = new int[n][n];

        for(int i=0;i<n;i++){
            Arrays.fill(dist[i], INF);
        }
        for(int i=0;i<n;i++){
        dist[i][i]=0;
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            dist[u][v]=wt;
            dist[v][u]=wt;
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k]!=INF && dist[k][j]!=INF){
                        dist[i][j]= Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                    }   
                }
            }
        }
            int countMax = Integer.MAX_VALUE;
            int city=-1;

            for(int i=0;i<n;i++){
                int count =0;
                for(int j=0;j<n;j++){
                    if(i!=j && dist[i][j]<=distThreshold){
                        count++;
                    }
                }
                if(countMax >= count){
                    countMax=count;
                    city =i;
                }
            }
              return city;
    }
    public static void main(String[] args) {
       int[][] edges={{0,1,3},{1,0,3},{1,2,1},{1,3,4},{2,1,1},{2,3,1},{3,1,4},{3,2,1}};
       int distThreshold=4;
       System.out.println(findCity(distThreshold, edges, distThreshold));
    }
}
