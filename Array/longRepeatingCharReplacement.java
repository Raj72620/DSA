package Array;
//longest repeating character replacement

import java.util.HashMap;


public class longRepeatingCharReplacement {

    public static int findmaxLen(String str, int k) {

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;

        int maxfreq = 0;
        int maxlen = 0;

        while (right < str.length()) {

            char ch = str.charAt(right);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            maxfreq = Math.max(maxfreq, map.get(ch));

            while ((right - left + 1) - maxfreq > k) {

                char leftChar = str.charAt(left);

                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                left++;
            }

            maxlen = Math.max(maxlen, right - left + 1);

            right++;
        }

        return maxlen;

    }
    public static void main(String[] args) {
        String str = "AAABBCCD";
        int k =2;

      System.out.println(  findmaxLen(str,k));
    }
    
}
