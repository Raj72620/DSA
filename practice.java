import java.util.ArrayList;
public class practice{

    public static void subSet(int[] arr , int idx,ArrayList<Integer> ans){
        System.out.print(ans);

        for(int i=idx;i<arr.length;i++){
            if(i>idx && arr[i]==arr[i-1]) continue;
            ans.add(arr[i]);
            subSet(arr, i+1, ans);
            ans.remove(ans.size()-1);
        }
    }
  
    public static void main(String[] args) {
    int[] arr ={1,2,2};
    int idx =0;
        ArrayList<Integer>ans = new ArrayList<>();

    subSet(arr,idx,ans);
    }
}
