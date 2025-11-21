package StackQueue;
import java.util.Stack;

//Expression no 2 ->  Infix to prefix

// First reverse the guven expression -> also reverse the brackets -> Now implement the infix to postfix expression 
// Now again reverse this infix to postfix expression -> final answer is a prefix expression 


public class InfixToPrefix {


          static int precidence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

//Function to reverse the expression 

  public static String reverseEx(String str){
    String rev ="";
    for(int i=str.length()-1;i>=0;i--){
      if(str.charAt(i)=='('){
        rev+=')';
      }
      else if (str.charAt(i)==')'){
        rev+='(';
      }
      else{
        rev+=str.charAt(i);
      }
    }
    //return in string format
    return rev;
  }

  // Infix to Postfix function 

  public static String InfixToPostfix(String Infix){
        String result = " ";
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < Infix.length(); i++) {
            
            char ch = Infix.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                result += ch;

            } else if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    result += st.pop();
                }
                st.pop();
            } else {
                while (!st.isEmpty() && precidence(st.peek()) > (precidence(ch))) {
                    result += st.pop();
                }
                st.push(ch);
            }
        }
        while (!st.isEmpty()) {
            result += st.pop();
        }
        //return in string format  
        return result;
  }

public static void main(String[] args) {
  String str = "A^B^C";

  //Reversing the given expression 
String reversed=  reverseEx(str);

//converting the expression into postfix
String postfix = InfixToPostfix(reversed);

//again reversing this postfix expression
String prefix = reverseEx(postfix);

System.out.print(prefix+ " ");


}
}