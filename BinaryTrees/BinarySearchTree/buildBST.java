package BinaryTrees.BinarySearchTree;

public class buildBST {
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
    public static Node insert(Node root , int vals){
        if(root==null){
            root=new Node(vals);
            return root;
        }
        if(root.data > vals){
            root.left=insert(root.left, vals);
        }else{
            root.right=insert(root.right, vals);
        }
        return root;
    }
    public static void main(String[] args) {
        int[] val = {5,1,3,4,2,7};
        Node root=null;

        for(int i=0;i<val.length;i++){
            root=insert(root,val[i]);
        }
 
    }
    
}
