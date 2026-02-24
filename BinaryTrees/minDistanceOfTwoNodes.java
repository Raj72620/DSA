package BinaryTrees;

public class minDistanceOfTwoNodes {
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

    public static Node lcaProblem(Node root , int n1 , int n2){

        if(root==null || root.data==n1 || root.data==n2){
            return root;
        }
       Node leftlca = lcaProblem(root.left, n1, n2);
       Node rightlca = lcaProblem(root.right, n1, n2);

       if(leftlca==null) return rightlca;
       if(rightlca==null) return leftlca;

       return root;

    }

    public static int minDis(Node root ,int n1 ,int n2){

        Node lcaNode = lcaProblem(root, n1, n2);

        int dist1 = lcaDist(lcaNode,n1);
        int dist2 = lcaDist(lcaNode,n2);

        return dist1+dist2;
    }

    public static int lcaDist(Node root , int n){

        if(root==null) return -1;

        if(root.data==n) return 0;

        int leftDist =lcaDist(root.left, n);
        int rightDist =lcaDist(root.right, n);

        if(leftDist==-1 && rightDist==-1) return -1;

        else if(leftDist==-1) return rightDist+1;

        else return leftDist+1;
    }

    public static void main(String[] args) {

                Node root = new Node(1);
        root.left=new Node(2);
        root.right= new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.right=new Node(6);

       System.out.println(minDis(root, 4, 6));
    }
    
}
