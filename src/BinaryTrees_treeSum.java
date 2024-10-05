import java.lang.reflect.Array;
import java.util.ArrayList;

public class BinaryTrees_treeSum {
    public static int treeSumRecursive(Node<Integer> root) {
        // todo
        if(root==null) return 0;
        return root.val+ treeSumRecursive(root.left)+treeSumRecursive(root.right);

    }

    public static int  treeSumBFS(Node<Integer> root){
        if(root==null) return 0;

        ArrayList<Node<Integer>> nodeQueue = new ArrayList<>();
        nodeQueue.add(root);

        int totalSum=0;

        while(!nodeQueue.isEmpty()){
            Node<Integer> curr= nodeQueue.removeFirst();

            totalSum+= curr.val;;

            if(curr.left!=null) nodeQueue.add(curr.left);
            if(curr.right!=null) nodeQueue.add(curr.right);

        }

        return totalSum;
    }

    public static void main(String[] args) {

        Node<Integer> a = new Node<>(3);
        Node<Integer> b = new Node<>(11);
        Node<Integer> c = new Node<>(4);
        Node<Integer> d = new Node<>(4);
        Node<Integer> e = new Node<>(-2);
        Node<Integer> f = new Node<>(1);

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

        System.out.println(treeSumRecursive(a));
        System.out.println(treeSumBFS(a));

    }


}
