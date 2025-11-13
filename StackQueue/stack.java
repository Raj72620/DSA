package StackQueue;
import java.util.Stack;


public class stack {
    public static void main(String[] args) {
    Stack<Integer> st = new Stack<>();
       st.push(1);
       st.push(2);
       for(int val:st){
        System.out.print(val+ " ");
       }
       System.out.println();

       System.out.println(st.peek());
    }
}
