package Greedy;
import java.util.*;

public class MaxLenghtChainOfPari {
    public static int FindMaxLen(int[][] arr){
        Arrays.sort(arr,Comparator.comparingDouble(o->o[1]));

        int end = arr[0][1];
        int ChainLenght=1;

        for(int i=1;i<arr.length;i++){
            if(end<arr[i][0]){
                ChainLenght++;
                end=arr[i][1];
            }
        }
        return ChainLenght;
    }
    public static void main(String[] args) {
        int[][] arr={{1,2},{2,3},{3,4}};
        System.out.println(FindMaxLen(arr));
    }
    
}
