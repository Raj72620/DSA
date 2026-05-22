import java.util.*;
public  class practice{

    public static boolean topoSort(int[][] edges , int V){

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        int[] indegree= new int[V];
        for(int[] ed : edges){
            int u=ed[0];
            int ve = ed[1];

            graph.get(u).add(ve);
            indegree[ve]++;
        }
        Queue<Integer>q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.remove();
           for(int neig : graph.get(curr)){
            indegree[neig]--;
            if(indegree[neig]==0){
                q.add(neig);
            }
           }
        }
         for(int i=0;i<indegree.length;i++){
            if(indegree[i]!=0) return false;
           }
        return true;
    }

  public static void main(String[] args) {
    int[][] edges = {{1, 3}, {2, 3}, {4, 1}, {4, 0}, {5, 0}, {5, 2}};
    int V=6;
    System.out.println(topoSort(edges, V));
    }
}