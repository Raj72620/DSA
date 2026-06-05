package Graphs.Basics;

import java.util.*;

public class bfsDFSTraversal{

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
//BFS traversal 
    public static void bfsTraverse(ArrayList<Edges>[] graph ,int v){
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[v];

        q.add(0);
        while(!q.isEmpty()){
            int curr = q.remove();

            if(vis[curr]!=true){
                System.out.print(curr+ " ");
                vis[curr]=true;

                for(int i=0;i<graph[curr].size();i++){
                    Edges ed = graph[curr].get(i);
                    q.add(ed.dest);
                }
            }
        }
    }
    //DFS traversal 
        public static void dfs(ArrayList<Edges>[] graph, int curr,boolean [] vis){
        System.out.print(curr+ " ");
            vis[curr]=true;

             for(int i=0;i<graph[curr].size();i++){
                    Edges ed = graph[curr].get(i);
                if(!vis[ed.dest]){
                    dfs(graph, ed.dest, vis);
                }
            }
    }
 
    public static void main(String[] args) {
        int v=5;
        ArrayList<Edges>[] graph = new ArrayList[v];
       for(int i=0;i<v;i++){
            graph[i]=new ArrayList<>();
       }
       insert(graph, v);

       bfsTraverse(graph, v);

       dfs(graph, 0, new boolean[v]);

    }
    
}
