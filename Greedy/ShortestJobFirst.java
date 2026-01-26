package Greedy;
import java.util.*;
public class ShortestJobFirst {
    public static int findAvgSum(int[] brustTime){
        Arrays.sort(brustTime);

        int totalWaitingTIme=0;
        int prefixSum=0;
        for(int i=0;i<brustTime.length-1;i++){
            prefixSum+=brustTime[i];
            totalWaitingTIme+=prefixSum;
        }
        return totalWaitingTIme/(brustTime.length);
    
    }
    public static void main(String[] args) {
        int[] brustTime={6,2,8,3};
       System.out.println( findAvgSum(brustTime));
    }
    
}
