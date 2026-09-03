
public class practice {

    public static int solve(int[] arr,int idx,int tar){
         if (tar == 0)
        return 1;

    if (idx == 0){
        if(arr[0]==tar){
            return 1;
        }else{
            return 0;
        }
    }

    int skip = solve(arr,idx - 1, tar);

    int take = 0;

    if (arr[idx] <= tar)
        take = solve(arr,idx - 1, tar - arr[idx]);

    return skip + take;
}

    public static void main(String[] args) {

       int[] arr={1,2,2,3};
       int tar=3;
       int n=arr.length;

      System.out.println( solve(arr,n-1,tar));

       
    }
}