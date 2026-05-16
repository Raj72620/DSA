package Graphs;

import java.util.ArrayList;

public class cycleDetection {
      static class Edges{
        int src ;
        int dest;

        public Edges(int src , int dest) {
            this.src=src;
            this.dest=dest;
        }
    }
    public static void insert(ArrayList<Edges>[] graph,int v){
        graph[1].add(new Edges(1, 2));
         graph[1].add(new Edges(1, 3));

          graph[2].add(new Edges(2, 1));
           graph[2].add(new Edges(2, 3));
           graph[2].add(new Edges(2, 4));

            graph[3].add(new Edges(3, 1));
             graph[3].add(new Edges(3, 2));

               graph[4].add(new Edges(4, 2));

    }
    public static boolean detecCycle(ArrayList<Edges>[] graph){
        boolean[] vis = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(detectCycleUtil(graph,vis,i,-1)){
                return true;
            }
        } 
    }
        return false;
    }
    public static boolean detectCycleUtil(ArrayList<Edges>[] graph,boolean[] vis, int src , int par){
        vis[src]=true;
        for(int i=0;i<graph[src].size();i++){
            Edges ed = graph[src].get(i);
            if(!vis[ed.dest]){
                if(detectCycleUtil(graph, vis, ed.dest, src)){
                    return true;
                }
            }else if(vis[ed.dest] && ed.dest!=par){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int v=5;
        ArrayList<Edges>[] graph = new ArrayList[v];
       for(int i=0;i<v;i++){
            graph[i]=new ArrayList<>();
       }
       insert(graph, v);
       System.out.println(detecCycle(graph));
    }
}
