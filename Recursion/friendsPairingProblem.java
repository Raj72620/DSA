package Recursion;

public class friendsPairingProblem {
    public static int totalWays(int n){
        if(n==1 || n==2) return n;

        return totalWays(n-1) + (n-1)*totalWays(n-2);
    }
    public static void main(String[] args) {
        int n=3;
        System.out.println(totalWays(n));
    }
    
}
