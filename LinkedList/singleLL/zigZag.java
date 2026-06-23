package LinkedList.singleLL;

public class zigZag{
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

        void zigzag(){
            if(head==null||head.next==null) return;
            Node slow=head;
            Node fast=head;
            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            Node mid = slow;
            Node curr=mid.next;
            mid.next=null;

            Node prev=null;
            while(curr!=null){
                Node nxt=curr.next;
                curr.next=prev;
                prev=curr;
                curr=nxt;
            }
            Node left=head;
            Node right=prev;
            Node nxtL , nxtR;
            while(left!=null && right!=null){
                nxtL=left.next;
                left.next=right;
                
                nxtR=right.next;
                right.next=nxtL;

                left=nxtL;
                right=nxtR;
            }
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
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        
  list.zigzag();
  list.printLL();
    }
}
