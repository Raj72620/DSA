package LinkedList.singleLL;

public class findCycleandDelete {

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
   
      void deleteCycle() {
    Node slow = head, fast = head;
    boolean cycle = false;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast) {
            cycle = true;
            break;
        }
    }
    if (!cycle){
        return;
    }
    slow = head;

    if (slow == fast) {
        while (fast.next != slow){
            fast = fast.next;
        }
        fast.next = null;
        return;
    }

    Node prev = null;

    while (slow != fast) {
        prev = fast;
        slow = slow.next;
        fast = fast.next;
    }
    prev.next = null;
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
        Node lastNode = list.head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = list.head.next;

        list.deleteCycle();
        list.printLL();
    }

}
