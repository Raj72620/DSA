package BinaryTrees;

public class TreeDiameter {

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

    public static int height(Node root) {

        if (root == null) {
            return 0;
        }

        int leftHg = height(root.left);
        int rightHg = height(root.right);

        return Math.max(leftHg, rightHg) + 1;
    }

    public static int TreeOptimizedDiameter(Node root) {   // T.C = o(n^2)

        if (root == null) {
            return 0;
        }

        int leftDia = TreeOptimizedDiameter(root.left);
        int rightDia = TreeOptimizedDiameter(root.right);

        int leftHg = height(root.left);
        int rightHg = height(root.right);

        int maxHg = (leftHg + rightHg) + 1;

        return Math.max(Math.max(leftDia, rightDia), maxHg);

    }

    //Optimized -> creating a custom class which stores my diameter value and height value (Bundle)
    //diameter is being calculated in NODES, not edges
    static class Info {

        int dia;
        int hg;

        public Info(int dia, int hg) {
            this.dia = dia;
            this.hg = hg;
        }
    }

    public static Info OptimizedDiameter(Node root) {

        if (root == null) {
            return new Info(0, 0);
        }

        Info leftDia = OptimizedDiameter(root.left);
        Info rightDia = OptimizedDiameter(root.right);

        int throughRoot = leftDia.hg + rightDia.hg + 1;

        int Totaldia = Math.max(
                Math.max(leftDia.dia, rightDia.dia),
                throughRoot
        );
        int height = Math.max(leftDia.hg, rightDia.hg)+1;

        return new Info(Totaldia, height);
    }

    //optimized easy solution without any custom class
    //diameter is being calculated in edges, not Nodes
    static class BT {

        static int maxi = Integer.MIN_VALUE;

        public static int optimizedDia(Node root) {
            if (root == null) {
                return 0;
            }

            int leftDia = optimizedDia(root.left);
            int rightDia = optimizedDia(root.right);

            maxi = Math.max(maxi, leftDia + rightDia);

            return Math.max(leftDia, rightDia) + 1;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(6);
        root.left.right.right = new Node(7);
        root.left.left.left.left = new Node(8);
        root.left.right.right.right = new Node(9);

        // System.out.println(OptimizedDiameter(root).dia);
        //  System.out.println(OptimizedDiameter(root).hg);
        // BT.optimizedDia(root);
        // System.out.println(BT.maxi);  // print the diameter
        System.out.println(TreeOptimizedDiameter(root));

    }
}
