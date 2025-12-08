package StackQueue;

import java.util.Stack;

public class FilePath {

    public static String File(String str){
        Stack<String> st = new Stack<>();
       int n=str.length();
       int i=0;
       while(i<n){
        while(i<n && str.charAt(i)=='/'){
            i++;
        }
        if(i==n) break;

        int start=i;
        while(i<n && str.charAt(i)!='/') i++;

            String s = str.substring(start,i);
            if(!st.isEmpty() && s.equals("..")){
                st.pop();
            }
            else if(!s.equals(".")){
                st.push(s);
            }
        }
        if(st.isEmpty()) return "/";

        StringBuilder res = new StringBuilder();
        for(String d :st){
            res.append("/").append(d);
        }
        
         return res.toString();
       }
       
    public static void main(String[] args) {
     String str = "a/b/..";
     System.out.println(File(str));
      
    }
}
