package Array;
//Sub array sum divisible by k (Prefix sum + map approach)

import java.util.HashMap;


public class subArrSumDivisibleK {

    public static int maxSubArr(int[] arr , int k){
        HashMap<Integer, Integer> map = new HashMap<>();

    map.put(0, 1);
    int sum = 0;
    int count = 0;
    for (int i=0;i<arr.length;i++) {
        sum += arr[i];
        int rem = sum%k;
        if(rem<0){
            rem+=k;
        }
        if (map.containsKey(rem)) {
            count+=map.get(rem);
        }
        map.put(rem, map.getOrDefault(rem, 0) + 1);
    }
    return count;
    }
    public static void main(String[] args) {
        int[] arr={4, 5, 0, -2, -3, 1};
        int k=5;
        System.out.println(maxSubArr(arr, k));
    }
}
