package BinaryTrees;

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
   public static class BT{

//Pre order tree traversal
        static int idx=-1;

    public static Node PreOrder(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left=PreOrder(nodes);
            newNode.right=PreOrder(nodes);
            return newNode;
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

    public static int height(Node root, int max ){
        if(root==null) return 1;

        int leftMax = height(root.left);
        int rightMax = height(root.right);

        max = Math.max(leftMax, rightMax);

        return max;
    }
    public static void main(String[] args) {
            int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
            BT tree = new BT();
          Node root = tree.PreOrder(nodes);

          height(root, 0);
            
    }
}
