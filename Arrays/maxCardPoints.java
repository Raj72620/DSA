package Arrays;

public class maxCardPoints{
    public static int maxCardPoints(int[] arr , int k){
        int leftSum =0;
        int rightSum =0;
        
        int maxSum =0;

        for(int i=0;i<=k-1;i++){
            leftSum+=arr[i];
        }
        for(int i=k-1;i>=0;i--){
            leftSum -= arr[i];

            rightSum+=arr[arr.length-(k-i)];

            maxSum=Math.max(maxSum, leftSum+rightSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
       int[] arr = {6,2,3,4,7,2,1,7,1};
       int k=4;

       System.out.println(maxCardPoints(arr,k));
        }
    }
