
import java.util.*;

public class bipartiteGraph {

    static class Pairs {

        int src;
        int dest;

        Pairs(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void insert(int v, ArrayList<Pairs>[] graph) {

        graph[0].add(new Pairs(0, 1));
        graph[0].add(new Pairs(0, 2));

        graph[1].add(new Pairs(1, 0));
        graph[1].add(new Pairs(1, 3));

        graph[2].add(new Pairs(2, 0));
        graph[2].add(new Pairs(2, 3));
        graph[2].add(new Pairs(2, 4));

        graph[3].add(new Pairs(3, 1));
        graph[3].add(new Pairs(3, 2));
        graph[3].add(new Pairs(3, 4));

        graph[4].add(new Pairs(4, 2));
        graph[4].add(new Pairs(4, 3));
    }

    //Using BFS 
    public static boolean isBipartite(ArrayList<Pairs>[] graph) {
        int[] color = new int[graph.length];

        Arrays.fill(color, -1);

        for (int i = 0; i < graph.length; i++) {

            if (color[i] == -1) {

                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                color[i] = 0;

                while (!q.isEmpty()) {

                    int node = q.remove();

                    for (int j = 0; j < graph[node].size(); j++) {

                        Pairs ed = graph[node].get(j);
                        int neigh = ed.dest;

                        if (color[neigh] == -1) {
                            color[neigh] = 1 - color[node];
                            q.add(neigh);
                        } else if (color[neigh] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    //using DFS
    public static boolean isBipartiteDfs(ArrayList<Pairs>[] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, color, graph)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean dfs(int node, int col, int[] color, ArrayList<Pairs>[] graph) {

        color[node] = col;

        for (int i = 0; i < graph[node].size(); i++) {
            Pairs p = graph[node].get(i);

            if (color[p.dest] == -1) {
                if (!dfs(p.dest, 1 - col, color, graph)) {
                    return false;
                }
            } else if (color[p.dest] == col) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int v = 5;

        ArrayList<Pairs>[] graph = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        insert(v, graph);

        System.out.println(isBipartite(graph));     
        System.out.println(isBipartiteDfs(graph));  
    }
}
