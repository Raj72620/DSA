package BinaryTrees.BinarySearchTree;

public class validateBST {
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
public static boolean isValid(Node root, long min, long max) {

    if (root == null)
        return true;
    if (root.data <= min || root.data >= max)
        return false;

    return isValid(root.left, min, root.data)
        && isValid(root.right, root.data, max);
}

    public static void main(String[] args) {
         Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left=new Node(1);
        root.left.right=new Node(4);

        System.out.println(isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
