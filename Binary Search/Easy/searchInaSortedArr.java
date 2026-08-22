public class searchInaSortedArr {
    //you are given a sorted arr find the idx of the target in that arr
    //Not in the arr return -1

    public static int find(int[] arr,int tar){

        int start=0;
        int end=arr.length-1;

        while(start<=end){
            int mid=start+(end-start)/2;

            if(tar==arr[mid]) {
                return mid;
            }
            
            else if(tar < arr[mid]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8};
        int target =7;
        System.out.println(find(arr,target));
    }
}
