package Greedy;

import java.util.Arrays;

public class MinAbsoluteDiff {
    public static int findAbsDiff(int[] A , int[] B){
        Arrays.sort(A);
        Arrays.sort(B);

        int minAbs=0;
        for(int i=0;i<A.length;i++){
            minAbs+=Math.abs(A[i]-B[i]);
        }
        return minAbs;
    }
    public static void main(String[] args) {
        int[] A={2,3};
        int[] B={1,3};

        System.out.println(findAbsDiff(A,B));
    }
    
}
