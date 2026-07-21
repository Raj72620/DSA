package BinaryTrees;
import java.util.*;

public class test {

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

    public static boolean checkIsTree(Node root1, Node root2) {
        if (root1 == null) {
            return false;
        }

        if (root1.data == root2.data) {
            if (solve(root1, root2)) {
                return true;
            }
        }
        return checkIsTree(root1.left, root2) || checkIsTree(root1.right, root2);
    }

    public static boolean solve(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.data != root2.data) {
            return false;
        }

        return solve(root1.left, root2.left) && solve(root1.right, root2.right);
    }

    public static int lca(Node root, int n1, int n2) {
        if (root == null) {
            return 0;
        }
        if (root.data == n1 || root.data == n2) {
            return 1;
        }

        int left = lca(root.left, n1, n2);
        int right = lca(root.right, n1, n2);

        return Math.max(left, right) + 1;

    }

    public static int sumTree(Node root) {
        if (root == null) {
            return 0;
        }

        int store = root.data;

        int left = sumTree(root.left);
        int right = sumTree(root.right);

        root.data = left + right;

        return left + right + store;
    }

    public static void Inorder(Node root) {
        if (root == null) {
            return;
        }
        Inorder(root.left);
        System.out.print(root.data + " ");
        Inorder(root.right);
    }

    static class solving {

        static int maxi = -1;

        public static int findWidth(Node root) {
            if (root == null) {
                return 0;
            }

            int left = 0;
            left = Math.max(left, findWidth(root.left));

            int right = 0;
            right = Math.max(right, findWidth(root.right));

            maxi = Math.max(maxi, root.data + left + right);

            return root.data + Math.max(left, right);
        }
    }

    public static void inorder(Node root){
        Stack<Node> st = new Stack<>();
       Node curr=root;
       while(!st.isEmpty() || curr!=null){
        if(curr!=null){
            st.push(curr);
            curr=curr.left;
        }else{
            if(st.isEmpty()) break;
            curr=st.pop();
            System.out.print(curr.data+ " ");
            curr=curr.right;
        }
       }
    }

    

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

      inorder(root);
    }
}
