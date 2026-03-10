package BinaryTrees;

public class checkSymmetrical {
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

    public static boolean isSymmetric(Node root){
        if(root==null) return true;

        return checkIsSymmetric(root.left , root.right);
    }
    public static boolean checkIsSymmetric(Node Left , Node Right){

        if(Left.left==null && Right.right==null) return true;

        if(Left==null || Right==null ) return false;
        
        if(Left.left.data != Right.right.data) return false;

       return checkIsSymmetric(Left.left, Right.right) &&
              checkIsSymmetric(Left.right, Right.left);
    }

    public static void main(String[] args) {
                Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left=new Node(3);
        root.left.right=new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

        System.out.println(isSymmetric(root));
    }
    
}
