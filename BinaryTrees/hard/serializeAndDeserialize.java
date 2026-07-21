package BinaryTrees.hard;

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

// Deserealize 
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

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

    }
}
