package StackQueue;

import java.util.Stack;

public class stack {

  public static void collision(int[] arr){
    Stack<Integer> st = new Stack<>();

    for (int i = 0; i < arr.length; i++) {

        if (arr[i] < 0) {
            int store = Math.abs(arr[i]);

            while (!st.isEmpty() && store > st.peek()) {
                st.pop();
            }

            if (!st.isEmpty() && store == st.peek()) {
                st.pop(); // both destroyed
            }
            else if (st.isEmpty()) {
                st.push(arr[i]); // negative survives
            }
        }
        else {
            st.push(arr[i]);
        }
    }

    while(!st.isEmpty()){
      System.out.print(st.pop()+ " ");
    }
  }
    public static void main(String[] args) {
     int[] arr = {4,7,1,2,-3,-7,-7};
     collision(arr);

    }
}
