import java.util.Objects;

class TreeIncludes{
    public static boolean treeIncludesRecursive(Node<String> root, String target) {
        // todo
        if(root==null) return false;
        if(Objects.equals(root.val, target)) return true;

        return treeIncludesRecursive(root.left, target) || treeIncludesRecursive(root.right, target);
    }

    public static void main(String[] args) {
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

        //      a
        //    /   \
        //   b     c
        //  / \     \
        // d   e     f

        System.out.println(TreeIncludes.treeIncludesRecursive(a, "e"));

    }
}
