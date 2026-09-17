package DP.DPonStrings;
import java.util.*;

public class longestCommonSubString {

    //Recursion
    public static int solve(String s1,String s2,int idx1, int idx2){
        if(idx1<0 || idx2<0) return 0;

        if(s1.charAt(idx1)==s2.charAt(idx2)){
            return 1+solve(s1, s2, idx1-1, idx2-1);
        }else{
            return solve(s1, s2, idx1-1, idx2-1);
        }
    }

    //Memoization
    public static int memo(String s1, String s2, int idx1,int idx2, int[][] dp){
            if(idx1<0 || idx2<0) return 0;

            if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];

            if(s1.charAt(idx1)==s2.charAt(idx2)){
                return dp[idx1][idx2]= 1+memo(s1, s2, idx1-1, idx2-1, dp);
            }else{
               return dp[idx1][idx2]= memo(s1, s2, idx1-1, idx2-1, dp);
            }
    }

    //Tabulation
    public static int tab(String s1,String s2){
        int n=s1.length();
        int m=s2.length();

        int[][] dp = new int[n+1][m+1];
        int maxLen=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                    maxLen=Math.max(maxLen, dp[i][j]);
                }else{
                    dp[i][j]=0;
                }
            }
        }
       return maxLen;
    }
    public static void main(String[] args) {
        String s1="abc";
        String s2="xbc";

        int idx1=s1.length();
        int idx2=s2.length();

        int[][] dp = new int[idx1][idx2];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }

        System.out.println(solve(s1,s2,idx1-1,idx2-1));

        System.out.println(memo(s1, s2, idx1-1, idx2-1, dp));

        System.out.println(tab(s1, s2));
        
    }
}
