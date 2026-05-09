import java.util.*;
public class connecteNropes {
    public static int findTotalCost(int[] arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int ele : arr){
            pq.add(ele);
        }
        int totalCost=0;
        while(pq.size()>1){
            int firstSmallest=pq.remove();
            int secondSmallest=pq.remove();

            int cost = firstSmallest+secondSmallest;
            totalCost+=cost;
            pq.add(cost);
        }
        return totalCost;
    }
    public static void main(String[] args) {
        int[] arr={4,3,2,6};
        System.out.println(findTotalCost(arr));
    }
}
