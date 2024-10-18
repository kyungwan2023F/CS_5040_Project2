/**
 * The BintreeInternalNode class represents an internal node in a binary tree,
 * managing spatial data insertion, deletion, searching, and printing for
 * subdividing space between left and right child nodes.
 * 
 * @author Kyungwan Do, Jaeyoung Shin
 * @version 10/18/2024
 */
public class BintreeInternalNode
    implements BintreeNode
{
    /**
     * left node
     */
    BintreeNode left;
    /**
     * right node
     */
    BintreeNode right;

    // ----------------------------------------------------------
    /**
     * Create a new BintreeInternalNode object.
     */
    public BintreeInternalNode()
    {
        this.left = new BinTreeEmptyNode();
        this.right = new BinTreeEmptyNode();
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
        int midX = (minx + maxx) / 2;
        int midY = (miny + maxy) / 2;

        if (depth % 2 == 0)
        {
            if (seminar.x() < midX)
            {
                left = left
                    .insert(x, y, minx, miny, midX, maxy, seminar, depth + 1);
            }
            else
            {
                right = right
                    .insert(x, y, midX, miny, maxx, maxy, seminar, depth + 1);
            }
        }
        else
        {
            if (seminar.y() < midY)
            {
                left = left
                    .insert(x, y, minx, miny, maxx, midY, seminar, depth + 1);
            }
            else
            {
                right = right
                    .insert(x, y, minx, midY, maxx, maxy, seminar, depth + 1);
            }
        }
        return this;
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
        int midX = (minx + maxx) / 2;
        int midY = (miny + maxy) / 2;

        if (depth % 2 == 0)
        {
            if (x < midX)
            {
                left = left.delete(x, y, id, minx, miny, midX, maxy, depth + 1);
            }
            else
            {
                right =
                    right.delete(x, y, id, midX, miny, maxx, maxy, depth + 1);
            }
        }
        else
        {
            if (y < midY)
            {
                left = left.delete(x, y, id, minx, miny, maxx, midY, depth + 1);
            }
            else
            {
                right =
                    right.delete(x, y, id, minx, midY, maxx, maxy, depth + 1);
            }
        }

        if (left instanceof BinTreeEmptyNode
            && right instanceof BintreeLeafNode)
        {
            return right; // Merge up
        }
        else if (right instanceof BinTreeEmptyNode
            && left instanceof BintreeLeafNode)
        {
            return left; // Merge up
        }
        // If both children empty, return empty node
        else if (left instanceof BinTreeEmptyNode
            && right instanceof BinTreeEmptyNode)
        {
            return new BinTreeEmptyNode();
        }
        return this; // Return internal node if no merge happened
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

        int midY = y + (height / 2);
        int midX = x + (width / 2);

        int boundTopLeftX = boundX;
        int boundBottomRightX = boundX + boundWidth;
        int boundTopLeftY = boundY;
        int boundBottomRightY = boundY + boundHeight;
        // Handle even depth (x-axis split)
        if (depth % 2 == 0)
        {
            // LeftSubtree
            int topLeftX = x;
            int bottomRightX = midX;
            int topLeftY = y;
            int bottomRightY = y + height;
            if ((topLeftX < boundBottomRightX && bottomRightX > boundTopLeftX)
                && (topLeftY < boundBottomRightY
                    && bottomRightY > boundTopLeftY))
            {
                nodesVisited += left.search(
                    boundX,
                    boundY,
                    x,
                    y,
                    height,
                    width / 2,
                    boundHeight,
                    boundWidth,
                    depth + 1);
            }
            // RightSubTree
            topLeftX = midX;
            bottomRightX = x + width;
            if ((topLeftX < boundBottomRightX && bottomRightX > boundTopLeftX)
                && (topLeftY < boundBottomRightY
                    && bottomRightY > boundTopLeftY))
            {
                nodesVisited += right.search(
                    boundX,
                    boundY,
                    midX,
                    y,
                    height,
                    width / 2,
                    boundHeight,
                    boundWidth,
                    depth + 1);
            }
        }
        // Handle odd depth (y-axis split)
        else
        {
            // LeftSubtree
            int topLeftX = x;
            int bottomRightX = x + width;
            int topLeftY = y;
            int bottomRightY = midY;
            if ((topLeftX < boundBottomRightX && bottomRightX > boundTopLeftX)
                && (topLeftY < boundBottomRightY
                    && bottomRightY > boundTopLeftY))
            {
                nodesVisited += left.search(
                    boundX,
                    boundY,
                    x,
                    y,
                    height / 2,
                    width,
                    boundHeight,
                    boundWidth,
                    depth + 1);
            }

            // Check right node
            topLeftY = midY;
            bottomRightY = y + height;

            if ((topLeftX < boundBottomRightX && bottomRightX > boundTopLeftX)
                && (topLeftY < boundBottomRightY
                    && bottomRightY > boundTopLeftY))
            {
                nodesVisited += right.search(
                    boundX,
                    boundY,
                    x,
                    midY,
                    height / 2,
                    width,
                    boundHeight,
                    boundWidth,
                    depth + 1);
            }
        }
        return nodesVisited;
    }


    @Override
    public void print(int currentLevel, int maxDepth)
    {
        int indentSpaces = (maxDepth - currentLevel) * 4;
        String indent = " ".repeat(indentSpaces);

        System.out.println(indent + "(I)");

        right.print(currentLevel + 1, maxDepth);
        left.print(currentLevel + 1, maxDepth);
    }
}
