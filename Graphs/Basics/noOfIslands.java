package Graphs.Basics;

public class noOfIslands {

    // using DFS , and also we can solve using BFS
    public static void dfs(int[][] mat , int i, int j){
        int n=mat.length;
        int m =mat[0].length;

        if(i<0 || j<0 || i>=n || j>=m || mat[i][j]==0) return;

        mat[i][j]=0;

        dfs(mat, i-1, j);
        dfs(mat, i+1, j);
        dfs(mat, i, j-1);
        dfs(mat, i, j+1);
    }
    public static void main(String[] args) {
        int[][] island = {{1,1,0,0,0},{1,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}};

        int n=island.length;
        int m = island[0].length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(island[i][j]==1){
                    count++;
                    dfs(island,i,j);
                }
            }
        }
       System.out.println(count);
    }
}
