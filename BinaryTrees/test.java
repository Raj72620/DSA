package BinaryTrees;

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
    
 static class findingpathSum{
     int maxSum =Integer.MIN_VALUE;

     public int maxPath(Node root){
         maxPathSum(root);
        return maxSum;
     } 

     
   public int maxPathSum(Node root){
    if(root==null) return 0;

    int leftVal = Math.max(0,maxPathSum(root.left));

    int rightVal = Math.max(0, maxPathSum(root.right));

    maxSum = Math.max(maxSum, root.data+leftVal+rightVal);

    return root.data+Math.max(leftVal, rightVal);
   }
}
    public static void main(String[] args) {

        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        root.right.left = new Node(6);
        //root.right.right= new Node(7);

    }
}
