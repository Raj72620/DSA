package StackQueue;

//InterLeave two halves of a queue (even length) and also for (odd length)

import java.util.LinkedList;
import java.util.Queue;

public class queueProb3 {
        public static void interLeave(Queue<Integer> queue){
        Queue<Integer> firstHalf= new LinkedList<>();
        int size=queue.size();

        for(int i=0;i<size/2;i++){
            firstHalf.add(queue.remove());
        }
        while(!firstHalf.isEmpty()){
            
            queue.add(firstHalf.remove());
            queue.add(queue.remove());
        }
        // If the lenght is odd
        
             if(size%2!=0){
        queue.add(queue.remove());
        }
    }
    public static void main(String[] args) {
                Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);


        interLeave(queue);

        while(!queue.isEmpty()){
            System.out.print(queue.remove()+ " ");
        }

    }
    
}
