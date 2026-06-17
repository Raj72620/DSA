package Arrays;

//Max consecutive ones - 2 and 3

public class maxConsecutiveOnes2 {

    public static int findMax(int[] arr , int k){
        int left=0;
        int right=0;
        int zeroCount=0;
        int maxLen =0;

        while(right < arr.length){
            if(arr[right]==0){
                zeroCount++;
            }
            while(zeroCount > k){
                if(arr[left]==0) zeroCount--;
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,1,1,0,0,0};
        int k=2;
        System.out.println(findMax(arr,k));
    }
    
}
