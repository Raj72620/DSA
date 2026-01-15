package Greedy;
import java.util.*;

public class FractionalKnapsack {

    public static void MaximumTotal(int[] values, int[] weights){
        int knapsack=50;

        double ratio[][] = new double[values.length][2];

        for(int i=0;i<values.length;i++){
            ratio[i][0]=i;
            ratio[i][1]=values[i]/(double)weights[i];
        }
        Arrays.sort(ratio , Comparator.comparingDouble(o->o[1]));
        int ans=0;
        int capacity=knapsack;

        for(int i=ratio.length-1;i>=0;i--){
            int idx = (int)ratio[i][0];
            if(capacity >= weights[idx]){
                ans+=values[idx];
                capacity-=weights[idx];
            }else{
                ans+= (ratio[i][1]*capacity);
                capacity=0;
                break;
            }
        }
        System.out.println(ans);

    }
    public static void main(String[] args) {
        int[] values={60,100,120};
        int[] weights={10,20,30};

        MaximumTotal(values,weights);
    }
    
}
