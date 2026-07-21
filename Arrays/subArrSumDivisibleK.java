package Arrays;
//Sub array sum divisible by k (Prefix sum + map approach)

import java.util.HashMap;


public class subArrSumDivisibleK {

    public static boolean maxSubArr(int[] arr , int k){
        HashMap<Integer, Integer> map = new HashMap<>();

    map.put(0, 1);
    int sum = 0;
    for (int i=0;i<arr.length;i++) {
        sum += arr[i];
        int rem = sum%k;
        if(rem<0){
            rem+=k;
        }
        if (map.containsKey(rem)) {
            return true;
        }
        map.put(rem, map.getOrDefault(rem, 0) + 1);
    }
    return false;
    }

   
    public static void main(String[] args) {
        int[] arr={1,2,6};
        int k=5;
        System.out.println(maxSubArr(arr, k));
    }
}
