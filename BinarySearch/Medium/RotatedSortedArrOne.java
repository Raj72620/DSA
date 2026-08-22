package BinarySearch.Medium;

public class RotatedSortedArrOne {

    public static int findIdx(int[] arr,int tar){
    int start=0;
    int end=arr.length-1;

    while(start<=end){
        int mid=start+(end-start)/2;

        if(arr[mid]==tar) return mid;

        if(arr[start]<=arr[mid]){
            if(arr[mid]>=tar && arr[start]<=tar){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }else{
            if(arr[mid]<= tar && tar<=arr[end]){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
    }
    return -1;
}
    public static void main(String[] args) {
         int[] arr={4,5,6,7,1,2,3};
    int tar =5;
    System.out.println(findIdx(arr,tar));
    }
}
