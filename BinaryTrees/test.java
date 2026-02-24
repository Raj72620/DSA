package BinaryTrees;

public class test{

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

static class Findingpath {
    int globalMax = Integer.MIN_VALUE;
    
    public  int maxPathSum(Node root) {
        findMaxPath(root);
        return globalMax;
    }
    
    public int findMaxPath(Node root) {
        if (root == null) return 0;
        
        int leftMax = Math.max(0, findMaxPath(root.left));
        int rightMax = Math.max(0, findMaxPath(root.right));
        
        // Update global max with path through current root
        globalMax = Math.max(globalMax, root.data + leftMax + rightMax);
        
        // Return max path that can be extended to parent
        return root.data + Math.max(leftMax, rightMax);
    }
}

   
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left=new Node(2);
        root.right= new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.right=new Node(6);

        Findingpath ans = new Findingpath();
       System.out.println(ans.maxPathSum(root));
    }
}
