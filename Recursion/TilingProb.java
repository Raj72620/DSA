package Recursion;

public class TilingProb {
    public static int totalWays(int n){
        if(n==0 || n==1) return 1;

        return totalWays(n-1) + totalWays(n-2);
    }
    public static void main(String[] args) {
        int n=3;
        System.out.println(totalWays(n));

    }
    
}
