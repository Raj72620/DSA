package DP.oneDimensionalDP;
import java.util.*;

public class houseRobber{

    //Memoization 
    public static int memoization(int[] arr,int[] dp,int idx){
        if(idx==0) return arr[0];
               if(idx<0) return 0;

        if(dp[idx]!=-1) return dp[idx];

        int pick =arr[idx]+memoization(arr, dp, idx-2);
        int notPick = memoization(arr, dp, idx-1);

        dp[idx]=Math.max(pick, notPick);

        return dp[idx];
    }

    //Tabulation
    public static int tabulation(int[] arr){
        int n=arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        dp[0]=arr[0];
        for(int i=1;i<n;i++){
            int notPick = dp[i-1];
            
            int pick = -Integer.MIN_VALUE;
            if(i>1){
                pick=arr[i]+dp[i-2];
            }
            dp[i]=Math.max(pick, notPick);
        }
        return dp[n-1];

    }

    //space optimization
    public static int spOz(int[] arr){
     int n=arr.length;
     
     int prev2=0;
     int prev1=arr[0];

     for(int i=1;i<n;i++){
        int pick= arr[i]+prev2;
        int notPick=prev1;

        int curr=Math.max(pick, notPick);

        prev2=prev1;
        prev1=curr;
     }
     return prev1;
    }
    
    public static void main(String[] args) {
        int[] arr={2,1,4,9};
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

       System.out.println( memoization(arr,dp,n-1));

       System.out.println(tabulation(arr));

       System.out.println(spOz(arr));
    }
}