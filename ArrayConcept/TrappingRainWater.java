package ArrayConcept;

import java.util.Arrays;

public class TrappingRainWater {

    public static int[] FindingMax(int[] arr){

        int[] ML = new int[arr.length];

        ML[0]=arr[0];                          //for claculation it is n no.of elements hence Time com = O(n)

        for(int i=1;i<arr.length;i++){    // Space com = O(n)
            if(arr[i]>=ML[i-1]){
                ML[i]=arr[i];
            }else{
                ML[i]=ML[i-1];
            }
        }
        int[] MR=new int[arr.length];            //for claculation it is n no.of elements hence Time com = O(n)

        MR[arr.length-1]=arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--){    // space com = O(n)
            if(arr[i]>=MR[i+1]){
                MR[i]=arr[i];
            }else{
                MR[i]=MR[i+1];
            }
        }
       return totalArea(arr, ML, MR);
    }
    public static int[] totalArea(int[] arr,int[] ML , int[] MR){
        int[] ans = new int[arr.length];            //for claculation it is n no.of elements hence Time com = O(n)

        for(int i=0;i<arr.length;i++){           // stroring the answer ima using space com = O(n)
            int min = Math.min(ML[i], MR[i]);     

            int area = min-arr[i];
            ans[i]=area;
        }
        return ans;                                 // hence total = O(3n) 

    }

    //optimized version -> Using Two pointers approach

      public static int TrappingRainWater(int[] arr,int i,int j){  // int i = 0 and int j = arr.length-1
    int water =0;
    int LeftMax=0;
    int RightMax=0;
    while(i<j){
      if(arr[i]<=arr[j]){
        if(LeftMax<=arr[i]){
          LeftMax=arr[i];
        }
        water+=LeftMax-arr[i];
        i++;
      }else{
       
        if(RightMax<=arr[j]){
          RightMax=arr[j];
        }
        water+=RightMax-arr[j];
        j--;
      }
    }
    return water;
  }

     
    public static void main(String[] args) {
        int[] arr = {4,2,0,6,3,2,5};
        
        int[] ans =  FindingMax(arr);
         System.out.println(Arrays.toString(ans));
    }
    
}
