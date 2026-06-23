package LinkedList.singleLL;

public class mergeTwoSortedList{
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

      //Recursive solution
      Node merge(Node head1 , Node head2){
        if(head1==null) return head2;
        if(head2==null) return head1;

        if(head1.data<=head2.data){
            head1.next=merge(head1.next, head2);
            return head1;
        }else{
            head2.next=merge(head1, head2.next);
            return head2;
        }
      }
      //Iterative solution

      Node mergeIteration(Node head1,Node head2){
        Node dummy= new Node(-1);
        Node curr=dummy;
        while(head1!=null && head2!=null){
            if(head1.data<=head2.data){
                curr.next=head1;
                head1=head1.next;
            }else{
                curr.next=head2;
                head2=head2.next;
            }
            curr=curr.next;
        }
            if(head1!=null){
                curr.next=head1;
            }else{
                curr.next=head2;
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
        list1.add(3);
        list1.add(5);


        LL list2 = new LL();
        list2.add(2);
        list2.add(4);
        list2.add(6);

        LL merger = new LL();
        Node mergeHead = merger.mergeIteration(list1.head, list2.head);

            LL m = new LL();
            m.head=mergeHead;
            m.printLL();
        

    }
}
