package Recursion;

import java.util.*;

public class combinationSum {

    public static void comSum(int[] arr, int idx , int tar,ArrayList<Integer>ans){
    if(idx==arr.length){
        if(tar==0){
            System.out.println(ans);
        }
        return;
    }
    if(arr[idx]<=tar){
        ans.add(arr[idx]);
        comSum(arr, idx, tar-arr[idx], ans);
        ans.remove(ans.size()-1);
    }
    comSum(arr, idx+1, tar, ans);
    }
    public static void main(String[] args) {
        int[] arr={2,3,6,7};
        int tar=7;
        comSum(arr, 0, tar, new ArrayList<>());
    }
}
