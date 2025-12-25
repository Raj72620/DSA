package StackQueue;
import java.util.*;

//Sliding window maximum


public class DequeProb1 {
        public static ArrayList<Integer> slidingWindowMax(int[] arr, int k) {
        Deque<Integer> deque = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        if (arr == null || arr.length == 0 || k <= 0) {
            return result;
        }
        
        for (int i = 0; i < k; i++) {

            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        

        for (int i = k; i < arr.length; i++) {
            result.add(arr[deque.peekFirst()]);

            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        result.add(arr[deque.peekFirst()]);
        
        return result;
    }
    public static void main(String[] args) {
               int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        ArrayList<Integer> result = slidingWindowMax(arr, k);
        
        // Print the result
        System.out.println("Sliding Window Maximum:");
        for (int num : result) {
            System.out.print(num + " ");
        }
        
    }
    
}
