package Greedy;

public class ValidParenthesisString {
    public static boolean isTrue(String str){
        int min=0;
        int max=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                min++;
                max++;
            }
            else if(str.charAt(i)==')'){
                min--;
                max--;
            }
            else{
                min--;
                max++;
            }
            if(max<0){
                return false;
            }
            min=Math.max(min, 0);
        }
        return min==0;
    }
    public static void main(String[] args) {
        String str = "(*()";
       System.out.println( isTrue(str));
    }
    
}
