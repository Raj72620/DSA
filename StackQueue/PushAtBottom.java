package StackQueue;

import java.util.Stack;

public class PushAtBottom {
//Push the value at bottom funtion
    public static void PushAtBottom(Stack<Integer> st , int value){
        if(st.isEmpty()){
            st.push(value);
            return;
        }
        int top = st.pop();
        PushAtBottom(st, value);
        st.push(top);
    }
//Reverse a stack function
    public static void reverse(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }
        int top = st.pop();
        reverse(st);
        PushAtBottom(st, top);
        
    }
    
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        int value =4;
        // PushAtBottom(st,value);
        // while(!st.isEmpty()){
        //     int ans =st.pop();
        //     System.out.print(ans+ " ");
        // }

        reverse(st);
        while(!st.isEmpty()){
            int ans = st.pop();
            System.out.print(ans+ " ");
        }
    }
    
}
