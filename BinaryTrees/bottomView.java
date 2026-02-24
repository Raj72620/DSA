package BinaryTrees;
import java.util.*;

public class bottomView {

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

     public static void bottomView(Node root) {

        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>(); 

        q.add(new Info(root, 0));
        int min = 0;
        int max = 0;

        while (!q.isEmpty()) {
            Info curr = q.remove();

           map.put(curr.hd, curr.node.data);

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


    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        bottomView(root);

        
    }
    
}
