package StackQueue;

// concept to solve ->  Largest rectangle in histogram and  prefix sum 

import java.util.Stack;

public class maxRectangle {

    public static int MaxRect(int[][] arr){
        if(arr==null || arr.length==0 || arr[0].length==0) return 0;

        int rows=arr.length;
        int cols=arr[0].length;
        int[] height = new int[cols];
        int maxArea=0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(arr[i][j]==1){
                    height[j]+=1;
                }else{
                    height[j]=0;
                }
            }
            maxArea=Math.max(maxArea, largestRectangel(height));
        }
        return maxArea;
    }

public static int largestRectangel(int[] heights){
    Stack<Integer> st = new Stack<>();

    int maxArea=0;
    int n=heights.length;
    for(int i=0;i<=n;i++){
        int currHeight= (i==n) ? 0 : heights[i];
        while(!st.isEmpty() && currHeight < heights[st.peek()]){
            int height=heights[st.pop()];
            int width=st.isEmpty() ? i : i-st.peek() -1;

            maxArea=Math.max(maxArea, height*width);

        }
        st.push(i);
    }
    return maxArea;
}
    public static void main(String[] args) {
        int[][] arr = {{1, 0, 1, 0, 1},
                       {1, 1, 1, 1, 1},
                       {1, 1, 1, 1, 1},
                       {1, 0, 0, 1, 0} };

                       System.out.println(MaxRect(arr));
    }
}
