package Recursion;

public class exponentialPow {
    public static int pow(int x , int n){    // This takes Time Complexity: O(n)
                                            // Space Complexity: O(n)
        if(n==1){
            return x;
        }
        return x*pow(x, n-1);
    }

    public static int powOptimized(int x,int n){     // This takes Time Complexity: O(log n)
                                                    // Space Complexity: O(log n)
        if(n==0){
            return 1;
        }
        int halfPow = powOptimized(x, n/2);
        int halfPowSq=halfPow*halfPow;
        if(n%2!=0){
            halfPowSq = x*halfPowSq;
        }
        return halfPowSq;
    }
    public static void main(String[] args) {
        int x=2;
        int n=5;
        System.out.println(powOptimized(x, n));
    }
    
}
