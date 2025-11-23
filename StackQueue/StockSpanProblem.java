package StackQueue;

import java.util.Stack;

public class StockSpanProblem {

    public static void StockSpan(int[] arr , int[] span){
        Stack<Integer> st = new Stack<>();

        st.push(0);
        span[0]=1;

        for(int i=1;i<arr.length;i++){
            int currPrice=arr[i];

            while(!st.isEmpty() && currPrice > arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                span[i]=i+1;
            }else{
                int prevHigh=st.peek();
                span[i]=i-prevHigh;
            }
            st.push(i);
        }
    }
    public static void main(String[] args) {
        int [] stocks={100,80,60,70,60,85,100};

        int[] span = new int[stocks.length];

        StockSpan(stocks , span);

        for(int i=0;i<span.length;i++){
            System.out.print(span[i]+ " ");
        }
    }
    
}
