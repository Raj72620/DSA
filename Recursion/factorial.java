package Recursion;

public class factorial {
    public static int findFact(int n){
        if(n==1){
            return 1;
        }
        return n*findFact(n-1);
    }
    public static void main(String[] args) {
        int fact=5;
        System.out.println(findFact(fact));
    }
    
}
