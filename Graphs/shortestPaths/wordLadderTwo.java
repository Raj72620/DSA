package Graphs.shortestPaths;

import java.util.*;

public class wordLadderTwo {
    public static ArrayList<ArrayList<String>> wdLadder(String[] words , String start , String end){
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for(String wd : words){
            set.add(wd);
        }
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> startPath = new ArrayList<>();
        startPath.add(start);
        q.add(startPath);

        while(!q.isEmpty()){
            int size = q.size();
            HashSet<String> usedOnLevel = new HashSet<>();

            for(int i=0;i<size;i++){
                ArrayList<String> path = q.remove();
                String lastWord = path.get(path.size()-1);

                if(lastWord.equals(end)){
                    ans.add(path);
                    continue;
                }
                char[] arr = lastWord.toCharArray();
                for(int k=0;k<arr.length;k++){
                    char original = arr[k];
                    for(char ch ='a';ch<='z';ch++){
                        arr[k]=ch;
                        String nextWord = new String(arr);
                        if(set.contains(nextWord)){
                            ArrayList<String> newPath = new ArrayList<>(path);
                            newPath.add(nextWord);
                            q.add(newPath);
                            usedOnLevel.add(nextWord);
                        }
                    }
                    arr[k]=original;
                }
            }
            for(String usedword : usedOnLevel){
                set.remove(usedword);
            }
            if(!ans.isEmpty()) break;
        }
        return ans;
    }
    public static void main(String[] args) {
         String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        String start = "hit";
        String end = "cog";

        ArrayList<ArrayList<String>> ans = wdLadder(words, start, end);
        System.out.println(ans);
    }
}
