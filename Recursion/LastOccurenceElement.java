package Recursion;

public class LastOccurenceElement {
   public static int lastOcc(int[] arr,int key , int i){
        if(i==arr.length){
            return -1;
        }
      int check =  lastOcc(arr, key, i+1);
        if(check==-1 && arr[i]==key){
             return i;
        }
        return check;
    } 
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,4,7};
        int key=4;
        int i=0;
        System.out.println(lastOcc(arr,key,i));
    }    
}
