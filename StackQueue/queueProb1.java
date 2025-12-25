package StackQueue;

//Reverse a queue (using recursion)

import java.util.LinkedList;
import java.util.Queue;

public class queueProb1{
    
    // recursive function to reverse queue
    
    public static void reverseQueue(Queue<Integer> q) {

        if(q.isEmpty()) {
            return;
        }

        int front = q.poll();

        reverseQueue(q);
        
        q.add(front);
    }
    
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        
        System.out.println("Original Queue: " + q);
        reverseQueue(q);
        System.out.println("Reversed Queue: " + q);
    }
}