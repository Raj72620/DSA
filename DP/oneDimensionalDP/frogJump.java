package DP.oneDimensionalDP;

import java.util.*;

public class frogJump {

    //Memoization approach

    public static int minAbsDiff(int[] arr, int n, int[] dp) {
        if (n == 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int left = minAbsDiff(arr, n - 1, dp) + Math.abs(arr[n] - arr[n - 1]);

        int right = Integer.MAX_VALUE;

        if (n > 1) {
            right = minAbsDiff(arr, n - 2, dp) + Math.abs(arr[n] - arr[n - 2]);
        }
        dp[n] = Math.min(left, right);

        return dp[n];

    }

    //Tabulation approach

    public static int minAbs(int[] arr,int n){
        int[] dp = new int[n];
        dp[0] = 0;        

        for(int i=1;i<n;i++){
            int left = dp[i-1]+ Math.abs(arr[i]-arr[i-1]);

            int right = Integer.MAX_VALUE;
            if(i > 1){
                right = dp[i-2] + Math.abs(arr[i]-arr[i-2]);
            }
            dp[i]=Math.min(left, right);
        }
             return dp[n-1];
    }


    //Space optimization

    public static int spaceOptimize(int[] arr,int n){
        int prev2=0;
        int prev1=0;

        for(int i=1;i<n;i++){

            int left = prev1+Math.abs(arr[i]-arr[i-1]);

            int right = Integer.MAX_VALUE;

            if(i>1){
            right = prev2+ Math.abs(arr[i]-arr[i-2]);
            }
            int curr = Math.min(left, right);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
    public static void main(String[] args) {
        int[] arr = {10,20,30,10};
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        System.out.println(minAbsDiff(arr, n-1,dp));

        System.out.println(minAbs(arr, n));

        System.out.print(spaceOptimize(arr, n));
    }
}
