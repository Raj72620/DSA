package BinaryTrees;
import java.util.*;


//Print all the nodes at a distance of K in binary tree

public class distanceOfK {
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
    public static void parentMap(Node root , Map<Node,Node> map){
        if(root ==null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            Node curr = q.remove();

            if(curr.left!=null){
                q.add(curr.left);
                map.put(curr.left, curr);
            }
            if(curr.right!=null){
                q.add(curr.right);
                map.put(curr.right, curr);
            }
        }
    }
 public static List<Integer> distance(Node root, Node target, int k ){

    Map<Node,Node> mapofParents = new HashMap<>();
    parentMap(root, mapofParents);

    Set<Node> visited = new HashSet<>();
    Queue<Node> q = new LinkedList<>();

    q.add(target);
    visited.add(target);

    int currLevel = 0;

    while(!q.isEmpty()){

        if(currLevel == k){
            break;
        }

        int levelSize = q.size();

        for(int i = 0; i < levelSize; i++){

            Node curr = q.remove();

            if(curr.left != null && !visited.contains(curr.left)){
                q.add(curr.left);
                visited.add(curr.left);
            }

            if(curr.right != null && !visited.contains(curr.right)){
                q.add(curr.right);
                visited.add(curr.right);
            }

            Node parent = mapofParents.get(curr);

            if(parent != null && !visited.contains(parent)){
                q.add(parent);
                visited.add(parent);
            }
        }

        currLevel++;
    }

    List<Integer> ans = new ArrayList<>();

    while(!q.isEmpty()){
        ans.add(q.remove().data);
    }

    return ans;
}

    public static void print(List<Integer> ans){

        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+ " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
               Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left=new Node(4);
        root.left.left.right=new Node(7);
        root.right.left = new Node(5);
        root.right.right = new Node(6);

        List<Integer> ans = distance(root, root.left, 2);
        print(ans);
    }
}
