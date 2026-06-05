package Graphs.Basics;
import java.util.*;

//Cycle detection in Undirected graph using DFS and BFS

public class cycleDetection {

    static class Edges {
        int src;
        int dest;

        public Edges(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
    static class Info {
        int node;
        int parent;

        public Info(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }
    public static void insert(ArrayList<Edges>[] graph, int v) {
        graph[1].add(new Edges(1, 2));
        graph[1].add(new Edges(1, 3));

        graph[2].add(new Edges(2, 1));
        graph[2].add(new Edges(2, 3));
        graph[2].add(new Edges(2, 4));

        graph[3].add(new Edges(3, 1));
        graph[3].add(new Edges(3, 2));

        graph[4].add(new Edges(4, 2));
    }

    // Detect cycle using DFS
    public static boolean detecCycleDFS(ArrayList<Edges>[] graph) {
        boolean[] vis = new boolean[graph.length];

        for (int i = 1; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtilDFS(graph, vis, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtilDFS(ArrayList<Edges>[] graph, boolean[] vis, int src, int par) {
        vis[src] = true;

        for (int i = 0; i < graph[src].size(); i++) {
            Edges ed = graph[src].get(i);

            if (!vis[ed.dest]) {
                if (detectCycleUtilDFS(graph, vis, ed.dest, src)) {
                    return true;
                }
            } else if (ed.dest != par) {
                return true;
            }
        }
        return false;
    }

    // BFS wrapper for disconnected graph
    public static boolean detecCycleBFS(ArrayList<Edges>[] graph) {
        boolean[] vis = new boolean[graph.length];

        for (int i = 1; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtilBFS(graph, vis, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    

    // Detect cycle using BFS
    public static boolean detectCycleUtilBFS(ArrayList<Edges>[] graph, boolean[] vis, int start) {
        Queue<Info> q = new LinkedList<>();

        q.add(new Info(start, -1));
        vis[start] = true;

        while (!q.isEmpty()) {
            Info curr = q.remove();

            for (int i = 0; i < graph[curr.node].size(); i++) {
                Edges ed = graph[curr.node].get(i);

                int neigh = ed.dest;

                // Case 1: neighbour not visited
                if (!vis[neigh]) {
                    vis[neigh] = true;
                    q.add(new Info(neigh, curr.node));
                }

                // Case 2: neighbour already visited and not parent
                else if (neigh != curr.parent) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 5;

        ArrayList<Edges>[] graph = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        insert(graph, v);

        System.out.println("Cycle using DFS: " + detecCycleDFS(graph));
        System.out.println("Cycle using BFS: " + detecCycleBFS(graph));
    }
}