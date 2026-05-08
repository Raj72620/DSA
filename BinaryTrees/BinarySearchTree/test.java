package BinaryTrees.BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class test {
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
public static void zigZagPrint(Node root) {

    if (root == null) return;
    ArrayList<Integer> list = new ArrayList<>();
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    boolean leftToRight = true;
    
    while (!q.isEmpty()) {
        int levelSize = q.size();
        int[] levelNodes = new int[levelSize]; 
        
        for (int i = 0; i < levelSize; i++) {
            Node curr = q.remove();
            
            int index = leftToRight ? i : (levelSize - 1 - i);
            levelNodes[index] = curr.data;

            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
        
        for (int val : levelNodes) {
            list.add(val);
        }
        leftToRight = !leftToRight;
    }
    System.out.print(list+ " ");
}
   
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left=new Node(2);
        root.right= new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.right=new Node(6);

      zigZagPrint(root);

    }
    
}
