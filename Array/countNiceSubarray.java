package Array;

public class countNiceSubarray {
    public static int niceSubarray(int[] arr , int k){
        return findNiceSubarr(arr, k)-findNiceSubarr(arr, k-1);
    }
    public static int findNiceSubarr(int[] arr , int k){
        if(k<0) return 0;
        int left=0;
        int right=0;
        int oddCount=0;
        int count =0;
        while(right<arr.length){
            if(arr[right]%2!=0){
                oddCount++;
            }
            while(oddCount > k){
                if(arr[left]%2!=0){
                    oddCount--;
                }
                left++;
            }
            count+=right-left+1;
            right++;
        }
            return count;
    }
    public static void main(String[] args) {
        int[] arr={1,1,0,1,1};
        int k=3;

        System.out.println(niceSubarray(arr,k));
    }
}
