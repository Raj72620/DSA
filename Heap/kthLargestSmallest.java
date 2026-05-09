import java.util.*;


public class kthLargestSmallest {

    //kth largest element -> Min Heap approach
    public static int largestkthEle(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int ele:arr){
            pq.add(ele);
            if(pq.size()>k){
                pq.remove();
            }
        }
        return pq.peek();
    }

    //kth smallest ele -> Max heap approach

    public static int smallestkthEle(int[] arr,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int a : arr){
            pq.add(a);

            if(pq.size()>k){
                pq.remove();
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] arr={3,1,5,12,2,11};
        int k=2;
        System.out.println("kth largest ele : " +largestkthEle(arr,k));

        System.out.println("kth smallest ele : " +smallestkthEle(arr, k));

    }
}
