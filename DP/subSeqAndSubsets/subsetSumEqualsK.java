package DP.subSeqAndSubsets;

import java.util.Arrays;

public class subsetSumEqualsK {

    //Recursion
    public static boolean subSetSum(int[] arr,int idx,int tar){
        if(tar==0) return true;
        if(idx==0){
            return arr[0]==tar;
        }
        boolean notPick = subSetSum(arr, idx-1, tar);

        boolean pick= false;
        if(arr[idx]<=tar){
            pick=subSetSum(arr, idx-1, tar-arr[idx]);
        }
        return pick||notPick;
    }

    //Memoization
    public static boolean memo(int[] arr,int tar){
         int idx=arr.length;
        int[][] dp= new int[idx][tar+1];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }

        return solve(arr,dp,idx-1,tar);
    }
    public static boolean solve(int[] arr,int[][] dp,int idx,int tar){

        if(tar==0) return true;
        if(idx==0){
            return arr[0]==tar;
        }

        if(dp[idx][tar]!=-1){
            return dp[idx][tar]==1;
        }

        boolean notPick=solve(arr, dp, idx-1, tar);

        boolean pick= false;
        if(arr[idx]<=tar){
            pick=solve(arr, dp, idx-1, tar-arr[idx]);
        }
        boolean ans=pick||notPick;
        dp[idx][tar]= ans ? 1 :0;
        return ans;
    }

    //Tabulation
    public static boolean tab(int[] arr,int tar){
        int n=arr.length;
        boolean[][] dp = new boolean[n][tar+1];
        
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        if(arr[0]<=tar){
            dp[0][arr[0]]=true;
        }

        for(int idx=1;idx<n;idx++){
            for(int target=1;target<=tar;target++){
                boolean notPick=dp[idx-1][target];

                boolean pick =false;
                if(arr[idx]<=target){
                    pick=dp[idx-1][target-arr[idx]];
                }
                dp[idx][target]=pick||notPick;
            }
        }
        return dp[n-1][tar];
    }
    public static void main(String[] args) {
        int[] arr={1,3,1,1};
        int tar=4;
        int idx=arr.length;
       System.out.println( subSetSum(arr,idx-1,tar));

       System.out.println(memo(arr, tar));

       System.out.println(tab(arr, tar));
    }
}
