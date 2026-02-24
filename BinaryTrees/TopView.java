package BinaryTrees;
import java.util.*;

public class TopView {
    
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class Info {
        Node node;
        int hd; // horizontal distance

        public Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    // Method 1: Using single queue with Info class
    public static void topView(Node root) {

        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>(); 

        q.add(new Info(root, 0));
        int min = 0;
        int max = 0;

        while (!q.isEmpty()) {
            Info curr = q.remove();

            if (!map.containsKey(curr.hd)) {
                map.put(curr.hd, curr.node.data);
            }
            if (curr.node.left != null) {
                q.add(new Info(curr.node.left, curr.hd - 1));
                min = Math.min(min, curr.hd - 1);
            }
            if (curr.node.right != null) {
                q.add(new Info(curr.node.right, curr.hd + 1));
                max = Math.max(max, curr.hd + 1);
            }
        }
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i) + " ");
        }
        System.out.println();
    }

    // Method 2: Using two queues (your iterative approach - corrected)

    public static void topViewIteration(Node root) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        Queue<Node> nodeQueue = new LinkedList<>();
        Queue<Integer> hdQueue = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>(); 

        int min = 0, max = 0;

        nodeQueue.add(root);
        hdQueue.add(0);

        while (!nodeQueue.isEmpty()) {
            Node currNode = nodeQueue.remove();
            int currHd = hdQueue.remove();

            if (!map.containsKey(currHd)) {
                map.put(currHd, currNode.data);
            }
            if (currNode.left != null) {
                nodeQueue.add(currNode.left);
                hdQueue.add(currHd - 1);
                min = Math.min(min, currHd - 1);
            }
            if (currNode.right != null) {
                nodeQueue.add(currNode.right);
                hdQueue.add(currHd + 1);
                max = Math.max(max, currHd + 1);
            }
        }
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        topView(root); // 4 2 1 3 6
    }
}