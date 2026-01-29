package Recursion;

public class binaryString {
    public static void nonConsecutive(int n , int lastPlaced , String str){

        if(n==0) {
            System.out.print(str +" ");
            return;
        }
        nonConsecutive(n-1, 0, str+"0");
        if(lastPlaced==0){
            nonConsecutive(n-1, 1, str+"1");
        }
    }
    public static void main(String[] args) {
        int n=3;
        nonConsecutive(n , 0 , "");
    }
    
}
