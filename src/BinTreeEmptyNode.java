public class BinTreeEmptyNode implements BintreeNode {
    private static final BinTreeEmptyNode instance = new BinTreeEmptyNode();
    
    public BinTreeEmptyNode() {      
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
        int depth) {
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
        int boundWidth, int depth) {
        return 1;
    }


    @Override
    public void print(int currentLevel, int maxDepth) {
        int indentSpaces = (maxDepth - currentLevel) * 4;
        String indent = " ".repeat(indentSpaces);
        System.out.println(indent + "(E)");
    }
    //~ Fields ................................................................

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
        return new BintreeLeafNode(seminar); 
    }

    //~ Constructors ..........................................................

    //~Public  Methods ........................................................

}
