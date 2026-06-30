package DP.oneDimensionalDP;

import java.util.Arrays;

public class ninjasTraining {

    //Recursion
    public static int maxPoint(int[][] arr,int day,int last){
        if(day==0){
            int maxAns=0;
            for(int i=0;i<3;i++){
                if(i!=last){
                    maxAns=Math.max(maxAns, arr[0][i]);
                }
            }
            return maxAns;
        }
        int maxAns=0;
        for(int i=0;i<3;i++){
            if(i!=last){
                int currPoint=arr[day][i]+maxPoint(arr, day-1, i);
                maxAns=Math.max(maxAns, currPoint);
            }
        }
        return maxAns; 
    }

    //Memoization

    public static int memo(int[][] arr){
        int n= arr.length;
        int[][] dp = new int[n][4];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return solve(arr,dp,n-1,3);
    }
    public static int solve(int[][] arr,int[][] dp,int day,int last){
        if(day==0){
            int maxAns=0;
            for(int i=0;i<3;i++){
                if(i!=last){
                    maxAns= Math.max(maxAns, arr[0][i]);
                }
            }
            return maxAns;
        }
        if(dp[day][last]!=-1){
            return dp[day][last];
        }
        int maxAns=0;
        for(int i=0;i<3;i++){
            if(i!=last){
                int currPoint = arr[day][i]+ solve(arr, dp, day-1, i);
                maxAns=Math.max(maxAns, currPoint);
            }
        }
        dp[day][last]=maxAns;
        return maxAns;
    }
    public static void main(String[] args) {
        int[][] points={{2,1,3},{3,4,6},{10,1,6},{8,3,7}};
        int n=4;
   
       System.out.println( maxPoint(points,n-1,3));

       System.out.println(memo(points));
    }
}
