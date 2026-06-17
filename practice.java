
public class practice{


    public static void main(String[] args) {
        int[] arr={-2,-3,4,-1,-2,1,5,-3};
        int maxi=0;
        int ps=0;
        for(int i=0;i<arr.length;i++){
            ps=ps+arr[i];
            if(ps<0) ps=0;
            maxi=Math.max(maxi, ps);
        }
        System.out.println(maxi);
    }
}
