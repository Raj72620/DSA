package StackQueue;
import java.util.*;

public class Queues{
    public static ArrayList<Integer>  slidingWindowMax(int[] arr,int k) {
        Deque<Integer> d = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0;i<k;i++){
            while(!d.isEmpty() && arr[d.peekLast()]<=arr[i]){
                d.removeLast();
            }
            d.add(i);
        }

        for(int i=k;i<arr.length;i++){

            ans.add(arr[d.peekFirst()]);

            if(d.peekFirst() < i-k+1){
                d.removeFirst();
            }
            while(!d.isEmpty() && arr[d.peekLast()]<=arr[i]){
                d.removeLast();
            }
            d.add(i);
        }
         ans.add(arr[d.peekFirst()]);

         return ans;
    }
    
    public static void main(String[] args) {
    int[] arr ={1, 3, -1, -3, 5,3,6,7};
    int k=3;
    ArrayList<Integer> result = slidingWindowMax(arr, k);
     for (int num : result) {
            System.out.print(num + " ");
        }

    }
        
}