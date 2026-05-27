package Graphs;

import java.util.*;

public class wordLadder {

    public static int minCount(String[] words, String start, String end) {

        HashSet<String> set = new HashSet<>();
        ArrayList<String> ans = new ArrayList<>();

        for (String word : words) {
            set.add(word);
        }
        Queue<String> q = new LinkedList<>();
        q.add(start);

        set.remove(start);
        int count = 1; 
        ans.add(start);

        while (!q.isEmpty()) {
            int size = q.size(); 
            for (int s = 0; s < size; s++) {

                String wd = q.remove();

                if (wd.equals(end)) {
                    System.out.print(ans);
                    return count;
                }
                char[] arr = wd.toCharArray();

                for (int i = 0; i < arr.length; i++) {

                    char original = arr[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        arr[i] = ch;

                        String nextWord = new String(arr);

                        if (set.contains(nextWord)) {
                            q.add(nextWord);
                            ans.add(nextWord);
                            set.remove(nextWord);
                        }
                    }
                    arr[i] = original;
                }
            }
            count++; 
        }
           
        return 0;
    }

    public static void main(String[] args) {

        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        String start = "hit";
        String end = "cog";

        System.out.println(minCount(words, start, end));
    }
}