package StackQueue;

import java.util.Stack;

//Implementing using 2-Stacks
//Just swappaing 
class QueueUsingStack {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    void enqueue(int data) {
        s1.push(data);
    }

    int dequeue() {
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.pop();
    }

    int peek() {
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.peek();
    }

    void display() {
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        for (int i = s2.size() - 1; i >= 0; i--) {
            System.out.print(s2.get(i) + " ");
        }
        for (int i = 0; i < s1.size(); i++) {
            System.out.print(s1.get(i) + " ");
        }
        System.out.println();
    }

    //Implementing using sngle single stack 
    //Using recursion for pop method 
    static class SingleQueue {

        Stack<Integer> st = new Stack<>();

        void enqueue(int data) {
            st.push(data);
        }

        int dequeue() {
            if (st.isEmpty()) {
                return -1;
            }
            int top = st.pop();
            if (st.isEmpty()) {
                    System.out.println("Removed ele is " + top);
                return top;
            }
            int popped = dequeue();
            st.push(top);
            return popped;
        }

        int peekEle() {
            if (st.isEmpty()) {
                return -1;
            }
            int top=st.pop();

            if (st.isEmpty()) {
                st.push(top);
                return top;
            }
            int popped = peekEle();
            st.push(top);
            return popped;
        }

        void display(){
            if(st.isEmpty()) return;
            for(int ele : st){
                System.out.print(ele+ " ");
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        QueueUsingStack st = new QueueUsingStack();
        // st.enqueue(10);
        // st.enqueue(20);
        // st.enqueue(30);
        // st.display();
        // System.out.println(st.peek());
        // st.dequeue();
        // System.out.println(st.peek());
        // st.display();

        SingleQueue stack = new SingleQueue();
        stack.enqueue(1);
        stack.enqueue(2);
        stack.enqueue(3);

        System.out.println("The top ele of the stack is " +stack.peekEle());
        stack.display();

        stack.dequeue();
    
        stack.enqueue(10);
        stack.display();
        System.out.println("The top ele of the stack is " +stack.peekEle());

    }
}
