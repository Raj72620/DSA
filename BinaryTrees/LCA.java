package BinaryTrees;

import java.util.ArrayList;

public class LCA {
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
    public static Node lca(Node root , int n1 , int n2){

        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        
        getPath(root ,n1,path1);
        getPath(root,n2 , path2);

        int i=0;
        for( ;i<path1.size() && i<path2.size();i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }
        Node result = path1.get(i-1);
        return result;
    }

    public static boolean getPath(Node root , int n , ArrayList<Node> path){

        if(root == null) return false;
        path.add(root);
        if(root.data==n) return true;

        boolean fondLeft = getPath(root.left, n, path);
        boolean founRight = getPath(root.right, n, path);

        if(fondLeft || founRight) return true;

        path.remove(path.size()-1);

        return false;

    }

    //Method -2 Optimized one 

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

    public static void main(String[] args) {
        
             Node root = new Node(1);
        root.left=new Node(2);
        root.right= new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.right=new Node(6);

        System.out.println(lcaProblem(root, 4, 5).data);
    }
    
}
