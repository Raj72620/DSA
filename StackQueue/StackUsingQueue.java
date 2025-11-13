package StackQueue;

import java.util.LinkedList;
import java.util.Queue;

//Using 1-Queue method
//Rotating the stack elements in order to maintain queue opeartions
 class StackUsingQueue {
    Queue<Integer> q = new LinkedList<>();

    void push(int data){

        q.add(data);
        for(int i=0;i<q.size();i++){
            q.add(q.remove());
        }
    }
    void pop(){
        q.remove();
          
    }
    int peek(){
        return q.peek();
    }
    boolean isEmpty(){
        return q.isEmpty();
    }
void display() {
    if (isEmpty()) {
        System.out.println("Queue is empty!");
        return;
    }
    System.out.print("Stack elements (top → bottom): ");
    for (int val : q) {
        System.out.print(val + " ");
    }
    System.out.println();
}

//Using 2-Queue method
//creating two empty queues q1,q2 ->transferring  ele from q1 to q2 till one ele left in q1 
//stroing that one left ele and returning then again swapping q2 -> q1 

static class TwoQueue{
    Queue<Integer>q1=new LinkedList<>();
    Queue<Integer>q2=new LinkedList<>();

    void Enqueue(int data){
        q1.add(data);
    }
    int Dequeue(){
        if(q1.isEmpty()&&q2.isEmpty()) return -1;

        while(q1.size()>1){
            q2.add(q1.remove());
        }
        int popped =q1.remove();
        Queue<Integer> temp= q1;
        q1=q2;
        q2=temp;
        return popped;
    }
    int peek(){
        while(q1.size()>1){
            q2.add(q1.remove());
        }
        int top=q1.peek();
        q2.add(q1.remove());
        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;
        return top;
    }
    boolean isEmpty(){
        return q1.isEmpty()&&q2.isEmpty();
    }
    void display(){
        for(int val: q1){
            System.out.print(val+ " ");
        }
        System.out.println();
    }
}


public static void main(String[] args) {
    StackUsingQueue st=new StackUsingQueue();
    // st.push(1);
    // st.push(2);
    // st.push(3);
    // System.out.println(st.peek());
    // st.display();
    // st.pop();
    // System.out.println(st.peek());

    TwoQueue stack = new TwoQueue();
    // stack.Enqueue(10);
    // stack.Enqueue(20);
    // stack.Enqueue(30);
    // stack.display();
    // System.out.println("top ele is " +stack.peek());
    // stack.Dequeue();
    // stack.display();
    // System.out.println("top ele is " +stack.peek());
}
    
}
