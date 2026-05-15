package Graphs;
import java.util.*;
public class rottenOranges {
    static class Info{
        int row;
        int col;

        public Info(int row,int col) {
            this.row=row;
            this.col=col;
        }
    }
    public static int isRotten(int[][] mat){
        int n=mat.length;
        int m=mat[0].length;

        Queue<Info> q = new LinkedList<>();
        int fresh =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==2){
                    q.add(new Info(i, j));
                }
                else if(mat[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;
        int time =0;
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int size = q.size();
            boolean rotted = false;

            for(int i=0;i<size;i++){
                Info curr = q.remove();
                for(int[] d : dir){
                    int nrow = curr.row+d[0];
                    int nCol = curr.col+d[1];
                    if(nrow >=0 && nCol >=0 
                        && nrow<n && nCol<m && mat[nrow][nCol]==1
                    ){
                        mat[nrow][nCol]=2;
                        q.add(new Info(nrow, nCol));
                        fresh--;
                        rotted=true;
                    }
                }
            }
            if(rotted) time++;
        }
        return fresh==0 ? time : -1;
    }
    public static void main(String[] args) {
        int[][] mat ={{2,1,1},{1,1,0},{0,1,1}};
        int ans = isRotten(mat);
        System.out.println(ans);
    }
}
