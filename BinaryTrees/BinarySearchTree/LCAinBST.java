package BinaryTrees.BinarySearchTree;

public class LCAinBST {
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
    public static int findLCA(Node root,int n1, int n2){
        if(root==null){
            return -1;
        }
        if(root.data > n1 && root.data > n2){
            return findLCA(root.left, n1, n2);
        }
        else if(root.data < n1 && root.data < n2){
            return findLCA(root.right, n1, n2);
        }else{
        return root.data;
        }
    }
    public static void main(String[] args) {

        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(60);
        root.left.left=new Node(5);
        root.left.right=new Node(20);

        root.right.left=new Node(55);
        root.right.right=new Node(70);

        System.out.println(findLCA(root, 30, 55));
    }
}
