package BinaryTrees.medium;

import java.util.LinkedList;
import java.util.Queue;

public class minDepth{

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
    //Recursion sol
    public static int minDepth(Node root) {
        if (root == null) return 0;

        if (root.left == null)
            return 1 + minDepth(root.right);

        if (root.right == null)
            return 1 + minDepth(root.left);

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    //BFS Approach
      public static int minDepthOptimal(Node root) {
        if (root == null) return 0;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int depth = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node curr = q.remove();

                // First leaf node → return immediately
                if (curr.left == null && curr.right == null)
                    return depth;

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }

            depth++;
        }

        return depth;
    }
   
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
       root.right.right = new Node(5);    
    System.out.println(minDepth(root));
       
    }
}