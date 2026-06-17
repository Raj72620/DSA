package DP.oneDimensionalDP;
import java.util.*;

public class forgJumpKsteps {

    public static int solve(int[]arr,int[]dp,int idx,int k){

        if(idx==0) return 0;
        if(dp[idx]!=-1) return dp[idx];

        int minEnery = Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            if(idx-i >=0){
            int energy = solve(arr, dp, idx-i, k)+ Math.abs(arr[idx]-arr[idx-1]);
            minEnery=Math.min(minEnery, energy);
        }
    }
    dp[idx]=minEnery;

    return dp[idx];
        
    }
    public static void main(String[] args) {
        int[] arr= {10,20,30,10};
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        dp[0]=0;

        int k=2;
        System.out.println(solve(arr,dp,0,k));
    }
}
