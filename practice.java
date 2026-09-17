import java.util.*;

public class practice {

    public static void main(String[] args) {

      HashMap<Character,Integer> map = new HashMap<>();
      String s = "abcd";
      for(int i=0;i<s.length();i++){
        char ch=s.charAt(i);
        map.put(ch, map.getOrDefault(ch, 0)+1);
      }
       
    }
}