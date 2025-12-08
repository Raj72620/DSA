package StackQueue;

import java.util.Stack;

//Expression no 1 ->  Infix to Postfix  

//add operands directly in result -> while you encounter a operator add in stack before that compare they precidence(priority) 
//If the smaller operator is being compared with the higher operator there is no need of changes 
//else in case if there is a higher opeartor and compared with a lower one then pop it form stack and add it to the result  

class InfixToPostfix {
    //Method for prorities
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

    static String conversion(String Infix) {
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


    // handling all edge cases and using string builder 

    class Solution {
    public static String infixToPostfix(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            } else if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    result.append(st.pop());
                }
                st.pop(); 
            } else { 
                //  '^' specially as it's right-associative
                if (ch == '^') {
                    // For right-associative '^', only pop operators with higher precedence
                    while (!st.isEmpty() && precedence(st.peek()) > precedence(ch)) {
                        result.append(st.pop());
                    }
                } else {
                    // For left-associative operators (+, -, *, /)
                    // Pop operators with higher OR equal precedence
                    while (!st.isEmpty() && precedence(st.peek()) >= precedence(ch)) {
                        if (st.peek() == '(') break;
                        result.append(st.pop());
                    }
                }
                st.push(ch);
            }
        }
        
        // Pop remaining operators
        while (!st.isEmpty()) {
            result.append(st.pop());
        }
        
        return result.toString();
    }
    
    static int precedence(char ch) {
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
}



    public static void main(String[] args) {
        String Infix = "h^m^q^(7-4)";
        String str = conversion(Infix);
        System.out.println(str + " ");
    }
}
