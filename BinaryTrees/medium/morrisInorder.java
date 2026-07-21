package BinaryTrees.medium;

public class morrisInorder {
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
    public static void morrisInorder(Node root){

        Node curr = root;
        while(curr!=null){
            if(curr.left==null){
                System.out.print(curr.data+ " ");
                curr=curr.right;
            }else{
                Node pred = curr.left;
                while(pred.right!=null && pred.right!=curr){
                    pred=pred.right;
                }
                if(pred.right==null){
                    pred.right=curr;
                    curr=curr.left;
                    
                }
                else{
                    pred.right=null;
                    System.out.print(curr.data+ " ");
                    curr=curr.right;
                }
            }
        }
    }

    //Morris PreOrder traversal

        public static void morrisPreorder(Node root){

        Node curr = root;
        while(curr!=null){
            if(curr.left==null){
                System.out.print(curr.data+ " ");
                curr=curr.right;
            }else{
                Node pred = curr.left;
                while(pred.right!=null && pred.right!=curr){
                    pred=pred.right;
                }
                if(pred.right==null){
                    pred.right=curr;

                    System.out.print(curr.data+ " ");
                    
                    curr=curr.left;
                    
                }
                else{
                    pred.right=null;
            
                    curr=curr.right;
                }
            }
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        morrisInorder(root);
    }
    
}
