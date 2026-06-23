package LinkedList.Hard;

import java.util.PriorityQueue;

public class mergeKSortedList{

    static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LL {

        Node head;

        void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                Node curr = head;
                while (curr.next != null) {
                    curr = curr.next;
                }
                curr.next = newNode;
            }
        }
//Alog -> Priority Queue

Node mergeKLists(Node[] lists){
    PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.data-b.data);

    for(Node head : lists){
        if(head!=null){
            pq.add(head);
        }
    }
    Node dummy = new Node(-1);
    Node temp = dummy;
    while(!pq.isEmpty()){
        Node smallest= pq.remove();
        temp.next=smallest;
        temp=temp.next;

        if(smallest.next!=null){
            pq.add(smallest.next);
        }
    }
    return dummy.next;
}
        void printLL() {
            if (head == null) {
                return;
            }
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.data + "->");
                curr = curr.next;
            }
            System.out.print("null");
        }

    }

   public static void main(String[] args) {

    LL list1 = new LL();
    list1.add(1);
    list1.add(4);
    list1.add(5);

    LL list2 = new LL();
    list2.add(1);
    list2.add(3);
    list2.add(4);

    LL list3 = new LL();
    list3.add(2);
    list3.add(6);

    Node[] lists = {list1.head, list2.head, list3.head};

    LL obj = new LL();

    Node mergedHead = obj.mergeKLists(lists);

    Node curr = mergedHead;
    while(curr != null){
        System.out.print(curr.data + "->");
        curr = curr.next;
    }
    System.out.println("null");
}
}
