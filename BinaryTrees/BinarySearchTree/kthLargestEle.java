package BinaryTrees.BinarySearchTree;

public class kthLargestEle {
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
      static int cnt=0;
    public static int findKthLargest(Node root,int k){
        if(root==null){
            return -1;
        }
          int right= findKthLargest(root.right, k);
       if(right!=-1){
            return right;
        }
        cnt++;
        if(cnt==k) return root.data;

        return findKthLargest(root.left, k);
    }
    
    static int count=0;
    public static int findKthSmallest(Node root,int k){
        if(root==null){
            return -1;
        }
      int left=  findKthSmallest(root.left, k);
        if(left!=-1){
            return left;
        }
        count++;
        if(count==k) return root.data;

        return findKthSmallest(root.right, k);
    }
    public static void main(String[] args) {
                         Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(60);
        root.left.left=new Node(5);
        root.left.right=new Node(20);

        root.right.left=new Node(55);
        root.right.right=new Node(70);

        int ans=kthLargestEle.findKthSmallest(root, 3);
        System.out.println(ans);

    }
}
