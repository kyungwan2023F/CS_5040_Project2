/**
 * The BintreeNode interface defines the core operations that can be performed
 * on nodes within a binary tree structure. This includes the insertion,
 * deletion, search, and printing of nodes, where each node stores seminar data.
 * 
 * @author Kyungwan Do, Jaeyoung Shin
 * @version 10/18/2024
 */
public interface BintreeNode
{
    // ----------------------------------------------------------
    /**
     * Insert seminar.
     * 
     * @param x
     *            int
     * @param y
     *            int
     * @param minx
     *            int
     * @param miny
     *            int
     * @param maxx
     *            int
     * @param maxy
     *            int
     * @param seminar
     *            seminar
     * @param depth
     *            int
     * @return updated node
     */
    public BintreeNode insert(
        int x,
        int y,
        int minx,
        int miny,
        int maxx,
        int maxy,
        Seminar seminar,
        int depth);


    // ----------------------------------------------------------
    /**
     * Delete seminar.
     * 
     * @param x
     *            int
     * @param y
     *            int
     * @param id
     *            int
     * @param minx
     *            int
     * @param miny
     *            int
     * @param maxx
     *            int
     * @param maxy
     *            int
     * @param depth
     *            int
     * @return updated node
     */
    public BintreeNode delete(
        int x,
        int y,
        int id,
        int minx,
        int miny,
        int maxx,
        int maxy,
        int depth);


    // ----------------------------------------------------------
    /**
     * Search seminar.
     * 
     * @param boundX
     *            int
     * @param boundY
     *            int
     * @param x
     *            int
     * @param y
     *            int
     * @param height
     *            int
     * @param width
     *            int
     * @param boundHeight
     *            int
     * @param boundWidth
     *            int
     * @param depth
     *            int
     * @return searched node
     */
    public int search(
        int boundX,
        int boundY,
        int x,
        int y,
        int height,
        int width,
        int boundHeight,
        int boundWidth,
        int depth);


    // ----------------------------------------------------------
    /**
     * Print seminar.
     * 
     * @param currentLevel
     *            int
     * @param maxDepth
     *            int
     */
    public void print(int currentLevel, int maxDepth);
}
