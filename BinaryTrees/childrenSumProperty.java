package BinaryTrees;

public class childrenSumProperty {
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
    public static boolean checkChildSum(Node root){
        if(root ==null) return true;

        if(root.left==null && root.right==null) return true;

        int leftVal = (root.left!=null) ? root.left.data :0;
        int rightVal =(root.right!=null)? root.right.data :0;

        if(root.data!= leftVal+rightVal) return false;

        return checkChildSum(root.left) && checkChildSum(root.right);
    }

    public static void main(String[] args) {

          Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left=new Node(3);
        root.left.right = new Node(5);
        root.right.right = new Node(2);

        System.out.println(checkChildSum(root));
    }
    
}
