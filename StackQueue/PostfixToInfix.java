package StackQueue;
import java.util.Stack;

//Expression no 3 ->  Postfix to Infix

// store operands in stack -> when ever operator appears pop two ele form stack and add this opeartor in between this operands also adding ( open and closed backets)
//formula -> op2 + operator + op1

public class PostfixToInfix {
    public static String PostfixToInfix(String str){
        Stack<String> st = new Stack<>();
        for(char ch : str.toCharArray()){

            if(Character.isLetterOrDigit(ch)){
                st.push(ch+ " ");
            }
            else{
                String op1 = st.pop();
                String op2 =st.pop();

                String ex = "("+ op2 + ch + op1 + ")";
                st.push(ex);
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {

        String str = "AB-DE+F*/";
       String ex = PostfixToInfix(str);
       System.out.print(ex+ " ");
        
    }
}
