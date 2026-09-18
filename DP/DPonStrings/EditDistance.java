package DP.DPonStrings;
import java.util.*;

public class EditDistance {

    //Recursion

    public static int findMinOp(String s1, String s2, int i, int j){
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(s1.charAt(i)==s2.charAt(j)){
            return findMinOp(s1, s2, i-1, j-1);
        }
        int replace =1+findMinOp(s1, s2, i-1, j-1);
        int delete=1+findMinOp(s1, s2, i-1, j);
        int update=1+findMinOp(s1, s2, i, j-1);

        return Math.min(replace, Math.min(delete, update));
    }

    //Memoization

    public static int memo(String s1, String s2,int i,int j,int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(dp[i][j]!=-1) return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j)){
           return dp[i][j]=memo(s1, s2, i-1, j-1, dp);
        }
       int replace =1+findMinOp(s1, s2, i-1, j-1);
        int delete=1+findMinOp(s1, s2, i-1, j);
        int update=1+findMinOp(s1, s2, i, j-1);

        return dp[i][j]= Math.min(replace, Math.min(delete, update));
    }

    //Tabulation

    public static int tab(String s1, String s2){

        int n=s1.length();
        int m=s2.length();

        int[][] dp= new int[n+1][m+1];

        for(int i=0;i<=n;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=m;j++){
            dp[0][j]=j;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                int replace=1+dp[i-1][j-1];
                int delete=1+dp[i-1][j];
                int update=1+dp[i][j-1];

                dp[i][j]=Math.min(replace,Math.min(delete, update));
            }
        }
    }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String s1="horse";
        String s2="ros";

        int i=s1.length();
        int j=s2.length();

        int[][] dp = new int[i][j];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }
       System.out.println( findMinOp(s1,s2,i-1,j-1));

       System.out.println(memo(s1, s2, i-1, j-1, dp));

       System.out.println(tab(s1, s2));
    }
}
