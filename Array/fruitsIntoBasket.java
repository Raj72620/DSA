package Array;

import java.util.HashMap;

public class fruitsIntoBasket {

    public static int findMaxFruits(int[] arr , int basket){
        HashMap<Integer, Integer> map = new HashMap<>();
        int left =0 ;
        int right =0;
        int maxlen = 0;

        while(right < arr.length){
            map.put(arr[right], map.getOrDefault(arr[right], 0)+1);

            while(map.size() > basket){
                map.put(arr[left], map.get(arr[left])-1);
                if(map.get(arr[left])==0){
                    map.remove(arr[left]);
                }
                left++;
            }
            maxlen = Math.max(maxlen, right-left+1);
            right++;
        }
        return maxlen;
    }
    public static void main(String[] args) {
        int[] arr = {3,3,3,1,2,1,1,2,3,3,4};

        int basket =2;

        System.out.println(findMaxFruits(arr,basket));
    }
    
}
