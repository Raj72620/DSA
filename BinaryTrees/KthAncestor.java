package BinaryTrees;

public class KthAncestor {

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

    public static int KthNode(Node root ,int node, int k){

        if(root == null) return -1;

        if(root.data == node) return 0;

        int leftPath = KthNode(root.left, node, k);
        int rightPath = KthNode(root.right, node, k);

        if(leftPath==-1 && rightPath==-1) return -1;

        int max = Math.max(leftPath, rightPath);
        if(max+1==k){
            System.out.println(root.data);
        }
        return max+1;
    }

    public static void main(String[] args) {

     Node root = new Node(1);
        root.left=new Node(2);
        root.right= new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.right=new Node(6);

        KthNode(root, 2, 1);
    }
    
}
