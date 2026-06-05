package Graphs.shortestPaths;

import java.util.Arrays;

public class flodyWarshallAlgo {

    public static void floydwarshall(int[][] mat){
        int n =mat.length;
        int INF = (int)1e9;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==-1){
                    mat[i][j]=INF;
                }
                if(i==j){
                    mat[i][j]=0;
                }
            }
        }
        //floyd algo
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(mat[i][k]!=INF && mat[k][j] !=INF){
                        mat[i][j]=Math.min(mat[i][j], mat[i][k]+mat[k][j]);
                    }
                }
            }
        }
        //check for negative cycle 
        for(int i=0;i<n;i++){
            if(mat[i][i]<0){
                System.out.print("negative cycle exists");
                return;
            }
        }
        //Convert INF back to -1
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==INF){
                        mat[i][j]=-1;
                }       
            }
        }
    }
    public static void main(String[] args) {
        int[][] mat = {
    {0, 1, -1},
    {-1, 0, -2},
    {-4, -1, 0}
};
        floydwarshall(mat);

        for(int[] row : mat){
            System.out.print(Arrays.toString(row));
        }
    }
}
