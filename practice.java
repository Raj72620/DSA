
public class practice{

 
public static int solve(int[][] arr,int n,int m,int i,int j){
   if(i==0 && j==0){
      return arr[i][j];
   }
   if(i<0 || j<0) return Integer.MAX_VALUE;

   int left=solve(arr, n, m, i, j-1);
   int up = solve(arr, n, m, i-1, j);

   return arr[i][j]+Math.min(left, up);
}
    public static void main(String[] args) {
      int[][] arr={{5,9,6},{11,5,2}};
      int n=arr.length;
      int m=arr[0].length;
      System.out.println(solve(arr, n,m,n-1, m-1));
    }
}
