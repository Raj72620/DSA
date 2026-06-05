package Graphs;

import java.util.*;

public class pathWithMinEffort {

    static class pair {

        int row;
        int col;
        int dist;

        pair(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public static int findMinPath(int[][] grid, int n, int m, int[] src, int[] dest) {
        int[][] distPath = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(distPath[i], Integer.MAX_VALUE);
        }
        distPath[0][0]=0;
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->a.dist-b.dist);
        pq.add(new pair(0, 0, 0));

        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!pq.isEmpty()){
            pair curr=pq.remove();
            int row = curr.row;
            int col = curr.col;
            int dist=curr.dist;

            if(row==n-1 && col==m-1){
                return dist;
            }
            for(int[] d : dir){
                int newRow = row+d[0];
                int newCol = col+d[1];

                if(newRow >=0 && newRow <n && newCol >=0 && newCol<m){
                    int edgeDiff = Math.abs(grid[row][col]-grid[newRow][newCol]);
                    int newEffort = Math.max(edgeDiff, dist);

                    if(newEffort < distPath[newRow][newCol]){
                        distPath[newRow][newCol]=newEffort;
                        pq.add(new pair(newRow, newCol, newEffort));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        int[][] grid = {{1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}};
        int n = grid.length;
        int m = grid[0].length;
        int[] src = {0, 0};
        int[] dest = {n - 1, m - 1};

        System.out.println(findMinPath(grid, n, m, src, dest));
    }
}
