package Recursion;

public class findFirstOccurenceEle {
    public static int firstOcc(int[] arr , int key , int i){
        if(i==arr.length-1){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return firstOcc(arr, key, i+1);
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,4,7};
        int key=4;
        int i=0;
         System.out.println( firstOcc(arr,key,i));
    }   
}
