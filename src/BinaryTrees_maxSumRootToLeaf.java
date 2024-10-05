public class BinaryTrees_maxSumRootToLeaf {
    public static Double maxPathSum(Node<Double> root) {
        // todo
        if(root==null) return (double) Integer.MIN_VALUE; //an asymmetric node
        if(root.left==null && root.right==null) return root.val; //leaf node

        double leftMax= maxPathSum(root.left);
        double rightMax= maxPathSum(root.right);

        double maxChild= Math.max(leftMax,rightMax);
        return root.val+maxChild;
    }

    public static void main(String[] args) {
        Node<Double> a = new Node<>(3.);
        Node<Double> b = new Node<>(11.);
        Node<Double> c = new Node<>(4.);
        Node<Double> d = new Node<>(4.);
        Node<Double> e = new Node<>(-2.);
        Node<Double> f = new Node<>(1.);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        //       3
        //    /    \
        //   11     4
        //  / \      \
        // 4   -2     1
        System.out.println(maxPathSum(a));

    }
}
