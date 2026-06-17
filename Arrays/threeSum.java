package Arrays;
import java.util.*;

public class threeSum {

    public static ArrayList<ArrayList<Integer>> sum(int[] arr){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);

        for(int i=0;i<arr.length-2;i++){
            if(i>0 && arr[i]==arr[i-1]){
                continue;
            }
            int j=i+1;
            int k=arr.length-1;

            while(j<k){
                int sum = arr[i]+arr[j]+arr[k];
                if(sum==0){
                   ArrayList<Integer> ans = new ArrayList<>();
                   ans.add(arr[i]);
                   ans.add(arr[j]);
                   ans.add(arr[k]);
                   result.add(ans);

                   while(j<k && arr[j]==arr[j+1]) j++;
                   while(j<k && arr[k]==arr[k-1]) k--;
                   j++;
                   k--;
                }
                else if(sum<0){
                    j++;
                }else{
                    k--;
                }

            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr={-1,0,1,2,-1,4};
        ArrayList<ArrayList<Integer>> ans = sum(arr);
       for(int i=0;i<ans.size();i++){
        System.out.println(ans.get(i));
       }

    }
}
