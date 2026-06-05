package Graphs.shortestPaths;

import java.util.*;

public class cheapestFlight {

    static class Pair {
        int dest;
        int weight;

        Pair(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
    
    static class Info {
        int src;
        int cost;
        int steps;
        public Info(int src, int cost, int steps) {
            this.src = src;
            this.cost = cost;
            this.steps = steps;
        }
    }
public static int cheapestCost(int v, ArrayList<ArrayList<Pair>> graph,
                               int src, int dest, int k) {

    int[] dist = new int[v];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;

    Queue<Info> q = new LinkedList<>();
    q.add(new Info(src, 0, 0));

    while (!q.isEmpty()) {
        Info curr = q.remove();

        int sr = curr.src;
        int cost = curr.cost;
        int step = curr.steps;

        if (step > k) continue;

        for (Pair neig : graph.get(sr)) {

            if (cost + neig.weight < dist[neig.dest]) {
                dist[neig.dest] = cost + neig.weight;
                q.add(new Info(neig.dest, dist[neig.dest], step + 1));
            }
        }
    }

    return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
}

    public static void main(String[] args) {
        int[][] arr = {
            {0, 1, 100},
            {0, 3, 500},
            {1, 2, 100},
            {2, 3, 100}
        };

        int v = 4;

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < arr.length; i++) {
            int src = arr[i][0];
            int dest = arr[i][1];
            int wt = arr[i][2];
            graph.get(src).add(new Pair(dest, wt));
        }
        int ans = cheapestCost(v, graph, 0, 3, 1);
System.out.println(ans);
    }
}
