import java.util.*;
public class practice{

  public static int[] solve(int[] arr,int n){
    Stack<Integer> st= new Stack<>();
    int[] ans=new int[n];

    int ele=arr[n-1];
    st.push(ele);
    ans[n-1]=-1;

    for(int i=n-2;i>=0;i--){
      ele=arr[i];

      while(!st.isEmpty() && ele > st.peek()){
        st.pop();
      }
      if(st.isEmpty()){
        ans[i]=-1;
      }else{
        ans[i]=st.peek();
      }
      st.push(arr[i]);
    }
    return ans;
  }


  public static void main(String[] args) {
      int[] arr={6,8,0,1,3};
      int n=arr.length;

    int[] ans=  solve(arr,n);
    for(int i=0;i<n;i++){
      System.out.print(ans[i]+ " ");
    }
  }
} 
