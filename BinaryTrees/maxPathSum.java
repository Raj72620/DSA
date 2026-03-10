package BinaryTrees;

public class maxPathSum{

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
    static int maxi = Integer.MIN_VALUE;
    public static int maxPathSum(Node root){
        
        if(root == null) return 0;

        int leftMax = Math.max(0, maxPathSum(root.left));
        int rightMax = Math.max(0, maxPathSum(root.right)); 

        maxi = Math.max(maxi, root.data+leftMax+rightMax);

        return root.data + Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {

        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.right.left = new Node(-30);
        root.right.right = new Node(-15);
 
        maxPathSum(root);
        System.out.println(maxi);

    }
}
