package BinaryTrees;

public class BalancedBinaryTree {
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
        public static int balancedBinaryTree(Node root){

        if(root ==null) return 0;

        int leftHg = balancedBinaryTree(root.left);
        int rightHg = balancedBinaryTree(root.right);

        if(leftHg==-1 || rightHg==-1) return -1;

        if(Math.abs(leftHg-rightHg) > 1) return -1;
        return Math.max(leftHg, rightHg)+1;
    }
    public static void main(String[] args) {
              Node root = new Node(1);
        root.left=new Node(2);
        root.right= new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.right=new Node(6);

        System.out.println(balancedBinaryTree(root));
    }
    
}
