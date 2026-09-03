package DP.subSeqAndSubsets;

public class zeroOneKnapsack {

    //Recursion
    public static int findTheMaxProfit(int[] wg, int[] val,int idx, int bag){
            if(idx==0){
                if(wg[0]<=bag) return val[0];
                return 0;
            }
            int notPick=findTheMaxProfit(wg, val, idx-1, bag);
            int pick=Integer.MIN_VALUE;
            if(wg[idx]<=bag){
                pick=val[idx]+findTheMaxProfit(wg, val, idx-1, bag-wg[idx]);
            }
            return Math.max(pick,notPick);
    }

    //Memoizatio
    public static int Memo(int[] wg, int[] val, int idx, int bag){
        int n= wg.length;
        int[][] dp= new int[n][bag+1];
        for(int[] row : dp){
            java.util.Arrays.fill(row,-1);
        }
       int ans= solveMemo(wg,val,dp,n,idx,bag);
       return ans;
    }
    public static int solveMemo(int[] wg,int[] val,int[][] dp,int n, int idx, int bag){

        if(idx==0){
            if(wg[0]<=bag){
                return val[0];
            }
            return 0;
        }
        if(dp[idx][bag]!=-1){
            return dp[idx][bag];
        }
        int notPick = solveMemo(wg, val,dp,n, idx-1, bag);

        int pick=Integer.MIN_VALUE;
        if(wg[idx]<=bag){
            pick=val[idx]+solveMemo(wg, val,dp,n, idx-1, bag-wg[idx]);
        }
        dp[idx][bag]=Math.max(notPick, pick);

        return dp[idx][bag];
    } 

    // Tabulation

    public static int tab(int[] wg, int[] val,int n,int bag){

        int[][] dp=new int[n][bag+1];
        for(int i=wg[0];i<=bag;i++){
            dp[0][i]=val[0];
        }

        for(int idx=1;idx<n;idx++){
            for(int cap=0;cap<=bag;cap++){

                int notPick=dp[idx-1][cap];
                int pick=Integer.MIN_VALUE;
                if(wg[idx]<=cap){
                    pick=val[idx]+dp[idx-1][cap-wg[idx]];
                }
                dp[idx][cap]=Math.max(pick, notPick);
            }
        }
        return dp[n-1][bag];
    }
    public static void main(String[] args) {
        int[] weight={1,2,4,5};
        int[] values={1,4,5,7};
        int bagCapacity=7;

        int n=weight.length;

       System.out.println( findTheMaxProfit(weight,values,n-1,bagCapacity));
       System.out.println(Memo(weight, values, n-1, bagCapacity));
       System.out.println(tab(weight, values, n, bagCapacity));
    }
}
