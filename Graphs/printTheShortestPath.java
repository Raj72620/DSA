package Graphs;

import java.util.*;

public class printTheShortestPath {

    static class pairs {

        int dest;
        int weigth;

        public pairs(int dest, int weight) {
            this.dest = dest;
            this.weigth = weight;
        }
    }

    public static ArrayList<Integer> printPath(int[][] arr, int v, int e, int src, int dest) {
        ArrayList<ArrayList<pairs>> graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {

            int sr = arr[i][0];
            int vd = arr[i][1];
            int wt = arr[i][2];
            graph.get(sr).add(new pairs(vd, wt));
        }
        int[] dist = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        int[] par = new int[v + 1];
        for (int i = 0; i <= v; i++) {
            par[i] = i;
        }

        PriorityQueue<pairs> pq = new PriorityQueue<>((a, b) -> a.weigth - b.weigth);
        pq.add(new pairs(src, 0));

        while (!pq.isEmpty()) {
            pairs curr = pq.remove();
            int node = curr.dest;
            int wt = curr.weigth;
            if (wt > dist[node]) continue;
            for (pairs neig : graph.get(node)) {
                int totalDist = wt + neig.weigth;

                if (totalDist < dist[neig.dest]) {
                    dist[neig.dest] = totalDist;
                    pq.add(new pairs(neig.dest, totalDist));
                    par[neig.dest] = node;
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();

        int curr = dest;

        while (curr != src) {
            ans.add(curr);
            curr = par[curr];
        }

        ans.add(src);
        Collections.reverse(ans);

        return ans;

    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 2}, {1, 4, 1}, {2, 1, 2}, {2, 3, 4}, {2, 5, 5}, {3, 2, 4}, {3, 4, 3}, {3, 5, 1}, {4, 1, 1}, {4, 3, 3}, {5, 2, 5}, {5, 3, 1}};
        int v = 5;
        int e = arr.length;
        int src = 1;
        int dest = 5;

        ArrayList<Integer> ans = printPath(arr, v, e, src, dest);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
