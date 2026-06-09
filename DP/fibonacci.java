package DP;

public class fibonacci {

    //Memoization approach
    public static int fib(int n , int[] dp){
        if(n==0 || n==1)return n;

        if(dp[n]!=-1) return dp[n];

        dp[n]= fib(n-1, dp)+fib(n-2, dp);
        return dp[n];
    }

    //Tabulation approach
    public static int TabFib(int n){
        if(n==0) return 0;
        int[] Dp = new int[n+1];
        Dp[0]=0;
        Dp[1]=1;
        for(int i=2;i<=n;i++){
            Dp[i]=Dp[i-1]+Dp[i-2];
        }
        return Dp[n];
    }
    public static void main(String[] args) {
        int n=6;
        // int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // System.out.println(fib(n,dp));

        System.out.print(TabFib(5));
    }
}
