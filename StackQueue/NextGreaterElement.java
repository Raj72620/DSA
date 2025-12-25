package StackQueue;



import java.util.Stack;

public class NextGreaterElement {

    //Next greater element -> Right side 
    //loop starts form end onwards 
    public static void findNGE(int[] arr , int[] NGE){
        Stack<Integer> st = new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[i]>=st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                NGE[i]=-1;
            }
            else{
                NGE[i]=st.peek();
                
            }
            st.push(arr[i]);
        }
    }

    //Next greater element -> Left side 
    //for loop starts from starting onwards
    public static void ngeLeftSide(int[] arr , int[] NGE){

                Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[i]>=st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                NGE[i]=-1;
            }
            else{
                NGE[i]=st.peek();
                
            }
            st.push(arr[i]);
        }

    }
    public static void main(String[] args) {
        int[] arr={6,8,0,1,3};
        int[] NGE = new int[arr.length];

        ngeLeftSide(arr, NGE);

        for(int i=0;i<NGE.length;i++){
            System.out.print(NGE[i]+" ");
        }
    }
    
}
