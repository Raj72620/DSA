package StackQueue;

import java.util.Stack;

// Expression no 6 ->  Prefix to Postfix 
//No wrap -> start from end -> simply pop operands add the operator last -> then op1 and then op2 and push into the stack 
//formula -> op1 + op2 + operator

public class PrefixToPostfix {

    public static String PreToPost(String str) {
        Stack<String> st = new Stack<>();

        for (int i=str.length()-1;i>=0;i--) {
            char ch = str.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                st.push(ch + " ");
            } else {
                String op1 = st.pop();
                String op2 = st.pop();
                String ex = op1 + op2 + ch;

                st.push(ex);
            }
        }
        return st.pop();

    }

    public static void main(String[] args) {
        String str = "/-AB*+DEF";
        System.out.print(PreToPost(str) + " ");
    }

}
