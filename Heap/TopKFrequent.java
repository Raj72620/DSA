import java.util.*;

public class TopKFrequent {
    static class Info implements Comparable<Info> {
        int num;
        int freq;

        public Info(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
        @Override
        public int compareTo(Info other) {
            return other.freq - this.freq;
        }
    }
    public static ArrayList<Integer> topK(int[] arr, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : arr) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        PriorityQueue<Info> pq = new PriorityQueue<>();
        for(int key : map.keySet()) {

            pq.add(new Info(key, map.get(key)));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<k; i++) {
            ans.add(pq.remove().num);
        }
        return ans;
    }
    public static void main(String[] args) {

        int[] arr = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(topK(arr,k));
    }
}