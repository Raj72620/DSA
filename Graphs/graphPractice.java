package Graphs;

import java.util.*;

public class graphPractice {

    static class Pairs {
        int src;
        int dest;
        int wt;

        Pairs(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void insert(int v, ArrayList<Pairs>[] graph) {

        graph[0].add(new Pairs(0, 1, 1));
        graph[0].add(new Pairs(0, 2, 2));

        graph[1].add(new Pairs(1, 0, 3));
        graph[1].add(new Pairs(1, 3, 3));

         graph[2].add(new Pairs(2, 0, 3));
          graph[2].add(new Pairs(2, 3, 3));
           graph[2].add(new Pairs(2, 4, 3));

        graph[3].add(new Pairs(3, 1, 4));
        graph[3].add(new Pairs(3, 2, 4));
         graph[3].add(new Pairs(3, 4, 4));

         graph[4].add(new Pairs(4, 2, 4));
        graph[4].add(new Pairs(4, 3, 4));
    }

    public static void main(String[] args) {

        int v = 5;
        ArrayList<Pairs>[] graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }
        insert(v, graph);

        for (int i = 0; i < v; i++) {
            System.out.print(i + " -> ");

            for (Pairs e : graph[i]) {
                System.out.print("(" + e.dest + "," + e.wt + ") ");
            }
            System.out.println();
        }
    }
}