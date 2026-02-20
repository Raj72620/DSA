package BinaryTrees;

public class MaxHeightOfNodes {

    static class Node{
        int data ;
        Node left , right;

        Node(int data){
            this.data =data;
            this.left=null;
            this.right=null;
        }
    }
    public static int height(Node root){

        if(root ==null) return 0;

        int leftHg = height(root.left);
        int rightHg = height(root.right);

        return Math.max(leftHg, rightHg)+1;
    }
    
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        
        System.out.println("the total height of nodes is " + height(root));
    }
}
