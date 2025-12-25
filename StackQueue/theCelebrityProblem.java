package StackQueue;

public class theCelebrityProblem {
    
    public static int celebrity(int[][] arr) {
        int top = 0;
        int bottom = arr.length - 1;

        while (top < bottom) {

            if (arr[top][bottom] == 1) {
                top++;
            } else {
                bottom--;
            }
        }
        
        int candidate = top; 

        for (int i = 0; i < arr.length; i++) {

            if (i == candidate) continue;
            
            if (arr[candidate][i] == 1 || arr[i][candidate] == 0) {
                return -1; 
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[][] arr = {
            {0, 1, 1, 0},
            {0, 0, 0, 0},
            {0, 1, 0, 0},
            {1, 1, 0, 0}
        };
        System.out.println(celebrity(arr)); 
    }
}