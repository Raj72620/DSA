package Greedy;
import java.util.*;
public class practice {
    public static void main(String[] args) {
        int[][] arr = { {3,2,1},{6,4,5},{9,8,7}};

        Arrays.sort(arr,(a,b)->a[0]-b[0]);

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");

            }
            System.out.println();
        }
    }
    
}
