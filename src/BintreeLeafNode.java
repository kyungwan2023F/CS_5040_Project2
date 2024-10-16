/**
 * The BintreeLeafNode class represents a leaf node in a binary tree that stores
 * a list of seminars and handles insertion, deletion, search, and printing of
 * seminar data for nodes with the same coordinates.
 * 
 * @author Kyungwan Do, Jaeyoung Shin
 * @version 10/18/2024
 */
public class BintreeLeafNode
    implements BintreeNode
{
    private SingleLL list;

    // ----------------------------------------------------------
    /**
     * Create a new BintreeLeafNode object.
     * 
     * @param seminar
     *            seminar
     */
    public BintreeLeafNode(Seminar seminar)
    {
        list = new SingleLL();
        list.add(seminar);
    }


    @Override
    public BintreeNode insert(
        int x,
        int y,
        int minx,
        int miny,
        int maxx,
        int maxy,
        Seminar seminar,
        int depth)
    {
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).x() == x && list.get(i).y() == y)
            {
                list.add(seminar);
                return this;
            }
        }
        BintreeInternalNode newInternalNode = new BintreeInternalNode();
        for (int i = 0; i < list.size(); i++)
        {
            newInternalNode.insert(
                list.get(i).x(),
                list.get(i).y(),
                minx,
                miny,
                maxx,
                maxy,
                list.get(i),
                depth);
        }
        newInternalNode.insert(x, y, minx, miny, maxx, maxy, seminar, depth);
        return newInternalNode;
    }


    @Override
    public BintreeNode delete(
        int x,
        int y,
        int id,
        int minx,
        int miny,
        int maxx,
        int maxy,
        int depth)
    {
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).id() == id)
            {
                list.remove(i);
                break;
            }
        }
        if (list.size() == 0)
        {
            return new BinTreeEmptyNode();
        }
        return this;
    }


    @Override
    public int search(
        int boundX,
        int boundY,
        int x,
        int y,
        int height,
        int width,
        int boundHeight,
        int boundWidth,
        int depth)
    {
        int nodesVisited = 1;
        int radius = (boundWidth - 1) / 2;
        int radiusSquared = radius * radius;
        int realX = boundX + radius;
        int realY = boundY + radius;
        int dx = realX - this.list.get(0).x();
        int dy = realY - this.list.get(0).y();
        int distanceSquared = (dx * dx) + (dy * dy);

        if (distanceSquared <= radiusSquared)
        {
            for (int i = 0; i < this.list.size(); i++)
            {
                int id = this.list.get(i).id();
                int leafX = this.list.get(0).x();
                int leafY = this.list.get(0).y();
                System.out.println(
                    "Found a record with key value " + id + " at " + leafX
                        + ", " + leafY);
            }
        }
        return nodesVisited;

    }


    @Override
    public void print(int currentLevel, int maxDepth)
    {
        int indentSpaces = (maxDepth - currentLevel) * 4;
        String indent = " ".repeat(indentSpaces);

        System.out.print(indent + "(Leaf with " + list.size() + " objects: ");
        for (int i = 0; i < list.size(); i++)
        {
            System.out.print(list.get(i).id());
            if (i < list.size() - 1)
            {
                System.out.print(" ");
            }
        }
        System.out.println(")");
    }

}
