package Recursion;

public class printReverse {
    public static void find(int n){
        if(n==1){
            System.out.print(n + " ");
            return;
        }
        System.out.print(n+ " ");
        find(n-1);
    }
    public static void main(String[] args) {
        int n=5;
        find(n);
    }
    
}
