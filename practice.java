import java.util.*;


public  class practice{
    
    public static boolean preRequisites(int[][] arr , int numCourses){
        ArrayList<Integer>[] graph = new ArrayList[numCourses];

        for(int i=0;i<graph.length;i++){
            graph[i]= new ArrayList<>();
        }
        int[] inDegree = new int[numCourses];
        
        for(int[] ele : arr){
            int courses = ele[0];
            int prereq = ele[1];

            graph[prereq].add(courses);
            inDegree[courses]++;
        }
    }
    public static void main(String[] args) {
        int[][] arr={{1,0},{2,0},{3,1},{3,2}};
        int numCourses=4;
    }
}