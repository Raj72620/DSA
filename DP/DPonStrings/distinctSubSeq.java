package DP.DPonStrings;

public class distinctSubSeq {

    public static int solve(String s1,String s2, int idx1,int idx2){

        if(idx2<0) return 1;
        if(idx1<0) return 0;

        if(s1.charAt(idx1)==s2.charAt(idx2)){
          return solve(s1, s2, idx1-1, idx2-1)+solve(s1, s2, idx1-1, idx2);
        }
        return solve(s1, s2, idx1-1, idx2);
    }
    public static void main(String[] args) {
        String s1="rabbbit";
        String s2="rabbit";

        System.out.println(solve(s1,s2,s1.length()-1,s2.length()-1));
    }
}
