package DP.oneDimensionalDP;

public class houseRobberTwo {

    public static int fun(int[] arr,int n){

        return Math.max(solve(arr,0,n-1), solve(arr,1,n));
    }
    public static int solve(int[] arr,int start , int end){
        int prev2=0;
        int prev1=arr[start];

        for(int i=start+1;i<=end;i++){
            int pick=arr[i]+prev2;
            int notPick=prev1;

            int curr=Math.max(pick, notPick);

            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
    public static void main(String[] args) {
        int[] arr={2,7,9,3,1};
        int n=arr.length;
        System.out.println(fun(arr,n-1));
    }
}
