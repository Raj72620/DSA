import java.util.Stack;

public class practice {
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
    return rev;
  }

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
        
        return result;
  }
public static void main(String[] args) {
  String str = "F+D-C*(B+A)";
String reversed=  reverseEx(str);
String postfix = InfixToPostfix(reversed);
String prefix = reverseEx(postfix);
System.out.print(prefix+ " ");


}
}