
/**
 * The BinTree class represents a spatial binary tree that manages the
 * insertion, deletion, searching, and printing of seminar nodes. The tree uses
 * internal and leaf nodes to handle seminar data based on their spatial
 * coordinates, allowing efficient range searches within a bounded area.
 * 
 * @author Kyungwan Do, Jaeyoung Shin
 * @version 10/18/2024
 */
public class BinTree
{
    // ~ Fields ................................................................
    private BintreeNode root;
    private final int maxX;
    private final int maxY;

    // ----------------------------------------------------------
    /**
     * Create a new BinTree object.
     * 
     * @param maxX
     *            int
     * @param maxY
     *            int
     */
    public BinTree(int maxX, int maxY)
    {
        this.root = new BinTreeEmptyNode();
        this.maxX = maxX;
        this.maxY = maxY;
    }


    // ----------------------------------------------------------
    /**
     * Insert root.
     * 
     * @param x
     *            int
     * @param y
     *            int
     * @param seminar
     *            seminar
     */
    public void insert(int x, int y, Seminar seminar)
    {
        root = root.insert(x, y, 0, 0, maxX, maxY, seminar, 0);
    }


    // ----------------------------------------------------------
    /**
     * Delete root.
     * 
     * @param x
     *            int
     * @param y
     *            int
     * @param id
     *            int
     */
    public void delete(int x, int y, int id)
    {
        root = root.delete(x, y, id, 0, 0, maxX, maxY, 0);
    }


    // ----------------------------------------------------------
    /**
     * Get root.
     * 
     * @return root
     */
    public BintreeNode getRoot()
    {
        return root;
    }


    // ----------------------------------------------------------
    /**
     * Print location.
     */
    public void print()
    {
        System.out.println("Location Tree:");
        if (root instanceof BinTreeEmptyNode)
        {
            System.out.println("E");
            return;
        }
        int maxDepth = this.getMaxDepth(root);
        root.print(0, maxDepth);
    }


    // ----------------------------------------------------------
    /**
     * Search for seminar.
     * 
     * @param x
     *            int
     * @param y
     *            int
     * @param radius
     *            int
     * @return root
     */
    public int search(int x, int y, int radius)
    {
        int boundX = x - radius;
        int boundY = y - radius;
        int boundBoxHeight = 2 * radius + 1;
        int boundBoxWidth = 2 * radius + 1;
        System.out.println(
            "Seminars within " + radius + " units of " + x + ", " + y + ":");
        return root.search(
            boundX,
            boundY,
            0,
            0,
            maxX,
            maxY,
            boundBoxHeight,
            boundBoxWidth,
            0);
    }


    private int getMaxDepth(BintreeNode node)
    {
        if (node instanceof BintreeInternalNode)
        {
            BintreeInternalNode internalNode = (BintreeInternalNode)node;
            return 1 + Math.max(
                getMaxDepth(internalNode.left),
                getMaxDepth(internalNode.right));
        }
        return 0;
    }
}
