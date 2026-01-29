package Recursion;

public class SubstringStartEnd {

public static void substrings(String str, int start, int end) {

    if (start == str.length()) return;

    if (end <= str.length()) {
        String sub = str.substring(start, end);

        if (sub.length() == 1 || (sub.length() > 1 && sub.charAt(0) == sub.charAt(sub.length() - 1))) {
            System.out.println(sub);
        }
    }
    if (end == str.length()) {
        substrings(str, start + 1, start + 1);
        return;
    }
    substrings(str, start, end + 1);
}
public static int countSubarr(String str , int i,int j , int n){
    if(n==1){
        return 1;
    }
    if(n<=0) return 0;

    int res = countSubarr(str, i+1, j, n-1)+countSubarr(str, i, j-1, n-1)-countSubarr(str, i+1, j-1, n-2);

    if(str.charAt(i)==str.charAt(j)){
        res++;
    }
    return res;
}
    public static void main(String[] args) {
        String str="abba";
        int n = str.length();
         substrings(str, 0,0);

      System.out.println(countSubarr(str, 0,n-1,n));
    }
}
