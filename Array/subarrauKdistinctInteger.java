package Array;
import java.util.HashMap;

//sub array with k different integer

public class subarrauKdistinctInteger {

    public static int kthDistinct(int[] arr , int k){
        return findkthDistinct(arr,k)-findkthDistinct(arr,k-1);
    }
    public static int findkthDistinct(int[] arr , int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int left =0;
        int right =0;
        int count=0;
        while(right<arr.length){
            map.put(arr[right], map.getOrDefault(arr[right], 0)+1);

            while(map.size() >k){
              
                map.put(arr[left], map.get(arr[left])-1);
                if(map.get(arr[left])==0){
                    map.remove(arr[left]);
                }
                left++;
            }
            
            count+=right-left+1;
            right++;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr={2,1,1,1,3,4,3,2};
        int k=3;
        System.out.println(kthDistinct(arr,k));
    }
}
