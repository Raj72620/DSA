import java.util.*;
public class connecteNropes {
    public static void main(String[] args) {
        int[] arr={4,3,2,6};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        int minPop = pq.remove();
        int totalMinSum=0;
        while(!pq.isEmpty()){
            minPop+=pq.remove();
            totalMinSum+=minPop;
        }
        System.out.println(totalMinSum);
    }
}
