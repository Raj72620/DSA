package Graphs.Basics;

import java.util.*;

public class noOfdistinctIsland {

    public static void dfs(int[][] grid , int r , int c , int br , int bc ,ArrayList<String> shape){

        int n=grid.length;
        int m =grid[0].length;

        if(r <0 || c<0 || r>=n || c>=m || grid[r][c]==0) return;
        grid[r][c]=0;
        shape.add((r-br)+","+(c-bc));
        dfs(grid, r-1, c, br, bc, shape);
        dfs(grid, r+1, c, br, bc, shape);
        dfs(grid, r, c-1, br, bc, shape);
        dfs(grid, r, c+1, br, bc, shape);
    }
    public static int countDistinct(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        HashSet<ArrayList<String>> set = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    ArrayList<String> shape = new ArrayList<>();
                    dfs(grid, i, j, i, j, shape);
                    set.add(shape);
                }
            }
        }
        return set.size();
    }
    public static void main(String[] args) {
        int[][] island={{1,1,0,1,1},{1,0,0,0,0},{0,0,0,1,1},{1,1,0,1,0}};
        System.out.println(countDistinct(island));
    }
}
