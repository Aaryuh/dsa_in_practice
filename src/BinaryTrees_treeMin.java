import java.util.Stack;

public class BinaryTrees_treeMin {
    public static Double treeMinValue(Node<Double> root) {

        // todo
        if(root== null) return (double) Integer.MAX_VALUE;

        double leftMin= treeMinValue(root.left);
        double rightMin= treeMinValue(root.right);

        double minChild = Math.min(leftMin,rightMin);
        double finalMin = Math.min(minChild, root.val);

        return finalMin;

    }

    public static Double treeMin_dfs(Node<Double> root){

        if(root==null) return (double) Integer.MAX_VALUE;

        Stack<Node<Double>> nodeStack= new Stack<>();
        nodeStack.push(root);

        Double min=(double) Integer.MAX_VALUE;

        while(!nodeStack.empty()){

            Node<Double> curr= nodeStack.pop();
            if(curr.val< min){
                min= curr.val;
            }
            if(curr.right!=null) nodeStack.push(curr.right);
            if(curr.left!=null) nodeStack.push(curr.left);

        }

        return min;
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


        System.out.println(treeMinValue(a));
        System.out.println(treeMin_dfs(a));

    }


}
