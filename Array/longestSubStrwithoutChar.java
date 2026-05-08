package Array;
import java.util.HashMap;

//Longest substring without repeating characters

public class longestSubStrwithoutChar {

    public static String longestStr(String str){

    HashMap<Character,Integer> map = new HashMap<>();

    int left = 0;
    int right = 0;

    int maxLen = 0;
    int start = 0;

    while(right < str.length()){

        char ch = str.charAt(right);

        if(map.containsKey(ch) && map.get(ch) >= left){
            left = map.get(ch) + 1;
        }

        map.put(ch, right);

        int len = right - left + 1;

        if(len > maxLen){
            maxLen = len;
            start = left;
        }

        right++;
    }

    return str.substring(start, start + maxLen);
    }
    public static void main(String[] args) {
        String s = "cadbzabcd";

        System.out.println(longestStr(s));
    }
    
}
