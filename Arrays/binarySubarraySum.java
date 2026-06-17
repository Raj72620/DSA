package Arrays;

public class binarySubarraySum {
    public static int findsubArray(int[] arr , int goal){
        return getSubArray(arr,goal)-getSubArray(arr,goal-1);
    }
    public static int getSubArray(int[] arr, int goal){
         if(goal<0) return 0;

        int left=0;
        int right=0;
        int sum=0;
        int count=0;
        
        while(right<arr.length){
            if(arr[right]==1){
                sum++;
            }
            while(sum>goal){
                if(arr[left]==1){
                    sum--;
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
        int goal =2;
        System.out.println(findsubArray(arr, goal));
    }
    
}
