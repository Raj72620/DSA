package Greedy;
import java.util.*;

public class FractionalKnapsack {

    public static void MaximumTotal(int[] val, int[] wt , int capacity){

        double ratio[][] = new double[val.length][2];

        for(int i=0;i<val.length;i++){
            ratio[i][0]=i;
            ratio[i][1]=val[i]/(double)wt[i];
        }
        Arrays.sort(ratio , Comparator.comparingDouble(o->o[1]));
        int ans=0;
        int knapsack = capacity;

        for(int i=ratio.length-1;i>=0;i--){
            int idx = (int)ratio[i][0];
            if(knapsack >= wt[idx]){
                ans+=val[idx];
                knapsack-=wt[idx];
            }else{
                ans+= (ratio[i][1]*knapsack);
                knapsack=0;
                break;
            }
        }
        System.out.println(ans);

    }
    public static void main(String[] args) {
        int[] val={60,100,120};
        int[] wt={10,20,30};

        MaximumTotal(val,wt ,50);
    }
    
}
