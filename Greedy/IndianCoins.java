package Greedy;
import java.util.*;

public class IndianCoins {
    public static int totalCount(int[] arr, int amount){
        Arrays.sort(arr);
        int balance=amount;
        int count=0;
        for(int i=arr.length-1;i>=0;i--){
            while(balance >= arr[i]){
                balance-=arr[i];
                count++;
                System.out.print(arr[i]+ " ");
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr={20,50,100,500,2000,1,2,5,10};
        int amount=121;
        System.out.println( "Max number of count is :" +totalCount(arr,amount));
    }
    
}
