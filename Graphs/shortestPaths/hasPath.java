package Graphs.shortestPaths;
import java.util.*;

public class hasPath{

    static class Edges{
        int src ;
        int dest;

        public Edges(int src , int dest) {
            this.src=src;
            this.dest=dest;
        }
    }
    public static void insert(ArrayList<Edges>[] graph,int v){
        graph[0].add(new Edges(0, 1));
         graph[0].add(new Edges(0, 2));

          graph[1].add(new Edges(1, 0));
           graph[1].add(new Edges(1, 3));

            graph[2].add(new Edges(2, 0));
             graph[2].add(new Edges(2, 3));
              graph[2].add(new Edges(2, 4));

               graph[3].add(new Edges(3, 1));
                graph[3].add(new Edges(3, 2));
                 graph[3].add(new Edges(3, 4));

                  graph[4].add(new Edges(4, 2));
                   graph[4].add(new Edges(4, 3));
    }
  
    
    public static boolean isPathExist(ArrayList<Edges>[] graph , int sr , int des, boolean [] vis,ArrayList<Integer> path){
        path.add(sr);
            if(sr==des){
                System.out.print(path);
                return true;
            } 
            vis[sr]=true;
            for(int i=0;i<graph[sr].size();i++){
                Edges e = graph[sr].get(i);
                if(!vis[e.dest] && isPathExist(graph, e.dest, des, vis,path)){
                    return true;
                }
            }   
            path.remove(path.size()-1);
            return false;
    }
    public static void main(String[] args) {
        int v=5;
        ArrayList<Edges>[] graph = new ArrayList[v];
       for(int i=0;i<v;i++){
            graph[i]=new ArrayList<>();
       }
       insert(graph, v);
       ArrayList<Integer> path = new ArrayList<>();
       System.out.print(isPathExist(graph, 0, 4, new boolean[v],path));

    }
    
}
