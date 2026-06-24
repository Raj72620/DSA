
public class practice{

    public static int fun(int[] arr,int idx){
       if(idx == 0) return arr[0];
       if(idx < 0) return 0;

       int take=arr[idx]+fun(arr, idx-2); 
       int dontTake = fun(arr, idx-1);

       return Math.max(take, dontTake);
    }

    public static void main(String[] args) {
       int[] arr={2,1,4,9};
      System.out.println( fun(arr,arr.length-1));
    }
}
