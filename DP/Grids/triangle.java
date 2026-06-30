package DP.Grids;

import java.util.Arrays;

public class triangle {

    //Recursion
    public static int minSum(int[][] grid,int i,int j){
        if(i==grid.length-1 || j== grid.length-1){
            return grid[i][j];
        }
        int down =minSum(grid, i+1, j);
        int diagonal=minSum(grid, i+1, j+1);

        return grid[i][j]+Math.min(down, diagonal);
    }

    //Memoization
    public static int memoization(int[][] grid){

        int n= grid.length;
        
        int[][] dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(grid,dp,0,0,n);
    }
    public static int solve(int[][] grid,int[][] dp,int i,int j,int n){

        if(i==n-1 || j==n-1) return grid[i][j];

        if(dp[i][j]!=-1) return dp[i][j];
        
        int left=solve(grid, dp, i+1, j,n);
        int diagonal=solve(grid, dp, i+1, j+1,n);

        dp[i][j]=grid[i][j]+Math.min(left, diagonal);

        return dp[i][j];

    }

    //Tabulation
    public static int tabulation(int[][] grid){
        int n=grid.length;
        int[][] dp = new int[n][n];

        for(int i=0;i<n;i++){
            dp[n-1][i]=grid[n-1][i];
        }

        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){

                int down= dp[i+1][j];
                int diagonal=dp[i+1][j+1];

                dp[i][j]=grid[i][j]+Math.min(down, diagonal);
            }
        }
        return dp[0][0];
    }

    //space optimization
    public static int sp(int[][] grid){
        int n= grid.length;

        int[] prev= new int[n];

        for(int i=0;i<n;i++){
            prev[i]=grid[n-1][i];
        }

        for(int i=n-2;i>=0;i--){
            int[] curr=new int[n];
            for(int j=i;j>=0;j--){
                int down= prev[j];
                int diag= prev[j+1];

                curr[j]=grid[i][j]+Math.min(down, diag);
            }
            prev=curr;
        }
        return prev[0];
    }
    public static void main(String[] args) {
        int[][] grid={{1},{2,3},{3,6,7},{8,9,6,10}};

        System.out.println(minSum(grid,0,0));

        System.out.println(memoization(grid));

        System.out.println(tabulation(grid));

        System.out.println(sp(grid));
    }
}
