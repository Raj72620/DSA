package DP.DPonStrings;

public class longestPalindromicSubSeq {

    public static int findLongestPalinOne(String s1){
        int n=s1.length();
        
        StringBuilder s2= new StringBuilder();
        for(int i=s1.length()-1;i>=0;i--){
            s2.append(s1.charAt(i));
        }

        int ans =findLCS(s1,s2.toString(),n-1,n-1);
        return ans;
    }
    public static int findLCS(String s1,String s2,int idx1,int idx2){
        if(idx1<0 || idx2<0) return 0;

        if(s1.charAt(idx1)==s2.charAt(idx2)){
            return 1+findLCS(s1, s2, idx1-1, idx2-1);
        }else{
            return Math.max(findLCS(s1, s2, idx1-1, idx2), findLCS(s1, s2, idx1, idx2-1));
        }
    }
    public static void main(String[] args) {
        String s="bbbab";  // o/p=4
        String str="agbcba"; // o/p= 5

        System.out.println(findLongestPalinOne(s));

        System.out.println(findLongestPalinOne(str));
    }
}
