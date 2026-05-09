import java.util.*;

public class slidingWindowMax {

   static class Info implements Comparable<Info>{

    int value;
    int idx;

    public Info(int value , int idx) {
        this.value=value;
        this.idx=idx;
    }
    public int compareTo(Info v2){
        return v2.value - this.value;
    }
    }

    public static ArrayList<Integer> windowMax(int[] arr,int k){
        ArrayList<Integer> list = new ArrayList<>();

        PriorityQueue<Info>pq = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(new Info(arr[i], i));
        }
        list.add(pq.peek().value);

        for(int i=k;i<arr.length;i++){
            while(pq.size()>0 && pq.peek().idx <= (i-k)){
                pq.remove();
            }
            pq.add(new Info(arr[i], i));
            list.add(pq.peek().value);
        }
        return list;
    }
    public static void main(String[] args) {
        int[] arr={1,3,-1,-3,5,3,6,7};
        int k=3;

        ArrayList<Integer> ans = windowMax(arr,k);
        System.out.println(ans);
    }
}
