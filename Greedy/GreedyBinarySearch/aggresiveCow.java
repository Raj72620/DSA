package Greedy.GreedyBinarySearch;
import java.util.*;

public class aggresiveCow {

    public static int solve(int[] arr, int n,int k ){
        Arrays.sort(arr);
        int low =1;
        int high =arr[n-1]-arr[0];

        int ans=0;

        while(low <= high){
            int mid =low+(high-low)/2;

            if(cowPlaced(arr,k,mid)){
                ans=mid;
                low=mid+1;
        }else{
            high=mid-1;
        }
    }
          return ans;
}
public static boolean cowPlaced(int[] arr,int k,int mid){
    int cowRemains=1;
    int lastPosition=arr[0];

    for(int i=1;i<arr.length;i++){
            if(arr[i]-lastPosition >=mid){
                cowRemains++;
                lastPosition=arr[i];
            }
            if(cowRemains>=k){
                return true;
            }
    }
    return false;
}
    public static void main(String[] args) {
        int[] arr={4,8,9,2,1};
        int n=arr.length;

       System.out.println( solve(arr,n,3));
    }
}
