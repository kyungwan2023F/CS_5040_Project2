public class BintreeInternalNode implements BintreeNode {
    BintreeNode left;
    BintreeNode right;

    public BintreeInternalNode() {
        this.left = new BinTreeEmptyNode();
        this.right = new BinTreeEmptyNode();
    }


    @Override
    public boolean isLeaf() {
        return false;
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
        int depth) {
        int midX = (minx + maxx) / 2;
        int midY = (miny + maxy) / 2;

        if (depth % 2 == 0) {
            if (seminar.x() < midX) {
                left = left.insert(x, y, minx, miny, midX, maxy, seminar, depth
                    + 1);
            }
            else {
                right = right.insert(x, y, midX, miny, maxx, maxy, seminar,
                    depth + 1);
            }
        }
        else {
            if (seminar.y() < midY) {
                left = left.insert(x, y, minx, miny, maxx, midY, seminar, depth
                    + 1);
            }
            else {
                right = right.insert(x, y, minx, midY, maxx, maxy, seminar,
                    depth + 1);
            }
        }
        return this;
    }


    @Override
    public void delete(Seminar seminar) {
        // TODO Auto-generated method stub

    }

// @Override
// public int search(
// int boundX,
// int boundY,
// int minx,
// int miny,
// int maxx,
// int maxy,
// int boundHeight,
// int boundWidth) {
//// (box1TopLeftX <= box2BottomRightX && box1BottomRightX >= box2TopLeftX) &&
//// (box1TopLeftY <= box2BottomRightY && box1BottomRightY >= box2TopLeftY)
// int midX = (minx + maxx) / 2;
// int midY = (miny + maxy) / 2;
// if (depth % 2 == 0) {
// if (left instanceof BintreeInternalNode) {
// int x = minx;
// int y = miny;
// int width = midX - x;
// int height = midY / 2;
// int internalNodeTopLeftX = x;
// int internalNodeBottomRightX = x + width;
// int internalNodeTopLeftY = y + height;
// int internalNodeBottomRightY = y;
// if ((internalNodeTopLeftX <= box2BottomRightX
// && internalNodeBottomRightX >= box2TopLeftX)
// && (internalNodeTopLeftY <= box2BottomRightY
// && internalNodeBottomRightY >= box2TopLeftY)) {
//
// }
// left = left.search(boundX, boundY, minX, minY, midX, maxY,
// boundHeight, boundWidth);
// }
// else {
// right = right.insert(x, y, midX, miny, maxx, maxy, seminar,
// depth + 1);
// }
// }
// else {
// if (seminar.y() < midY) {
// left = left.insert(x, y, minx, miny, maxx, midY, seminar, depth
// + 1);
// }
// else {
// right = right.insert(x, y, minx, midY, maxx, maxy, seminar,
// depth + 1);
// }
// }
//
// }


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
        int depth) {

        int nodesVisited = 1;

        int midY = (y + height) / 2;
        int midX = (x + width) / 2;

        int boundTopLeftX = boundX;
        int boundBottomRightX = boundX + boundWidth;
        int boundTopLeftY = boundY;
        int boundBottomRightY = boundY + boundHeight;
        // Handle even depth (x-axis split)
        if (depth % 2 == 0) {
            // LeftSubtree
            int topLeftX = x;
            int bottomRightX = midX;
            int topLeftY = y;
            int bottomRightY = y + height;
            if ((topLeftX <= boundBottomRightX && bottomRightX >= boundTopLeftX)
                && (topLeftY <= boundBottomRightY
                    && bottomRightY >= boundTopLeftY)) {
                nodesVisited += left.search(boundX, boundY, x, y, height, width
                    / 2, boundHeight, boundWidth, depth + 1);
            }
            // RightSubTree
            topLeftX = midX;
            bottomRightX = x + width;
            if ((topLeftX <= boundBottomRightX && bottomRightX >= boundTopLeftX)
                && (topLeftY <= boundBottomRightY
                    && bottomRightY >= boundTopLeftY)) {
                nodesVisited += right.search(boundX, boundY, midX, y, height,
                    width / 2, boundHeight, boundWidth, depth + 1);
            }
        }
        // Handle odd depth (y-axis split)
        else {
            // LeftSubtree
            int topLeftX = x;
            int bottomRightX = x + width;
            int topLeftY = y;
            int bottomRightY = midY;
            if ((topLeftX <= boundBottomRightX && bottomRightX >= boundTopLeftX)
                && (topLeftY <= boundBottomRightY
                    && bottomRightY >= boundTopLeftY)) {
                nodesVisited += left.search(boundX, boundY, x, y, height / 2,
                    width, boundHeight, boundWidth, depth + 1);
            }

            // Check right node
            topLeftY = midY;
            bottomRightY = y + height;

            if ((topLeftX <= boundBottomRightX && bottomRightX >= boundTopLeftX)
                && (topLeftY <= boundBottomRightY
                    && bottomRightY >= boundTopLeftY)) {
                nodesVisited += right.search(boundX, boundY, x, midY, height
                    / 2, width, boundHeight, boundWidth, depth + 1);
            }
        }
        return nodesVisited;
    }


    @Override
    public void print(int currentLevel, int maxDepth) {
        int indentSpaces = (maxDepth - currentLevel) * 4;
        String indent = " ".repeat(indentSpaces);

        System.out.println(indent + "(I)");

        right.print(currentLevel + 1, maxDepth);
        left.print(currentLevel + 1, maxDepth);
    }

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................

}
