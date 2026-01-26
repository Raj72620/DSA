package Greedy;

public class JumpGame {
    public static boolean find(int[] arr){

      int maxReach=0;

      for(int i=0;i<arr.length;i++){

        if(i>maxReach) return false;

         maxReach=Math.max(maxReach,(i+arr[i]));
         if(maxReach>=arr.length-1) return true;
      }
      return maxReach>=arr.length-1;
    }
    public static void main(String[] args) {
        int[] arr={1,2,4,1,1,0,2,5};
        System.out.println(find(arr));
    }
    
}
