package Recursion;

import java.util.ArrayList;

public class subsequences {

    // print all the subseq / subsets of an string
    public static void printAllSubSeq(String str, int idx , String curr ){

        if(idx==str.length()){
            System.out.print(curr+ " ");
            return;
        }
        printAllSubSeq(str, idx+1, curr+str.charAt(idx));
        printAllSubSeq(str, idx+1, curr);
    }

    // print all the subseq / subsets of an array 
    public static void printAllSubsets(int[] arr , int idx , ArrayList<Integer> list){

        if(idx==arr.length){
            System.out.print(list+ " ");
            return;
        }
        list.add(arr[idx]);

        printAllSubsets(arr, idx+1, list);

        list.remove(list.size()-1);

         printAllSubsets(arr, idx+1, list);

    }

    // Sub sets-2 problem - printing all uniques if the arr has duplicates 
    public static void subSet2(int[] arr , int idx , ArrayList<Integer> ans){
       
        System.out.print(ans+ " ");

        for(int i=idx ; i<arr.length;i++){
            if(i>idx && arr[i]==arr[i-1]) continue;
            ans.add(arr[i]);
            subSet2(arr, i+1, ans);
            ans.remove(ans.size()-1);
        }
    }
    public static void main(String[] args) {
        // String str = "abc";
        // printAllSubSeq(str,0," ");

        int[] arr = {1,2,2};
        subSet2(arr, 0, new ArrayList<>());
    }
    
}
