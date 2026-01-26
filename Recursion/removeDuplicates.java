package Recursion;

public class removeDuplicates {
    public static void removeDup(String str , int idx ,StringBuilder newStr,boolean []map ){

        if(idx==str.length()) {
            System.out.println(newStr);
            return;
        }
        char ch = str.charAt(idx);

        if(map[ch-'a']==true) {
            removeDup(str, idx+1, newStr,map);
        }else{
            map[ch-'a']=true;
            removeDup(str, idx+1, newStr.append(ch),map);
}
    }
    public static void main(String[] args) {
        String str ="aabccd";
           boolean[] map = new boolean[26];
        removeDup(str , 0 , new StringBuilder(""),map);
    }
    
}
