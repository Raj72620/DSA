package Graphs.TopoSort;

import java.util.*;

public class topologicalSort {

    static class Pairs {

        int src;
        int dest;

        Pairs(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void insert(int v, ArrayList<Pairs>[] graph) {

        graph[2].add(new Pairs(2, 3));

        graph[3].add(new Pairs(3, 1));

        graph[4].add(new Pairs(4, 0));
        graph[4].add(new Pairs(4, 1));

        graph[5].add(new Pairs(5, 0));
        graph[5].add(new Pairs(5, 2));
    }

    // DFS method -> using Stack 
    public static void dfs(int node, ArrayList<Pairs>[] graph, boolean[] vis, Stack<Integer> st) {
        vis[node] = true;

        for (int i = 0; i < graph[node].size(); i++) {
            Pairs p = graph[node].get(i);
            if (!vis[p.dest]) {
                dfs(p.dest, graph, vis, st);
            }
        }
        st.push(node);
    }
    public static int[] topoSort(ArrayList<Pairs>[] graph) {
        boolean[] vis = new boolean[graph.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                dfs(i, graph, vis, st);
            }
        }
        int[] ans = new int[graph.length];
        int idx = 0;
        while (!st.isEmpty()) {
            ans[idx++] = st.pop();
        }
        return ans;
    }

    //uisng BFS -> Khan's Algorithm 
   public static void topoSortBfs(ArrayList<Pairs>[] graph) {
    int[] inDegree = new int[graph.length];

    // Step 1: Calculate indegree
    for (int i = 0; i < graph.length; i++) {
        for (int j = 0; j < graph[i].size(); j++) {
            Pairs p = graph[i].get(j);
            inDegree[p.dest]++;
        }
    }
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < inDegree.length; i++) {
        if (inDegree[i] == 0) {
            q.add(i);
        }
    }
    // Step 3: BFS
    while (!q.isEmpty()) {
        int curr = q.remove();
        System.out.print(curr + " ");

        for (int i = 0; i < graph[curr].size(); i++) {
            Pairs p = graph[curr].get(i);
            inDegree[p.dest]--;
            if (inDegree[p.dest] == 0) {
                q.add(p.dest);
            }
        }
    }
}
    public static void main(String[] args) {
        int v = 6;

        ArrayList<Pairs>[] graph = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        insert(v, graph);

        // int[] ans = topoSort(graph);
        // for (int ele : ans) {
        //     System.out.print(ele + " ");
        // }
        topoSortBfs(graph);
    }
}
