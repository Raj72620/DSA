package Greedy;

public class JumpGame_2 {
    public static int findMinReach(int[] arr){
        int currEnd =0;
        int far=0;
        int jump=0;

        for(int i=0;i<arr.length;i++){
            far=Math.max(far, arr[i]+i);

            if(far>=arr.length-1){
                jump++;
                break;
            }
            if(i==currEnd){
                jump++;
                currEnd=far;
            }
        }
        return jump;
    }
    public static void main(String[] args) {
        int[] arr={2,3,1,4,1,1,1,2};
       System.out.println(findMinReach(arr));
    }
    
}
