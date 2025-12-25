package StackQueue;

import java.util.Stack;

public class subArrSumMinimum {
    public static int subArrSum(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] pse = new int[arr.length];
        int[] nse = new int[arr.length];

        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[i]<= arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                pse[i]=-1;
            }else{
                pse[i]=st.peek();
                
            }
            st.push(i);
        }
        st.clear();

        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[i]<arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                nse[i]=arr.length;
            }else{
               nse[i]=st.peek();
            }
            st.push(i);
        }

        int subArrayCount = 0;
       for(int i=0;i<arr.length;i++){
        int left=i-pse[i];
        int right=nse[i]-i;

        subArrayCount+=arr[i] * left * right;

       }
        return subArrayCount;
    }
    public static void main(String[] args) {
        int[] arr={3,1,2,4};
        System.out.println(subArrSum(arr));
        
    }
    
}
