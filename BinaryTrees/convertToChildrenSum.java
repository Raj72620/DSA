package BinaryTrees;

public class convertToChildrenSum{

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

    // Problem 2: CONVERT tree to satisfy property
    public static void convertToChildrenSum(Node root) {
        if (root == null) return;
        
        // First convert children recursively
        convertToChildrenSum(root.left);
        convertToChildrenSum(root.right);
        
        // Calculate sum of children
        int leftVal = (root.left != null) ? root.left.data : 0;
        int rightVal = (root.right != null) ? root.right.data : 0;
        int childSum = leftVal + rightVal;
        
        // If current node value > child sum, increase children
        if (root.data > childSum) {
            if (root.left != null) {
                root.left.data += (root.data - childSum);
            } else if (root.right != null) {
                root.right.data += (root.data - childSum);
            }
        }
        // If current node value < child sum, increase current node
        else if (root.data < childSum) {
            root.data = childSum;
        }
    }
    
    // Helper to print tree (in-order)
    public static void printTree(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        printTree(root.left);
        printTree(root.right);
    }
   
    public static void main(String[] args) {

           Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
    

        convertToChildrenSum(root);
        printTree(root);
       
    }
}
