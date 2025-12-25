package StackQueue;

import java.util.Stack;

// Ranges ->   find  (sum of sub arr max) - (sum of sum arr min) 


public class subArrSumRanges {

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
            while(!st.isEmpty() && arr[i]< arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                nse[i]=arr.length;
            }else{
               nse[i]=st.peek();
            }
            st.push(i);
        }
        int min=0;
        for(int i=0;i<arr.length;i++){
            int left = i-pse[i];
            int right=nse[i]-i;
            min+=arr[i]*left*right;
        }
        st.clear();

//finding sum of sub array maximum 

      int[] pge = new int[arr.length];
        int[] nge = new int[arr.length];

        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[i] > arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                pge[i]=-1;
            }else{
                pge[i]=st.peek();
                
            }
            st.push(i);
        }
        st.clear();

        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[i] >= arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                nge[i]=arr.length;
            }else{
               nge[i]=st.peek();
            }
            st.push(i);
        }
        int max =0;
        for(int i=0;i<arr.length;i++){
            int left  = i-pge[i];
            int right = nge[i]-i;
            max+=arr[i]*left*right;
        }
        return max-min;
    }
    public static void main(String[] args) {

         int[] arr={3,1,2,4};
        System.out.println(subArrSum(arr));
    }
    
}
