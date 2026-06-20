package LinkedList.singleLL;

public class detectCycle {

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

        boolean isCycleExits() {
            if (head == null) {
                return false;
            }

            Node slow = head;
            Node fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    System.out.print("cycle exits");
                    return true;
                }
            }
            return false;
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

        System.out.println(list.isCycleExits());
    }

}
