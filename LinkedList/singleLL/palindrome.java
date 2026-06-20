package LinkedList.singleLL;

public class palindrome {

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

        boolean isPalin(){
            if(head==null || head.next==null) return true;

            Node slow = head;
            Node fast=head;
            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            Node secondHalf=reverse(slow);
            Node firstHalf=head;
            while(secondHalf!=null){
                if(firstHalf.data!=secondHalf.data){
                    return false;
                }
                firstHalf=firstHalf.next;
                secondHalf=secondHalf.next;
            }
            return true;
        }
        Node reverse(Node head){
            Node prev=null;
            Node curr=head;
            while(curr!=null){
                Node nxt=curr.next;

                curr.next=prev;
                prev=curr;
                curr=nxt;
            }
            return prev;
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
        LL list = new LL();
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(3);



        System.out.print(list.isPalin());

    }

}
