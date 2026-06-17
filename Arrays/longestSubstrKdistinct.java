package Arrays;
//longest sub string with at most k distinct characters

import java.util.HashMap;


public class longestSubstrKdistinct {
    public static int KdistinctChar(String str , int k){
        HashMap<Character,Integer> map = new HashMap<>();
     int left =0;
     int right =0;
     int maxLen =0;

     while(right < str.length()){
            char ch = str.charAt(right);
        map.put(ch, map.getOrDefault(ch, 0)+1);

        while(map.size() > k){
            char leftchar = str.charAt(left);
            map.put(leftchar, map.get(leftchar)-1);
            if(map.get(leftchar)==0){
                map.remove(leftchar);
            }
            left++;
        }
        maxLen = Math.max(maxLen, right-left+1);
        right++;
     }
     return maxLen;
    }
    public static void main(String[] args) {
        String str = "eceba";
        int k=2;

        System.out.println(KdistinctChar(str,k));
    }
}
