package StackQueue;
import java.util.Stack;


public class stack {
    public static void reverse(Stack<Integer>st){
        Stack<Integer> temp = new Stack<>();
        while(!st.isEmpty()){
            temp.push(st.pop());
        }
        while(!temp.isEmpty()){
        int ans = temp.pop();
        st.push(ans);
        }

    }
    public static void main(String[] args) {
        Stack<Integer>st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        int ans = st.peek();
        System.out.println(ans);
      
    }
}
