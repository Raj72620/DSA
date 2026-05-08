package BinaryTrees;

public class flattenBinaryTree {
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
    public static void flatten(Node root){
        Node curr = root;

        while(curr!=null){
        if(curr.left!=null){
            Node pred = curr.left;
            while(pred.right!=null){
                pred= pred.right;
            }
            pred.right=curr.right;
            curr.right=curr.left;
            curr.left=null;
        }
        curr=curr.right;
        }

        Node temp = root;
        while(temp!=null){
            System.out.print(temp.data+ " ");
            temp=temp.right;
        }
    }
    public static void main(String[] args) {
                Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        flatten(root);
    }
    
}
