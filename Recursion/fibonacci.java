package Recursion;

public class fibonacci {
    public static int find(int n){
        if (n==0) return 0;
        if (n==1) return 1;

        return find(n-1)+find(n-2);
    }
    public static void main(String[] args) {
        int fibo=6;
       System.out.println( find(fibo));
    }
    
}
