package BinaryTrees;

import java.util.*;

public class maxWidthOfBinaryTree{

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

 public static class Info{
    Node root;
    int idx;

         Info(Node root,int idx) {
            this.root=root;
            this.idx=idx;
        }
 }
 public static Info maxWidth(Node root){
    if(root==null) return new Info(null, 0);
    Deque<Info> dq = new LinkedList<>();
    int width =0;
    dq.add(new Info(root, 0));

    while(!dq.isEmpty()){
        int len = dq.size();

        int firstIdx = dq.getFirst().idx;
        int lastIdx = dq.getLast().idx;

         width = Math.max(width, lastIdx-firstIdx+1);

        for(int i=0;i<len;i++){
            Info curr = dq.removeFirst();

            if(curr.root.left!=null){
                dq.add(new Info(curr.root.left, 2*curr.idx));
            }
            if(curr.root.right!=null){
                dq.add(new Info(curr.root.right, 2*curr.idx+1));
            }
        }
    }
    
    return new Info(root, width);
 }
     
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
       root.right.right = new Node(5);    
         System.out.println(maxWidth(root).idx);
    }
}