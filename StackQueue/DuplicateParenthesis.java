package StackQueue;

import java.util.Stack;


public class DuplicateParenthesis{
    public static boolean DuplParen(String str){

        Stack<Character> st = new Stack<>();

        if(str.charAt(0)==')'){
            return false;
        } 
    for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        
        if (ch == ')') {
            // If we immediately find '(' at top, it means duplicate parentheses
            if (!st.isEmpty() && st.peek() == '(') {
                return true;
            }
            
            // Pop until we find the matching '('
            while (!st.isEmpty() && st.peek() != '(') {
                st.pop();
            }
            
            if (!st.isEmpty()) {
                st.pop(); // remove the '('
            }
        } else {
            st.push(ch);
        }
    }
    
    return false;
    }

    public static void main(String[] args) {
        String str = "((a))";

        System.out.println(DuplParen(str));
      
    }
}
