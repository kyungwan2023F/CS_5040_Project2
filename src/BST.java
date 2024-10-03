import java.util.ArrayList;

public class BST<K extends Comparable<K>, E> {
    // ~ Fields ................................................................
    private BST.BSTNode<K, E> root;
    private int nodecount;

    private static class BSTNode<K extends Comparable<K>, E> {
        KVPair<K, E> data;
        BSTNode<K, E> left, right;

        BSTNode(KVPair<K, E> data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }


        public BSTNode<K, E> left() {
            return left;
        }


        public BSTNode<K, E> right() {
            return right;
        }


        public KVPair<K, E> value() {
            return this.data;
        }
    }

    // ~ Constructors ..........................................................
    public BST() {
        this.root = null;
        this.nodecount = 0;
    }


    // ~Public Methods ........................................................
    private KVPair<K, E> findHelp(BSTNode<K, E> root, K key) {
        if (root == null) {
            return null;
        }

        int comparison = key.compareTo(root.value().key());

        if (comparison > 0) {
            return findHelp(root.right, key);
        }
        else if (comparison == 0) {
            return root.value();
        }
        else {
            return findHelp(root.left, key);
        }
    }


    private int findRangeHelp(BSTNode<K, E> root, K min, K max) {
        if (root == null) {
            return 1;
        }

        int nodesVisited = 1;

        if (min.compareTo(root.value().key()) <= 0) {
            nodesVisited += findRangeHelp(root.left, min, max);
        }

        if (min.compareTo(root.value().key()) <= 0 && max.compareTo(root.value()
            .key()) >= 0) {
            System.out.println(root.value().value().toString());
        }

        if (max.compareTo(root.value().key()) >= 0) {
            nodesVisited += findRangeHelp(root.right, min, max);
        }
        return nodesVisited;
    }


    private BSTNode<K, E> insertHelp(
        BSTNode<K, E> root,
        KVPair<K, E> insertPair) {
        if (root == null) {
            return new BSTNode<>(insertPair);
        }

        int comparison = insertPair.compareTo(root.value());

        if (comparison <= 0) {
            root.left = insertHelp(root.left, insertPair);
        }
        else {
            root.right = insertHelp(root.right, insertPair);
        }
        return root;
    }


    public void insert(KVPair<K, E> pair) {
        root = insertHelp(root, pair);
        nodecount++;
    }


    public KVPair<K, E> find(K key) {
        return findHelp(root, key);
    }


    public int findRange(K min, K max) {
        return findRangeHelp(root, min, max);
    }


    private void printTreeHelper(
        BSTNode<K, E> node,
        String indent,
        boolean isRight) {
        if (node != null) {
            printTreeHelper(node.left, indent + "   ", false); // Print left
                                                               // subtree first
            System.out.println(indent + node.value().key()); // Print current
                                                             // node
            printTreeHelper(node.right, indent + "   ", true); // Print right
                                                               // subtree last
        }
    }


    // Public method to print the tree
    public void printTree() {
        if (root == null) {
            System.out.println("This tree is empty");
        }
        else {
            printTreeHelper(root, "", true);
        }
    }
}
