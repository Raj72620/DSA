package BinaryTrees.BinarySearchTree;

public class mirrorBST {

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
    public static Node mirror(Node root){
        if(root==null) return null;

        Node leftMirror = mirror(root.left);
        Node rightMirror= mirror(root.right);

        root.left=rightMirror;
        root.right=leftMirror;

        return root;
    }

    
    public static void preOrder(Node root){
        if(root==null) return;

        System.out.print(root.data+ " ");

        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
             Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left=new Node(4);
        root.left.right=new Node(6);
    
        mirror(root);
        preOrder(root);
    }
}
