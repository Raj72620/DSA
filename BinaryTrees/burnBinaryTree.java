package BinaryTrees;
import java.util.*;

public class burnBinaryTree{

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
    // creating parent Map as well as finding out the targeted Node

    private static Node buildParentMap(Node root , Map<Node,Node>parentMap , int target){
        if(root ==null) return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        parentMap.put(root, null);
        Node targetNode = null;

        while(!q.isEmpty()){
            Node curr = q.remove();

            if(curr.data==target) targetNode=curr;

            if(curr.left!=null){
                parentMap.put(curr.left, curr);
                q.add(curr.left);
            }   
            if(curr.right!=null){
                parentMap.put(curr.right, curr);
                q.add(curr.right);
            }
        }
        return targetNode;
    }
//main logic to burn 

    public static int burnBinaryTree(Node root,int target){
        Map<Node,Node> parentMap =new HashMap<>();
        Node targetNode = buildParentMap(root, parentMap, target);

        if(targetNode==null) return 1;

        Queue<Node> q = new LinkedList<>();
        Set<Node> visitedNodes = new HashSet<>();

        q.add(targetNode);
        visitedNodes.add(targetNode);
        int time =0;

        while(!q.isEmpty()){
            int len = q.size();
            boolean isBurned =false;

            for(int i=0;i<len;i++){
                Node curr = q.remove();

                if(curr.left!=null && !visitedNodes.contains(curr.left)){
                        visitedNodes.add(curr.left);
                        q.add(curr.left);
                        isBurned=true;
                }   
                if(curr.right!=null && !visitedNodes.contains(curr.right)){
                     visitedNodes.add(curr.right);
                    q.add(curr.right);
                    isBurned=true;
                }

                Node parent = parentMap.get(curr);
                if(parent!=null && !visitedNodes.contains(parent)){
                    q.add(parent);
                    visitedNodes.add(parent);
                    isBurned=true;
                }
            }
            if(isBurned) time++;
        }
        return time;
    }
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left=new Node(4);
        root.left.left.right=new Node(7);
        root.right.left = new Node(5);
        root.right.right = new Node(6);

        System.out.println(burnBinaryTree(root, 4));
    }
}
