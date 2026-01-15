package Greedy;
import java.util.*;

public class AssinCookies {
    public static int findMaximize(int[] child,int[] cookies){
        Arrays.sort(child);
        Arrays.sort(cookies);

        int i=0,j=0;
        int max=0;
        while(i<child.length && j<cookies.length){
            if(cookies[j] >= child[i]){
                max++;
                i++;
                j++;
            }else{
                j++;
            }
        }
        return max;

    }
    public static void main(String[] args) {
        int[] child={1,3,3,4,5};
        int[] cookies={1,1,2,2,3,4};

        System.out.println(findMaximize(child,cookies));
    }
    
}
