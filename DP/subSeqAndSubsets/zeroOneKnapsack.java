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
    
    public static void main(String[] args) {
        int[] weight={1,2,4,5};
        int[] values={1,4,5,7};
        int bagCapacity=7;

        int n=weight.length;

       System.out.println( findTheMaxProfit(weight,values,n-1,bagCapacity));
    }
}
