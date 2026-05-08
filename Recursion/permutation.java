package Recursion;

import java.util.*;

public class permutation {
    public static void allPerm(int[] arr , int idx , ArrayList<Integer> list){
        if(idx==arr.length){
            System.out.print(list+ " ");
            return;
        }
        for(int i=idx ; i<arr.length;i++){
            swap(arr,idx,i);
             list.add(arr[idx]);
            allPerm(arr, idx+1, list);
            swap(arr,idx,i);
            list.remove(list.size()-1);
        }
    }
    public static void swap(int[] arr,int i , int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    // permuation of a string
  public static void stringPerm(String str, int idx) {

    if (idx == str.length()) {
        System.out.print(str + " ");
        return;
    }

    for (int i = idx; i < str.length(); i++) {
        str = swapString(str, idx, i);
        stringPerm(str, idx + 1);
        str = swapString(str, idx, i); 
    }
}
   public static String swapString(String str, int i, int j) {
    char[] arr = str.toCharArray();
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;

    return new String(arr);
}
    public static void main(String[] args) {
        // int[] arr = {1,2,3};
        // allPerm(arr, 0, new ArrayList<>());


        String str = "abc";
        stringPerm(str, 0);
    }
    
}
