package Recursion;

public class moveXToEnd {

    public static String MoveXToEnd(String str,int i, StringBuilder result){

      if(i == str.length()){
    return result.toString();
}
        if(str.charAt(i)!='x'){
            result.append(str.charAt(i));
        }
        MoveXToEnd(str, i+1, result);

        if(str.charAt(i)=='x'){
        result.append(str.charAt(i));
        }

        return result.toString();
    }
public static void main(String[] args) {
    String str ="xxabc";
    StringBuilder result ;
    int i=0;
   String ans = MoveXToEnd(str ,i, new StringBuilder());

   System.out.println(ans);
    

} 
}
