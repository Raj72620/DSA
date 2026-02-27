package BinaryTrees;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class zigZagBinaryTree{

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

public static void zigZagPrint(Node root) {
    if (root == null) return;
    
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
            System.out.print(val + " ");
        }
        System.out.println(); 
        leftToRight = !leftToRight;
    }
}

// Solving using Deque  (Deque Approach)

public static void zigZagDeque(Node root) {
    if (root == null) return;
    
    Deque<Node> dq = new LinkedList<>();
    boolean leftToRight = true;
    
    dq.addFirst(root);
    
    while (!dq.isEmpty()) {
        int levelSize = dq.size();
        
        for (int i = 0; i < levelSize; i++) {
            if (leftToRight) {
                // Remove from front, add children to back
                Node curr = dq.removeFirst();
                System.out.print(curr.data + " ");
                
                if (curr.left != null) dq.addLast(curr.left);
                if (curr.right != null) dq.addLast(curr.right);
            } else {
                // Remove from back, add children to front
                Node curr = dq.removeLast();
                System.out.print(curr.data + " ");
                
                if (curr.right != null) dq.addFirst(curr.right);
                if (curr.left != null) dq.addFirst(curr.left);
            }
        }
        
        leftToRight = !leftToRight;
        System.out.println(); 
    }
}

//Two Stack Approach (two stack)
public static void spiralTraversal(Node root) {
    if (root == null) return;
    
    Stack<Node> s1 = new Stack<>(); 
    Stack<Node> s2 = new Stack<>(); 
    
    s1.push(root);
    
    while (!s1.isEmpty() || !s2.isEmpty()) {
        // Process left to right level
        while (!s1.isEmpty()) {
            Node curr = s1.pop();
            System.out.print(curr.data + " ");
            
            if (curr.left != null) s2.push(curr.left);
            if (curr.right != null) s2.push(curr.right);
        }
        
        System.out.println(); 
        
        // Process right to left level
        while (!s2.isEmpty()) {
            Node curr = s2.pop();
            System.out.print(curr.data + " ");
            
            if (curr.right != null) s1.push(curr.right);
            if (curr.left != null) s1.push(curr.left);
        }
        
        System.out.println(); 
    }
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
