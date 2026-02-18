package Recursion;

public class totalPathInMaze {
    public static int findTotalCount(int n, int m , int i , int j ){

        if(i==n-1){
          return 1;
        }
        if(j==m-1){
            return 1;
        }
      int count= findTotalCount(n, m, i+1, j) + findTotalCount(n, m, i, j+1);

            return count;
    }
    public static void main(String[] args) {
        int n=3;
        int m=3;

    System.out.println(findTotalCount(n,m ,0 ,0));
    }
    
}
