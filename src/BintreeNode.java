// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here.
 * Follow it with additional details about its purpose, what abstraction
 * it represents, and how to use it.
 * 
 * @author kyung
 * @version Oct 13, 2024
 */
public interface BintreeNode {
    
    public BintreeNode insert(
        int x,
        int y,
        int minx,
        int miny,
        int maxx,
        int maxy,
        Seminar seminar,
        int depth);


    public BintreeNode delete(
        int x,
        int y,
        int id,
        int minx,
        int miny,
        int maxx,
        int maxy, int depth);


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


    public void print(int currentLevel, int maxDepth);
}
