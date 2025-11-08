
public class DLL {

    static class Node {

        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoubleLL {

        Node head;
        Node tail;

        void add(int data) {
            Node newnNode = new Node(data);
            if (head == null) {
                head = tail = newnNode;
                return;
            }
            tail.next = newnNode;
            newnNode.prev = tail;
            tail = newnNode;
        }

        
        int previous() {
            return tail.prev.data;
        }

        void print() {
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.data + "<->");
                curr = curr.next;
            }
            System.out.println("null");

        }
    }

    public static void main(String[] args) {
        DoubleLL list = new DoubleLL();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        list.print();

      System.out.println(list.previous());

    }
}
