
public class practice {

  public static int solve(int[] arr,int idx){
      if(idx==0) return arr[0];

      int notPick=solve(arr, idx-1);

      int pick=Integer.MIN_VALUE;
      if(idx>0){
        pick=arr[idx]*solve(arr, idx-1);
      }
      return Math.max(pick, notPick);
  }
    public static void main(String[] args) {

     int[] arr={2,3,-2,4};
    System.out.println( solve(arr,arr.length-1));
    }
}