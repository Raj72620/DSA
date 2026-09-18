package DP.DPonStrings;

public class shortestCommonSubSeq {

    public static int FindSCS(String s1, String s2, int idx1,int idx2){

        // Finding LCS first
        if(idx1<0 || idx2<0) return 0;

        if(s1.charAt(idx1)==s2.charAt(idx2)){
            return 1+FindSCS(s1, s2, idx1-1, idx2-1);
        }
        return Math.max(FindSCS(s1, s2, idx1-1, idx2), FindSCS(s1, s2, idx1, idx2-1));
    }
    public static void main(String[] args) {
        String s1="bleed";
        String s2= "blue";

        int idx1=s1.length();
        int idx2=s2.length();

        int LCS = FindSCS(s1,s2,idx1-1,idx2-1);

        // calculating SCS 
        int size = idx1+idx2;

        System.out.println(size-LCS);
    }
}
