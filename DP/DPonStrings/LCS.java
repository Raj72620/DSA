package DP.DPonStrings;

//Longest common subsequence

public class LCS {

    //Recursion

    public static int solve(String s1, String s2, int idx1, int idx2){
        if(idx1<0 || idx2<0) return 0;

        if(s1.charAt(idx1)==s2.charAt(idx2)){
            return 1+solve(s1, s2, idx1-1, idx2-1);
        }
        return Math.max(solve(s1, s2, idx1-1, idx2), solve(s1, s2, idx1, idx2-1));
        }

    // Memoization

    public static int memo(String s1, String s2, int[][] dp,int idx1, int idx2){

        if(idx1<0 || idx2<0) return 0;

        if(dp[idx1][idx2]!=-1) {
            return dp[idx1][idx2];
        }
        if(s1.charAt(idx1)==s2.charAt(idx2)){
            return dp[idx1][idx2] = 1+memo(s1, s2, dp, idx1-1, idx2-1);
        }
            return dp[idx1][idx2]= Math.max(memo(s1, s2, dp, idx1-1, idx2), memo(s1, s2, dp, idx1, idx2-1));
    }

    //Tabulation
    public static int tab(String s1, String s2){
        int n= s1.length();
        int m= s2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String s1= "ABCBDAB";
        String s2="BDCABA";
        int n= s1.length();
        int m= s2.length();

        int[][] dp = new int[n][m];
        for(int[] row : dp){
        java.util.Arrays.fill(row,-1);
        }

       System.out.println( solve(s1,s2,n-1,m-1));

       System.out.println(memo(s1, s2, dp, n-1, m-1));

       System.out.println(tab(s1, s2));

    }
}
