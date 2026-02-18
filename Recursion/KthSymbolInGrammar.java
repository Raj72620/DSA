package Recursion;

public class KthSymbolInGrammar {

    public static int kthGrammer(int n, int k){
        if(k==1) return 0;

        int parent = kthGrammer(n-1, (k+1)/2) ;

        if(parent==0){
            if(k%2==1){
                return 0;
            }else{
                return 1;
            }
        }
        else{
            if(k%2==1){
                return 1;
            }else{
                return 0;
            }
        }
    }
    public static void main(String[] args) {
        int n=4;
        int k=5;

        System.out.println(kthGrammer(n,k));
    }
    
}
