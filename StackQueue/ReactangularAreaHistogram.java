package StackQueue;

import java.util.Stack;


public class ReactangularAreaHistogram{
    public static int[] NSL(int[] arr){

        Stack<Integer> st = new Stack<>();
        int[] nsl=new int[arr.length];

        for(int i=0;i<arr.length;i++){
             while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    nsl[i]=-1;
                }
            else{
                nsl[i]=st.peek();
            }
            st.push(i);
        }
        // for(int i=0;i<nsl.length;i++){
        //     System.out.print(nsl[i] + " ");
        // }
        return nsl;
    }
    public static int[] NSR(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] nsr = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nsr[i]=arr.length;
            }else{
                nsr[i]=st.peek();
            }
            st.push(i);
        }
        // for(int i=0;i<nsr.length;i++){
        //     System.out.print(nsr[i] + " ");
        // }
            return nsr;
    }
    public static int MaxRectHistogram(int[] arr){
        int[] nsr = NSR(arr);
        int[] nsl = NSL(arr);
        
        int area =0;
        for(int i=0;i<arr.length;i++){
            int height = arr[i];
            int wd = nsr[i]-nsl[i]-1;
            area = Math.max(area, wd*height);
        }
        return area;
    }

    public static void main(String[] args) {
        int []arr = {2,1,5,6,2,3};

        NSL(arr);
        NSR(arr);

        System.out.println(MaxRectHistogram(arr));

      
    }
}
