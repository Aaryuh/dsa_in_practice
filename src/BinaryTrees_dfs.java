import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Node<T> {
    T val;
    Node<T> left;
    Node<T> right;

    public Node(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class DepthFirst{
    static List finalValues= new ArrayList<>();
    public static List<String> depthFirstValuesRecursive(Node<String> root) {
        // todo
        if(root==null) return null ;
        finalValues.add(root.val);

        depthFirstValuesRecursive(root.left);
        depthFirstValuesRecursive(root.right);

        return finalValues;
    }

    static Stack<Node<String>> nodeStack= new Stack<>();
    public static List<String> depthFirstValuesIterative(Node<String> root){
        nodeStack.push(root);
        while (!nodeStack.empty()){
            Node<String> current= nodeStack.pop();
            finalValues.add(current.val);
            if(current.right!= null){
                nodeStack.push(current.right);
            }
            if(current.left!=null){
                nodeStack.push(current.left);
            }
        }
        return finalValues;
    }

    public static void main(String[]args) {

        //      a
        //    /   \
        //   b     c
        //  / \     \
        // d   e     f


        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        Node<String> d = new Node<>("d");
        Node<String> e = new Node<>("e");
        Node<String> f = new Node<>("f");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        System.out.println("Recursive version: ");
        System.out.print(Arrays.toString(depthFirstValuesRecursive(a).toArray()));
//        System.out.println("Iterative version: ");
//        System.out.print(Arrays.toString(depthFirstValuesIterative(a).toArray()));

    }
}




