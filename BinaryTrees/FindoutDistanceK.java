package BinaryTrees;

import java.util.*;


public class FindoutDistanceK{

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

    public static List<Integer> distanceK(Node root, Node target, int k) {
        // Step 1: Create parent pointers using BFS
        Map<Node, Node> parentMap = new HashMap<>();
        markParents(root, parentMap);
        
        // Step 2: BFS from target to find nodes at distance k
        Map<Node, Boolean> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        
        q.offer(target);
        visited.put(target, true);
        
        int currLevel = 0;
        
        while (!q.isEmpty()) {
            // If we've reached level k, stop BFS
            if (currLevel == k) {
                break;
            }
            
            int levelSize = q.size();
            
            // Process all nodes at current level
            for (int i = 0; i < levelSize; i++) {
                Node current = q.poll();
                
                // Check left child
                if (current.left != null && visited.get(current.left) == null) {
                    q.offer(current.left);
                    visited.put(current.left, true);
                }
                
                // Check right child
                if (current.right != null && visited.get(current.right) == null) {
                    q.offer(current.right);
                    visited.put(current.right, true);
                }
                
                // Check parent
                Node parent = parentMap.get(current);
                if (parent != null && visited.get(parent) == null) {
                    q.offer(parent);
                    visited.put(parent, true);
                }
            }
            
            currLevel++;
        }
        
        // Collect all nodes remaining in q (these are at distance k)
        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            result.add(q.poll().data);
        }
        
        return result;
    }
    
    // BFS to mark parent pointers
    private static void markParents(Node root, Map<Node, Node> parentMap) {
        if (root == null) return;
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            Node current = q.poll();
            
            if (current.left != null) {
                parentMap.put(current.left, current);
                q.offer(current.left);
            }
            
            if (current.right != null) {
                parentMap.put(current.right, current);
                q.offer(current.right);
            }
        }
    }
    
    // Helper method to print result
    public static void printResult(List<Integer> result) {
        System.out.print("Nodes at distance K: [");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i < result.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
   
    public static void main(String[] args) {

           Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        
                
        List<Integer> result = distanceK(root, root.left, 1);
        printResult(result); 
    
    }
}
