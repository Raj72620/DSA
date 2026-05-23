package Graphs;

import java.util.*;

class pairs{
   
    int node;
    int wt;

    public pairs( int node , int wt) {
        this.node=node;
        this.wt=wt;
    }

    public static void dfs(int node,boolean[] vis , Stack<Integer> st,ArrayList<ArrayList<pairs>> graph){
        vis[node]=true;
        for(pairs neig : graph.get(node)){
            if(!vis[neig.node]){
                dfs(neig.node, vis, st, graph);
            }
        }
        st.push(node);
    }
    public static int[] shortestPath(int V , int e , int[][] arr){
        ArrayList<ArrayList<pairs>> graph = new ArrayList<>();
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++){
            int u=arr[i][0];
            int v=arr[i][1];
            int wt =arr[i][2];
            graph.get(u).add(new pairs(v, wt));
        }
        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i, visited, st, graph);
            }
        }
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0]=0;
        while(!st.isEmpty()){
            int node = st.pop();
            if(dist[node]!=Integer.MAX_VALUE){
                for(pairs neig : graph.get(node)){
                    int newDist = dist[node]+neig.wt;
                    if(newDist < dist[neig.node]){
                        dist[neig.node]=newDist;
                    }
                }
            }
        }
        for(int i=0;i<V;i++){
            if(dist[i]==Integer.MAX_VALUE){
                dist[i]=-1;
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int v=7;
        int e=8;
        
        int[][] arr={{0,1,2},{0,4,1},{1,2,2},{1,4,2},{2,3,1},{4,5,3},{5,3,4},{5,6,1}};
        int[] ans = shortestPath(v, e, arr);
        System.out.print(Arrays.toString(ans));
    }
}
