public class BinTree {
    // ~ Fields ................................................................
    private BintreeNode root;
    private final int maxX;
    private final int maxY;

    // ~ Constructors ..........................................................
    public BinTree(int maxX, int maxY) {
        this.root = new BinTreeEmptyNode();
        this.maxX = maxX;
        this.maxY = maxY;
    }


    // ~Public Methods ........................................................
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * 
     * @param x
     * @param y
     * @param seminar
     */
    public void insert(int x, int y, Seminar seminar) {
        root = root.insert(x, y, 0, 0, maxX, maxY, seminar, 0);
    }
    
    public void delete(int x, int y, int id) {
        root = root.delete(x, y, id, 0, 0, maxX, maxY, 0);
    }


    public BintreeNode getRoot() {
        return root;
    }


    public void print() {
        System.out.println("Location Tree:");
        if (root instanceof BinTreeEmptyNode) {
            System.out.println("E");
            return;
        }
        int maxDepth = this.getMaxDepth(root);
        root.print(0, maxDepth);
    }


    public int search(int x, int y, int radius) {
        int boundX = x - radius;
        int boundY = y - radius;
        int boundBoxHeight = 2 * radius + 1;
        int boundBoxWidth = 2 * radius + 1;
        System.out.println("Seminars within " + radius + " units of "
            + x + ", " + y + ":");
        return root.search(boundX, boundY, 0, 0, maxX, maxY, boundBoxHeight,
            boundBoxWidth, 0);
    }


    private int getMaxDepth(BintreeNode node) {
        if (node instanceof BintreeInternalNode) {
            BintreeInternalNode internalNode = (BintreeInternalNode)node;
            return 1 + Math.max(getMaxDepth(internalNode.left), getMaxDepth(
                internalNode.right));
        }
        return 0;
    }
}
