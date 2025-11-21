package StackQueue;

import java.util.Stack;

// Expression no 4 ->  Prefix to Infix
//Reverse the expression or start from end onwards -> add operands in stack -> when operator appears pop top two operands from stack -> add it 
//formula -> op1 + operator + op2 

public class PrefixToInfix {
    public static String PrefixToInfix(String str){
         Stack<String> st = new Stack<>();

         for(int i=str.length()-1;i>=0;i--){
            char ch = str.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                st.push(ch + " ");
            }else{
                String op1 = st.pop();
                String op2 = st.pop();

                String ex = "(" + op1 + ch + op2 + ")";
                st.push(ex);
            }
         }
         return st.pop();
    }
    public static void main(String[] args) {
        String str = "*+PQ-MN";
       System.out.print( PrefixToInfix(str)+ " ");
    }
}
