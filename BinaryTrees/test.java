package BinaryTrees;


public class test{

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

public static int diameter(Node root){
    if(root==null) return 0;

    int leftDia = diameter(root.left);

    int rightDia= diameter(root.right);

    return Math.max((leftDia+rightDia),Math.max(leftDia,leftDia)+1);

}

    public static void main(String[] args) {

           Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println(diameter(root));
    
    }
}
