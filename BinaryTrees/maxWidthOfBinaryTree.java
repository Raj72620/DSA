package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class maxWidthOfBinaryTree{

   static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left=null;
            this.right=null;
        }
    }

    static class Info{
        Node root;
        int idx;

        public Info(Node root , int idx) {
            this.root=root;
            this.idx=idx;
        }
    }

    public static int widthOfBinaryTree(Node root) {

        if (root == null) return 0;

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(root, 0));

        int ans = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            int min = q.peek().idx;
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Info currInfo = q.poll();
                int curr = currInfo.idx - min;
                Node currentRoot = currInfo.root;

                if (i == 0) first = curr;
                if (i == size - 1) last = curr;

                if (currentRoot.left != null) {
                    q.add(new Info(currentRoot.left, curr * 2 + 1));
                }

                if (currentRoot.right != null) {
                    q.add(new Info(currentRoot.right, curr * 2 + 2));
                }
            }

            ans = Math.max(ans, last - first + 1);
        }

        return ans;
    }

    public static void main(String[] args) {

           Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println(widthOfBinaryTree(root));
    
    }
}
