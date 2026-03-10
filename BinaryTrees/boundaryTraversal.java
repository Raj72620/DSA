package BinaryTrees;

public class boundaryTraversal {

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

    public static void SpiralTraversal(Node root){
        if(root == null) return;

        System.out.print(root.data+ " ");
        LeftTraversal(root.left);

        LeafTraversal(root.left);
        LeafTraversal(root.right);

        RightTraversal(root.right);
    }
    public static void LeftTraversal(Node root){

        if(root == null) return;
        if(root.left==null && root.right==null) return;

        System.out.print(root.data+ " ");
        if(root.left!=null){
            LeftTraversal(root.left);
        }else{
            LeftTraversal(root.right);
        }
    }

    public static void LeafTraversal(Node root){
        if(root == null) return;
        LeafTraversal(root.left);

        if(root.left==null && root.right==null){
            System.out.print(root.data+ " ");
        }
        LeafTraversal(root.right);
    }

    public static void RightTraversal(Node root){
        if(root == null) return;

        if(root.left==null && root.right==null) return;

        if(root.right!=null){
            RightTraversal(root.right);
        }else{
            RightTraversal(root.left);
        }
        System.out.print(root.data+ " ");
    }
    public static void main(String[] args) {
         Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left=new Node(10);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        SpiralTraversal(root);
    }
    
}
