package DP.oneDimensionalDP;

import java.util.*;

public class frigJump {

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

    public static void main(String[] args) {
        int[] arr = {10,20,30,10};
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        System.out.println(minAbsDiff(arr, n-1,dp));
    }
}
