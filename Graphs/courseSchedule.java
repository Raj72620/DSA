package Graphs;
import java.util.*;

//BFS-Khans algo if my count == V then all course can be done else false;

public class courseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] inDegree = new int[numCourses];
        // Step 3: Convert prerequisites matrix into graph
        for (int i = 0; i < prerequisites.length; i++) {

            int course = prerequisites[i][0];
            int preCourse = prerequisites[i][1];

            graph[preCourse].add(course);
            inDegree[course]++;
        }
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        int count = 0;
        while (!q.isEmpty()) {

            int curr = q.remove();
            count++;

            for (int i = 0; i < graph[curr].size(); i++) {

                int neigh = graph[curr].get(i);
                inDegree[neigh]--;
                if (inDegree[neigh] == 0) {
                    q.add(neigh);
                }
            }
        }
        return count == numCourses;
    }
    
    public static void main(String[] args) {
        int[][] preRequisites ={{1,0},{2,0},{3,1},{3,2}};
        int numCourses=4;
        canFinish(numCourses, preRequisites);
    }
}
