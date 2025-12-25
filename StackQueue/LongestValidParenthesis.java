package StackQueue;
import java.util.Stack;

public class LongestValidParenthesis {

        public static int Paren(String str){
        Stack<Integer> st = new Stack<>();

        int count =0;
            st.push(-1);
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);

            if(ch=='('){
                st.push(i);
            }
            else{
                st.pop();
                if(st.isEmpty()) st.push(i);

                count=Math.max(count, i-st.peek());
            } 
        }
        return count;
    }

    public static void main(String[] args) {
         String str = "(())()";
     System.out.print(Paren(str + " "));
    }
}
