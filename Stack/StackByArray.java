package Stack;

import java.util.ArrayList;

//Implementing stack using array
class StackByArray {

    int arr[];
    int top;
    int currSize;

    StackByArray(int size) {
        arr = new int[size];
        top = -1;
        currSize = size;
    }

    void push(int data) {
        if (top == currSize - 1) {
            System.out.println("stack ocverflow " + data);
            return;
        }
        top++;
        System.out.println("pushed " + data);
        arr[top] = data;
    }

    int pop() {
        if (top == -1) {
            return -1;
        }
        int popped = arr[top];
        top--;
        return popped;
    }

    boolean isEmpty() {
        return top == -1;
    }

    int size() {
        return top + 1;
    }

    void display() {
        if (top == -1) {
            return;
        }
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

//Implementing stack using LL
//push,pop,isEmpty,peek,display
     static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

 static class StackLL {

        Node head = null;

        void push(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
        }

        int pop() {
            if (head == null) {
                return -1;
            }
            int popped = head.data;
            head = head.next;
            System.out.println("Popped element is " + popped);
            return popped;
        }

        boolean isEmpty() {
            return head == null;
        }

        int peek() {
            if (head == null) {
                return -1;
            }
            return head.data;
        }

        void display() {
            Node current = head;
            while (current != null) {

                System.out.print(current.data + "->");
                current = current.next;
            }
            System.out.println("null");
        }
    }

//Implementing Queue using Array
//Enqueue , Dequeue , peek , size , isEmpty , Display
    static class Queue {

        int arr[];
        int currsize;
        int front;
        int rear;

        Queue(int size) {
            arr = new int[size];
            front = -1;
            rear = -1;
            currsize = size;
        }

        void enqueue(int data) {
            if (rear == currsize - 1) {
                System.out.println("queue overflow reached max");
                return;
            }
            if (front == -1) {
                front = 0;
            }
            rear++;
            System.out.println("added " + data);
            arr[rear] = data;
        }

        int dequeue() {
            if (rear == -1) {
                return -1;
            }
            int popped = arr[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front++;
            }
            System.out.println("removed " + popped);
            return popped;
        }

        int size() {
            if (front == -1) {
                return -1;
            }
            return rear - front + 1;
        }

        int peek() {
            if (front == -1) {
                return -1;
            }
            return arr[front];
        }

        boolean isEmpty() {
            return front == -1;
        }

        void display() {
            if (front == -1) {
                return;
            }

            for (int i = front; i <= rear; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

//Implementing Queue using ArrayList
    static class QueueArrayList {

        ArrayList<Integer> list = new ArrayList<>();

        void enqueue(int data) {
            list.add(data);
        }

        int dequeue() {
            if (isEmpty()) {
                return -1;
            }
            int top = list.get(0);
            list.remove(0);
            System.out.println("Removed element is " + top);
            return top;
        }

        boolean isEmpty() {
            return list.isEmpty();
        }

        int peek() {
            return list.get(0);
        }

        int size() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.size();
        }

        void display() {
            if (list.isEmpty()) {
                return;
            }
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }


    
//Implementing Queue usin LL

public class QueueUsingLL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class QueueLinkedList {
        Node head = null;
        Node tail = null;

        void push(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        int pop() {
            if (head == null) return -1;
            int popped = head.data;
            if(head==tail){
                head=tail=null;
            }else{
            head = head.next;
            }
            return popped;
        }

        int peek() {
            if (head == null) return -1;
            return head.data;
        }

        boolean isEmpty() {
            return head == null;
        }

        void display() {
            if (head == null) {
                System.out.println("Queue is empty");
                return;
            }
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }

    //Implementing circular queue uisng array
    //we neede to check always whether there is a space or not to add a element 
    //If yes then we will apply formula of (Index = Index+1 % size)

    static class circularQueue{
        int[] arr;
        int currsize,front,rear,count;

        public circularQueue(int size) {
            arr=new int[size];
            currsize=size;
            front=rear=-1;
            count=0;
        }

        void enqueue(int data){
            if(count==currsize){
                System.out.println("Queue overflow " +data);
                return;
            }
            if(front==-1){
                front=0;
            }
            rear=(rear+1)%currsize;
            arr[rear]=data;
            count++;
        }
        
        int dequeue(){
            if(front==-1) return -1;
            if(front==rear){
                front=rear=-1;
            }
            int popped=arr[front];
            front++;
            count--;
            return popped;
        }
        int peek(){
            return arr[front];
        }

        boolean isEmpty(){
            return front==-1;
        }
        void display(){
            if(isEmpty()) return;
            for(int i=0;i<currsize;i++){
                System.out.print(arr[i]+ " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        StackByArray st = new StackByArray(4);
        // st.push(1);
        // st.push(2);
        // st.push(3);
        //st.display();
        // st.pop();
        //st.display();

        StackLL stLL = new StackLL();
        // stLL.push(1);
        // stLL.push(2);
        // stLL.push(3);
        // stLL.display();
        // stLL.pop();
        // System.out.println("Peek element is " + stLL.peek());

        Queue q = new Queue(4);
        // q.enqueue(10);
        // q.enqueue(20);
        // q.enqueue(30);

        // q.dequeue();
        // q.display();
        // System.out.println("front element is " +q.peek());
        QueueArrayList que = new QueueArrayList();
        //     que.enqueue(1);
        //     que.enqueue(2);
        //     que.enqueue(3);
        //     que.enqueue(4);
        //     que.display();

        //     que.dequeue();
        //    System.out.println("The top eleemnt is " + que.peek());
        //    System.out.println("Size of the list is " + que.size());

        circularQueue cq = new circularQueue(4);
        //     cq.enqueue(1);
        //     cq.enqueue(2);
        //     cq.enqueue(3);
        //   cq.display();

        //   cq.dequeue();
        //   System.out.println(cq.peek());

        //   cq.enqueue(40);
        //   cq.enqueue(50);
        //   cq.display();

        QueueLinkedList list= new QueueLinkedList();
        list.push(1);
        list.push(2);
        list.push(3);
        list.display();
    }
}
}
