package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeTraversal {
    static class Node{
        int data;
        Node left;
        Node right;

         Node(int data) {
            this.data=data;
            this.left = null;
            this.right = null;
        }
    }


//Pre order tree traversal
 static void preOrder(Node root){

      if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    } 
//Iterative Pre order tree traversal (Using stack)

static void IterativePreOrder(Node root){

    Stack<Node> st = new Stack<>();
      st.push(root);

    while(!st.isEmpty()){
        Node curr = st.pop();

           System.out.print(curr.data+ " ");

        if(curr.right!=null){
            st.add(curr.right);
        }
        if(curr.left!=null){
            st.add(curr.left);
        }
    }     
}
//In-order tree traversal
    public static void InOrder(Node root){

        if(root==null) return;

        InOrder(root.left);

        System.out.print(root.data + " ");

        InOrder(root.right);
        
    }
//Post-order tree traversal
        public static void PostOrder(Node root){

        if(root==null) return;

        PostOrder(root.left);

        PostOrder(root.right);

          System.out.print(root.data + " ");
        
    }

    //Level Order traversal   -> (BFS)

    
  public static void LevelOrder(Node root){
    if(root == null) return;

    Queue<Node> q = new LinkedList<>();
    q.add(root);
    q.add(null);

    while(!q.isEmpty()){
        Node curr = q.remove();
        if(curr == null){
            System.out.println();
        if(q.isEmpty()){
            break;
        }else{
            q.add(null);
        }
    }else{
        System.out.print(curr.data + " ");
        if(curr.left != null){
            q.add(curr.left);
        }
        if(curr.right != null){
            q.add(curr.right);
        }
    }
    }
  }


    public static void main(String[] args) {
            Node root = new Node(1);
        root.left=new Node(2);
        root.right= new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.right=new Node(6);

        // preOrder(root);
         InOrder(root);
        // PostOrder(root);
        // LevelOrder(root);
        // IterativePreOrder(root);
    }
}
