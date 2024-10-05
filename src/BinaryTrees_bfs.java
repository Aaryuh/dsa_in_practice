import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class BreadthFirst{

    static List finalValues= new ArrayList<>();
    public static List<String> breadthFirstValues(Node<String> root) {
        // todo
       ArrayList<Node<String>> nodeQueue= new ArrayList<>();
       nodeQueue.add(root);

       while(!nodeQueue.isEmpty()){
           Node<String> current= nodeQueue.removeFirst();
           finalValues.add(current.val);
           if(current.left!= null){
               nodeQueue.add(current.left);
           }
           if(current.right!=null){
               nodeQueue.add(current.right);
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

        System.out.println(Arrays.toString(breadthFirstValues(a).toArray()));

    }



}
