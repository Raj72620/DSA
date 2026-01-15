package Greedy;

import java.util.*;

public class ActivitySelection {

    // for sorted end values 

    public static void sortedActivity(int[] start , int[] end){
                ArrayList<Integer> ans = new ArrayList<>();
        int lastEnd = end[0];
        ans.add(0);
       int max=1;
        for(int i=1;i<end.length;i++){
            if(lastEnd<=start[i]){
                ans.add(i);
                max++;
                lastEnd=end[i];
            }
        }
        System.out.println("The max activity can be performed is :" + max);
        for(int i=0;i<ans.size();i++){
            System.out.print("A" + ans.get(i)+ " ");
        }
    }

    // for unsorted end values -> sort the array using lamda function -> sort by end times 
    // create a 2D matrix whihc stores idx , start values and sorted end values 

    public static void unsortedActivity(int[] start , int[] end){
        int[][] activity = new int[start.length][3];
        for(int i=0;i<start.length;i++){
            activity[i][0]=i;
            activity[i][1]=start[i];
            activity[i][2]=end[i];
        }
        Arrays.sort(activity , (a,b)-> a[2]-b[2]);
        int max =0;
         ArrayList<Integer> result = new ArrayList<>();

         max=1;
         result.add(activity[0][0]);

         int lastEnd=activity[0][2];

         for(int i=1;i<end.length;i++){
            if(lastEnd <= activity[i][1]){
            result.add(activity[i][0]);
            max++;
            lastEnd=activity[i][2];
         }
        }
        System.out.println(max);

        for(int i=0;i<result.size();i++){
            System.out.print("A" + result.get(i)+ " ");
        }
    }
    
    public static void main(String[] args) {
        int[] start={1,2,3};
        int[] end={4,3,6};
        unsortedActivity(start, end);
}
}