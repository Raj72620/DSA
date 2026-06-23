package LinkedList.Hard;

public class reverseNodeKGroups{
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

        void reverseKGroups(int k){
            if(head==null || k==1) return;

            Node dummy = new Node(-1);
            dummy.next=head;

            Node prevGroupEnd=dummy;
            while(true){
                Node groupStart = prevGroupEnd.next;

                //find kth node
                Node kthNode = findKthNode(groupStart,k-1);
                if(kthNode==null){
                    break;
                }
                Node nxtGroupStart=kthNode.next;
                kthNode.next=null;

                //Reverse function
                Node reversed=reverse(groupStart);

                prevGroupEnd.next=reversed;
                groupStart.next=nxtGroupStart;
                prevGroupEnd=groupStart;
            }
            head=dummy.next;
        }
        Node findKthNode(Node start , int idx){
            Node curr=start;
            for(int i=0;i<idx;i++){

                if(curr==null) return null;
                curr=curr.next;
            }
            return curr;
        }

        Node reverse(Node start){
            Node prev= null;
            Node curr=start;
            while(curr!=null){
                Node nxt = curr.next;
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
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4); 
        list.add(5);

        list.reverseKGroups(2);
        list.printLL();
    }
}
