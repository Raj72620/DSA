package Graphs.MinimumSpanningTree;

public class ImplementingDisjoingSet {

    static class DisjointSet {

        int[] parent;
        int[] rank;

        public DisjointSet(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int findParent(int node) {

            if (parent[node] == node) {
                return node;
            }
            parent[node] = findParent(parent[node]);
            return parent[node];
        }

        void union(int u, int v) {
            int parentU = findParent(u);
            int parentV = findParent(v);

            if (parentU == parentV) {
                return;
            }

            if (rank[parentU] < rank[parentV]) {
                parent[parentU] = parentV;

            } else if (rank[parentU] > rank[parentV]) {
                parent[parentV] = parentU;
            } else {
                parent[parentV] = parentU;
                rank[parentU]++;
            }
        }
    }

    public static void main(String[] args) {
        DisjointSet set = new DisjointSet(7);

        set.union(1, 2);
        set.union(2, 3);
        set.union(4, 5);
        set.union(6, 7);
        set.union(5, 6);
        set.union(3, 7);

        if (set.findParent(1) == set.findParent(7)) {
            System.out.println("Same component");
            System.out.print(set.findParent(1));
        } else {
            System.out.print("Different component");
        }
    }
}
