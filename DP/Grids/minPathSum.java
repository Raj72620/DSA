package DP.Grids;

import java.util.Arrays;

public class minPathSum {

    //Recursion
    public static int minPath(int[][] arr, int i, int j) {
        if (i == 0 && j == 0) {
            return arr[i][j];
        }
        if (i < 0 || j < 0) {
            return (int) 1e9;
        }
        int left = minPath(arr, i, j - 1);
        int right = minPath(arr, i - 1, j);

        return arr[i][j] + Math.min(left, right);

    }

    //Memoization
    public static int memo(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(arr, dp, n - 1, m - 1);
    }

    public static int solve(int[][] arr, int[][] dp, int i, int j) {
        if (i == 0 && j == 0) {
            return arr[0][0];
        }
        if (i < 0 || j < 0) {
            return (int) 1e9;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int left = solve(arr, dp, i, j - 1);
        int up = solve(arr, dp, i - 1, j);

        dp[i][j] = arr[i][j] + Math.min(left, up);

        return dp[i][j];
    }

    //Tabulation
    public static int tabulation(int[][] arr){
        int n=arr.length;
        int m=arr[0].length;

        int[][] dp = new int[n][m];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(i==0 && j==0 ){
                    dp[i][j]=arr[i][j];
                }else{
                    int up=(int)1e9;
                    int left = (int)1e9;

                    if(i>0){
                        up=arr[i][j]+dp[i-1][j];
                    }
                    if(j>0){
                        left=arr[i][j]+dp[i][j-1];
                    }
                    dp[i][j]=Math.min(up, left);
                }
            }
        }
            return dp[n-1][m-1]; 
    }

    //space optimization
    public static int sp(int[][] arr){
        int n=arr.length;
        int m=arr[0].length;

        int[] prev = new int[m];

        for(int i=0;i<n;i++){
            int[] curr=new int[m];
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    curr[j]=arr[0][0];
                }else{
                    int up=(int)1e9;
                    int left=(int)1e9;

                    if(i>0){
                        up=arr[i][j]+prev[j];
                    }
                    if(j>0){
                        left=arr[i][j]+curr[j-1];
                    }
                    curr[j]=Math.min(up, left);
                }
            }
            prev=curr;
        }
        return prev[m-1];
    }
    public static void main(String[] args) {
        int[][] arr = {{5, 9, 6}, {11, 5, 2}};
        int n = arr.length;
        int m = arr[0].length;

        System.out.println(minPath(arr, n - 1, m - 1));

        System.out.println(memo(arr));

        System.out.println(tabulation(arr));

        System.out.print(sp(arr));
    }
}
