package StackQueue;

// Expression no 5 ->  Postfix to Prefix
//No wrap -> simply pop operands add the operator first -> then op2 and then op1 and push into the stack 
//formula -> operator + op2 + op1

import java.util.Stack;
public class PostfixToPrefix {
    public static String PostToPre(String str){
        Stack<String> st = new Stack<>();

        for(char ch : str.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                st.push(ch+ " ");
            }else{
                String op1 = st.pop();
                String op2 = st.pop();
                String ex = ch+op2+op1;

                st.push(ex);
            }
        }
        return st.pop();

    }
    public static void main(String[] args) {
        String str = "AB-DE+F*/";
       System.out.print( PostToPre(str)+ " ");
        
    }
}
