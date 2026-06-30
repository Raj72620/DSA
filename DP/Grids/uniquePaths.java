package DP.Grids;

import java.util.Arrays;

public class uniquePaths {

    //recursion
    public static int solve(int[][] arr, int n, int m, int i, int j) {

        if (i == n && j == m) {
            return 1;
        }
        if (i <0 || j < 0) {
            return 0;
        }

        int Up = solve(arr, n, m, i-1, j );
        int left = solve(arr, n, m, i, j-1);

        return Up + left;
    }

    //Memoization
    public static int memo(int[][] mat){
        int n=mat.length;
        int m=mat[0].length;
        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

       return solve(mat,dp,n-1,m-1);
    }
    public static int solve(int[][] mat,int[][] dp,int i,int j){

        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int up = solve(mat,dp, i-1, j);
        int left=solve(mat,dp, i, j-1);

        dp[i][j]=up+left;

       return dp[i][j];
    }

    //Tabulation
    public static int tabulation(int[][] mat){
        int n=mat.length;
        int m =mat[0].length;

        int[][] dp = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    dp[i][j]=1;
                }else{
                    int up= 0;
                    int left=0;

                    if(i>0){
                        up=dp[i-1][j];
                    }
                    if(j>0){
                        left=dp[i][j-1];
                    }
                    dp[i][j]=up+left;
                }
            }
        }
        return dp[n-1][m-1];
    }

    //Space optimization
    public static int sp(int[][] mat){
        int n=mat.length;
        int m=mat[0].length;

        int[] prev = new int[n];

        for(int i=0;i<n;i++){
            int[] curr=new int[m];
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    curr[j]=1;
                }else{
                    int up=0;
                    int left=0;

                    if(i>0){
                        up= prev[j];
                    }
                    if(j>0){
                        left=curr[j-1];
                    }
                    curr[j]=up+left;
                }
            }
            prev=curr;
        }
        return prev[n-1];
    }
    public static void main(String[] args) {
        int[][] mat = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };

        int n = mat.length;
        int m = mat[0].length;

        System.out.println(solve(mat, 0, 0, n-1, m-1));

        System.out.println(memo(mat));

        System.out.println(tabulation(mat));

        System.out.println(sp(mat));
    }
}
