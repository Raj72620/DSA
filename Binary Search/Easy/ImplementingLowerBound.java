
public class ImplementingLowerBound {

    public static int findLowerBound(int[] arr,int tar){
        int low=0;
        int high=arr.length-1;
        int ans=arr.length;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]>=tar){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9};
        int tar=6;
        System.out.println(findLowerBound(arr,tar));
    }
}
