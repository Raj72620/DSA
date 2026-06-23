package LinkedList.singleLL;

public class mergeSortLL {
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

        Node mergeSort(Node head){
            if(head==null||head.next==null){
                return head;
            }
            Node mid = getMid(head);

            Node rightHead =mid.next;
            mid.next=null;
            Node newLeft=mergeSort(head);
            Node newRight=mergeSort(rightHead);

            return merge(newLeft,newRight);
        }
        Node getMid(Node head){
            Node slow = head;
            Node fast=head.next;
            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            return slow;
        }
        Node merge(Node head1 , Node head2){
            Node mergedLL=new Node(-1);
            Node temp = mergedLL;
            while(head1!=null && head2!=null){
                if(head1.data<=head2.data){
                    temp.next=head1;
                    head1=head1.next;
                    temp=temp.next;
                }
                else{
                    temp.next=head2;
                    head2=head2.next;
                    temp=temp.next;
                }
            }
            while(head1!=null){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }
            while(head2!=null){
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
            return mergedLL.next;
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
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        
        list.head=list.mergeSort(list.head);
        list.printLL();
    }
}
