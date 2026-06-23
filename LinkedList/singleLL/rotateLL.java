package LinkedList.singleLL;

public class rotateLL {

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

        Node rotate(int k) {

            if (head == null || head.next == null) {
                return head;
            }

            Node curr = head;
            int count = 1;

            while (curr.next != null) {
                curr = curr.next;
                count++;
            }

            k = k % count;

            if (k == 0) {
                return head;
            }

            int kthPos = count - k;

            curr.next = head; // make circular

            curr = head;
            int idx = 1;

            while (idx < kthPos) {
                curr = curr.next;
                idx++;
            }

            Node startingPoint = curr.next;
            curr.next = null;
            head = startingPoint;

            return head;
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

        list.rotate(2);
        list.printLL();

    }
}
