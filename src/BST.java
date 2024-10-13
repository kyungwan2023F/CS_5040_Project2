import java.util.ArrayList;

public class BST<K extends Comparable<K>, E> {
    // ~ Fields ................................................................
    public BST.BSTNode<K, E> root;
    private int nodecount;

    static class BSTNode<K extends Comparable<K>, E> {
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
    public int size() {
        return nodecount;
    }


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

        if (max.compareTo(root.value().key()) > 0) {
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
    
    private BSTNode<K, E> getMax(BSTNode<K, E> root){
        if (root.right == null) {
            return root;
        }
        return getMax(root.right);
    }
    
    private BSTNode<K, E> deleteMax(BSTNode<K, E> root){
        if (root.right == null) {
            return root.left;
        }
        root.right = deleteMax(root.right);
        return root;
    }
    
    private BSTNode<K, E> removeHelp(BSTNode<K, E> root, KVPair<K, E> key){
        if (root == null) {
            return null;
        }
        int comparison = root.value().compareTo(key);
        if (comparison > 0) {
            root.left = removeHelp(root.left, key);
        }
        else if (comparison < 0) {
            root.right = removeHelp(root.right, key);
        }
        else if (comparison == 0 && root.data.value().equals(key.value())) {
            nodecount--;
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }
            else {
                BSTNode<K, E> temp = getMax(root.left);
                root.data = temp.data;
                root.left = deleteMax(root.left);
            }
        }
        return root;
    }
    
    public BSTNode<K, E> remove(KVPair<K, E> key){
        return removeHelp(root, key);
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


    private int getHeight(BSTNode<K, E> node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }


    public int getHeight() {
        return getHeight(root);
    }


    private void printTreeHelper(BSTNode<K, E> node, int height, int level) {
        if (node == null) {
            int indentSpaces = (height - level) * 4;
            String indent = " ".repeat(indentSpaces);
            System.out.println(indent + "(null)");
            return;
        }

        printTreeHelper(node.left, height, level + 1);

        int indentSpaces = (height - level) * 4;
        String indent = " ".repeat(indentSpaces);

        System.out.println(indent + "\\");
        System.out.println(indent + "(" + node.value().key()
            + ")");
        System.out.println(indent + "/");

        printTreeHelper(node.right, height, level + 1);
    }



    public void printTree() {
        if (root == null) {
            System.out.println("This tree is empty");
        }
        else {
            int height = getHeight(root);  
            printTreeHelper(root, height, 0); 
            System.out.println("Number of records: " + this.size());
        }
    }
}
