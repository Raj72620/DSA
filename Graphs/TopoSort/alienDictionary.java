package Graphs.TopoSort;

import java.util.*;

public class alienDictionary {

    public static String findOrder(String[] words,int N , int k){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<k;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<N-1;i++){
            String s1 = words[i];
            String s2 = words[i+1];
            int len = Math.min(s1.length(), s2.length());

            for(int j=0;j<len;j++){
                if(s1.charAt(j)!=s2.charAt(j)){
                    int u = s1.charAt(j)-'a';
                    int v = s2.charAt(j)-'a';
                    graph.get(u).add(v);
                    break;
                }
            }
        }
        int[] inDegree = new int[k];
        for(int i=0;i<k;i++){
            for(int neig : graph.get(i)){
                inDegree[neig]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<k;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!q.isEmpty()){
            int node = q.remove();
            ans.append((char)(node+'a'));
            for(int neig : graph.get(node)){
                inDegree[neig]--;
                if(inDegree[neig]==0){
                    q.add(neig);
                }
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        String[] words = {"baa","abcd","abca","cab","cad"};
        int k=4;
        int N=words.length;
        String ans = findOrder(words, N, k);
        System.out.println(ans);
    }
}
