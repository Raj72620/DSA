package Arrays;
//Sub array sum equals k (Prefix sum + map approach)

import java.util.HashMap;


public class subArrSumEqualsK {

    public static int maxSubArr(int[] arr , int k){
        HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);

    int sum = 0;
    int count = 0;
    for (int i=0;i<arr.length;i++) {
        sum += arr[i];

        if (map.containsKey(sum - k)) {
            count += map.get(sum - k);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return count;
    }
    public static void main(String[] args) {
        int[] arr={3,4,-7,1,3,3,1,-4};
        int k=7;
        System.out.println(maxSubArr(arr, k));
    }
}
