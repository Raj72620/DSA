package BinaryTrees;

import java.util.*;


public class minTimeToBurn{

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

public static int minTimeToBurn(Node root, int target) {
    // STEP 1: Create parent pointers AND find target node
    Map<Node, Node> parentMap = new HashMap<>();
    Node targetNode = buildParentMap(root, parentMap, target);
    
    // If target not found in tree
    if (targetNode == null) return 0;
    
    // STEP 2: BFS from target in all 3 directions
    Queue<Node> q = new LinkedList<>();
    Set<Node> visited = new HashSet<>();
    
    q.add(targetNode);
    visited.add(targetNode);
    
    int time = 0;
    
    // STEP 3: BFS level by level until queue empty
    while (!q.isEmpty()) {
        int levelSize = q.size();
        boolean isBurned = false;
        
        for (int i = 0; i < levelSize; i++) {
            Node curr = q.poll();
            
            // Check left child
            if (curr.left != null && !visited.contains(curr.left)) {
                q.add(curr.left);
                visited.add(curr.left);
                isBurned = true;
            }
            
            // Check right child
            if (curr.right != null && !visited.contains(curr.right)) {
                q.add(curr.right);
                visited.add(curr.right);
                isBurned = true;
            }
            
            // Check parent
            Node parent = parentMap.get(curr);
            if (parent != null && !visited.contains(parent)) {
                q.add(parent);
                visited.add(parent);
                isBurned = true;
            }
        }
        
        // Increment time if new nodes burned this level
        if (isBurned) {
            time++;
        }
    }
    
    return time;
}

// Helper method to build parent map AND find target
private static Node buildParentMap(Node root, Map<Node, Node> parentMap, int target) {
    if (root == null) return null;
    
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    parentMap.put(root, null); // Root has no parent
    Node targetNode = null;
    
    while (!q.isEmpty()) {
        Node curr = q.poll();
        
        // Check if this is the target node
        if (curr.data == target) {
            targetNode = curr;
        }
        
        // Map left child
        if (curr.left != null) {
            parentMap.put(curr.left, curr);
            q.add(curr.left);
        }
        
        // Map right child
        if (curr.right != null) {
            parentMap.put(curr.right, curr);
            q.add(curr.right);
        }
    }
    
    return targetNode;
}
    public static void main(String[] args) {

           Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        
    System.out.println(minTimeToBurn(root,3));
    
    }
}
