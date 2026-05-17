import java.util.*;


public  class practice{
    

 
    public static void main(String[] args) {
       int[] arr={1, 10, 12, 9, 2, 3};
       int k=4;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<k;i++){
            if(arr[i]<k){
            pq.add(arr[i]);
            }
        }
        int count =0;
        while(!pq.isEmpty()){
                int add=pq.remove();
            int rem = pq.remove();
            add+=rem;
            count++;
        }
        System.out.println(count);
    }
}