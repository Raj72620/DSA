package BinaryTrees;

public class totalNoOfNodes{

    static class Node{
        int data ;
        Node left , right;

        Node(int data){
            this.data =data;
            this.left=null;
            this.right=null;
        }
    }
    public static int totalCount(Node root){

        if(root ==null) return 0 ;

        int leftHg = totalCount(root.left);
        int rightHg = totalCount(root.right) ;

        return (leftHg+rightHg) +1;
    }
    
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        
        System.out.println("the total no.of  nodes is " + totalCount(root));
    }
}
