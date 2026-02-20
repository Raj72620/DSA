package BinaryTrees;

public class SumOfNodes{

    static class Node{
        int data ;
        Node left , right;

        Node(int data){
            this.data =data;
            this.left=null;
            this.right=null;
        }
    }
    public static int TotalSum(Node root){

        if(root ==null) return 0;

        int sum = TotalSum(root.left );

        int add = TotalSum(root.right);

        return sum+add+root.data;
        

        
    }
    
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        
        System.out.println("the total no.of  nodes is " + TotalSum(root));
    }
}
