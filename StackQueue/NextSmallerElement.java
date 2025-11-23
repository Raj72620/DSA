package StackQueue;

import java.util.Stack;

public class NextSmallerElement {

    //Next Smaller ele -> Right side

    public static void NSE(int[] arr , int[] nse){
                Stack<Integer> st = new Stack<>();

        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[i]<=st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                nse[i]=-1;
            }
            else{
                nse[i]=st.peek();
                
            }
            st.push(arr[i]);
        }
    }

    //Next Smaller ele -> Left side
    public static void nseLeftSide(int[] arr , int[] nse){
                     Stack<Integer> st = new Stack<>();

        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[i]<=st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                nse[i]=-1;
            }
            else{
                nse[i]=st.peek();
                
            }
            st.push(arr[i]);
        }
    }
    public static void main(String[] args) {
        int[] arr={6,8,0,1,3};
        int[] nse=new int[arr.length];

        nseLeftSide(arr,nse);

        for(int i=0;i < nse.length;i++){
            System.out.print(nse[i]+ " ");
        }
    }
    
}
