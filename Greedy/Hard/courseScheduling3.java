package Greedy.Hard;
import java.util.*;
public class courseScheduling3 {

    public static int findMaxCourses(int[][] arr){
        Arrays.sort(arr,(a,b)->a[1]-b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        int currTime =0;
        for(int[] course: arr){
            int duration=course[0];
            int deadLine=course[1];

            currTime+=duration;
            pq.add(duration);

            if(currTime > deadLine){
                currTime-=pq.remove();
            }
        }
            return pq.size();
    }
    public static void main(String[] args) {
        int arr[][]={{100,200},{200,1300},{1000,1250},{2000,3200}};
       System.out.println( findMaxCourses(arr));
    }
}
