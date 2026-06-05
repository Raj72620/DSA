package Graphs.Basics;

import java.util.*;

//Cycle detection in Directed graph using DFS and BFS

// DFS -> approach using two boolean visited (vis , path vis)

//BFS -> Using topological sort 

public class cycleDetectionDG {

    static class Edges {
        int src;
        int dest;

        public Edges(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void insert(ArrayList<Edges>[] graph, int v) {

        // Directed graph edges
        graph[0].add(new Edges(0, 1));
        graph[0].add(new Edges(0, 2));

        graph[1].add(new Edges(1, 3));

        graph[2].add(new Edges(2, 3));
        graph[2].add(new Edges(2, 4));

        graph[3].add(new Edges(3, 4));

        // Example cycle:
        // 4 -> 2 creates cycle: 2 -> 3 -> 4 -> 2
        graph[4].add(new Edges(4, 2));
    }

    // DFS -> approach using two boolean visited (vis , path vis)
    public static boolean cycleDetectionDG(ArrayList<Edges>[] graph) {
        boolean[] vis = new boolean[graph.length];
        boolean[] pathVis = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (cycleDetectionDGUtil(graph, vis, pathVis, i)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean cycleDetectionDGUtil(ArrayList<Edges>[] graph,boolean[] vis, boolean[] pathVis, int start) {

        vis[start] = true;
        pathVis[start] = true;

        for (int i = 0; i < graph[start].size(); i++) {
            Edges ed = graph[start].get(i);

            if (!vis[ed.dest]) {
                if (cycleDetectionDGUtil(graph, vis, pathVis, ed.dest)) {
                    return true;
                }
            } else if (pathVis[ed.dest]) {
                return true;
            }
        }
        pathVis[start] = false;
        return false;
    }


    //BFS -> Using topological sort

     public static boolean topoSortBfs(ArrayList<Edges>[] graph) {
    int[] inDegree = new int[graph.length];

    for (int i = 0; i < graph.length; i++) {
        for (int j = 0; j < graph[i].size(); j++) {
            Edges p = graph[i].get(j);
            inDegree[p.dest]++;
        }
    }
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < inDegree.length; i++) {
        if (inDegree[i] == 0) {
            q.add(i);
        }
    }
    int count =0;
    while (!q.isEmpty()) {
        int curr = q.remove();
        System.out.print(curr + " ");
             count++;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edges p = graph[curr].get(i);
            inDegree[p.dest]--;
            if (inDegree[p.dest] == 0) {
                q.add(p.dest);
            }
        }
    }
    return count==inDegree.length;
}

    public static void main(String[] args) {
        int v = 5;

        ArrayList<Edges>[] graph = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        insert(graph, v);

        System.out.println(cycleDetectionDG(graph));
    }
}