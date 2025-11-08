
 public class practice {
public static int lastOcc(int[] arr, int target,int i) {
        if(i==arr.length){
            return -1;
        }
        lastOcc(arr, target, i+1);
        if(arr[i]==target){
            return i;
        }
        return i;
    }
public static void main(String[] args) {
    int[] arr={1,2,3,4,5,4};
        int target = 4; 
        int i=0;   
     System.out.println(lastOcc(arr, target,i));

}
}