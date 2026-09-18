package DP.DPonStrings;
import java.util.*;

public class distinctSubSeq {

    //Recursion

    public static int solve(String s1,String s2, int idx1,int idx2){

        if(idx2<0) return 1;
        if(idx1<0) return 0;

        if(s1.charAt(idx1)==s2.charAt(idx2)){
          return solve(s1, s2, idx1-1, idx2-1)+solve(s1, s2, idx1-1, idx2);
        }
        return solve(s1, s2, idx1-1, idx2);
    }

    //Memoization 
    public static int memo(String s1, String s2, int idx1, int idx2,int[][] dp){

        if(idx2<0) return 1;
        if(idx1<0) return 0;

        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];

        if(s1.charAt(idx1)==s2.charAt(idx2)){
            return dp[idx1][idx2]= memo(s1, s2, idx1-1, idx2-1, dp)+memo(s1, s2, idx1-1, idx2, dp);
        }
        return dp[idx1][idx2]= memo(s1, s2, idx1-1, idx2, dp);
    }

    //Tabulation

    public static int tab(String s1, String s2){

        int n=s1.length();
        int m=s2.length();

        int[][] dp = new int[n+1][m+1];
        
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]= dp[i-1][j-1]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s1="rabbbit";
        String s2="rabbit";

        int n=s1.length();
        int m=s2.length();

        int[][] dp = new int[n][m];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        System.out.println(solve(s1,s2,s1.length()-1,s2.length()-1));

        System.out.println(memo(s1,s2,n-1,m-1,dp));

        System.out.println(tab(s1, s2));
    }
}
