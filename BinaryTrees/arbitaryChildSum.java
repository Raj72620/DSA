package BinaryTrees;

public class arbitaryChildSum {
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
    
    public static void childSum(Node root){
        if(root ==null) return;

        childSum(root.left);
        childSum(root.right);

        int leftVal = (root.left!=null) ? root.left.data : 0;
        int rightVal = (root.right!=null) ? root.right.data : 0;
        int sum = leftVal+rightVal;

        if(root.data > sum){
            if(root.left!=null){
                root.left.data+=(root.data-sum);
            }else if(root.right!=null){
                root.right.data+=(root.data-sum);
            }
        }
        else if(root.data < sum){
            root.data=sum;
        }
    }
    public static void preOrder(Node root){
        if(root==null) return;

        System.out.print(root.data+ " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
        
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
    }
}
