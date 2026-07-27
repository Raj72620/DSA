package BinaryTrees.hard;

import java.util.*;

public class serializeAndDeserialize {

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

    //serealize by using DFS 
    public static String serialize(Node root) {
        StringBuilder ans = new StringBuilder();
        dfs(root, ans);
        return ans.toString();
    }

    public static void dfs(Node root, StringBuilder ans) {

        if (root == null) {
            ans.append("#,");
            return;
        }

        ans.append(root.data).append(",");

        dfs(root.left, ans);
        dfs(root.right, ans);
    }

// Deserealize DFS
    static int index;

    public static Node deserialize(String data) {

        String[] arr = data.split(",");

        index = 0;

        return buildTree(arr);
    }

    public static Node buildTree(String[] arr) {

        if (arr[index].equals("#")) {
            index++;
            return null;
        }

        Node root = new Node(Integer.parseInt(arr[index]));
        index++;

        root.left = buildTree(arr);

        root.right = buildTree(arr);

        return root;
    }



    
    //Solving this using BFS 
    public static String serealizeBFS(Node root){
        if(root==null) return " ";
        Queue<Node> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            Node curr=q.remove();
            if(curr==null){
                res.append("#");
                continue;
            }
            res.append(curr.data).append(",");
            q.add(curr.left);
            q.add(curr.right);
        }
        return res.toString();
    }
    public static Node deserealizeBFS(String str){
        if(str.isEmpty()) return null;
        Queue<Node> q = new LinkedList<>();
        String[] values = str.split(",");

        Node root = new Node(Integer.parseInt(values[0]));
        q.add(root);
        for(int i=1;i<values.length;i++){
            Node parent = q.remove();
            if(!values[i].equals("#")){
                Node left = new Node(Integer.parseInt(values[i]));
                parent.left=left;
                q.add(left);
            }
            i++;
            if(i<values.length && !values[i].equals("#")){
                Node right=new Node(Integer.parseInt(values[i]));
                parent.right=right;
                q.add(right);
            }
        }
        return root;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

    }
}
