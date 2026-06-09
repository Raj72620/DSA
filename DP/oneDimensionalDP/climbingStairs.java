package DP.oneDimensionalDP;

public class climbingStairs {

    public static int findTotalWays(int n){
        if(n==0 || n==1) return 1;

        return findTotalWays(n-1)+findTotalWays(n-2);

    }
    public static void main(String[] args) {
        int n=3;
        System.out.println(findTotalWays(n));
    }
}