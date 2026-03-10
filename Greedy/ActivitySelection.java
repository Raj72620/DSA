package Greedy;

import java.util.*;

public class ActivitySelection {

    // for sorted finsih values 

    public static void sortedActivity(int[] start , int[] finsih){
                ArrayList<Integer> ans = new ArrayList<>();
        int lastfinsih = finsih[0];
        ans.add(0);
       int max=1;
        for(int i=1;i<finsih.length;i++){
            if(lastfinsih<=start[i]){
                ans.add(i);
                max++;
                lastfinsih=finsih[i];
            }
        }
        System.out.println("The max activity can be performed is :" + max);
        for(int i=0;i<ans.size();i++){
            System.out.print("A" + ans.get(i)+ " ");
        }
    }

    // for unsorted finsih values -> sort the array using lamda function -> sort by finsih times 
    // create a 2D matrix whihc stores idx , start values and sorted finsih values 

    public static void unsortedActivity(int[] start , int[] finsih){
        int[][] activity = new int[start.length][3];
        for(int i=0;i<start.length;i++){
            activity[i][0]=i;
            activity[i][1]=start[i];
            activity[i][2]=finsih[i];
        }
        Arrays.sort(activity , (a,b)-> a[2]-b[2]);
        int max =0;
         ArrayList<Integer> result = new ArrayList<>();

         max=1;
         result.add(activity[0][0]);

         int lastfinsih=activity[0][2];

         for(int i=1;i<finsih.length;i++){
            if(lastfinsih <= activity[i][1]){
            result.add(activity[i][0]);
            max++;
            lastfinsih=activity[i][2];
         }
        }
        System.out.println(max);

        for(int i=0;i<result.size();i++){
            System.out.print("A" + result.get(i)+ " ");
        }
    }
    
    public static void main(String[] args) {
        int[] start={1,2,3};
        int[] finsih={4,3,6};
        unsortedActivity(start, finsih);
}
}