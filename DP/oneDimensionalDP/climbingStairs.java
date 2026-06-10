package DP.oneDimensionalDP;
import java.util.*;

public class climbingStairs {

    public static int findTotalWays(int n,int[] dp){
       
        if(n==0 || n==1) return 1;
        
        if(dp[n]!=-1) return dp[n];

       int left = findTotalWays(n-1, dp);
       int right = findTotalWays(n-2, dp);

       dp[n]= left+right;
       return dp[n];
    }
    public static void main(String[] args) {
        int n=3;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(findTotalWays(n,dp));
    }
}