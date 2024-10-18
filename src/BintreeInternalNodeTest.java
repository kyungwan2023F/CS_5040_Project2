import student.TestCase;

public class BintreeInternalNodeTest extends TestCase {
    // ~ Fields ................................................................
    private BintreeInternalNode internalNode;
    private Seminar seminar1, seminar2, seminar3, seminar4;

    // ~ Constructors ..........................................................
    public void setUp() {
        internalNode = new BintreeInternalNode();
        // Create sample seminars
        seminar1 = new Seminar(1, "Seminar 1", "2024-10-20", 60, (short)5,
            (short)5, 100, new String[] { "tech" }, "First Seminar");
        seminar2 = new Seminar(2, "Seminar 2", "2024-11-20", 60, (short)3,
            (short)3, 200, new String[] { "science" }, "Second Seminar");
        seminar3 = new Seminar(3, "Seminar 3", "2024-12-20", 60, (short)8,
            (short)8, 300, new String[] { "math" }, "Third Seminar");
        seminar4 = new Seminar(4, "Seminar 4", "2024-12-25", 60, (short)6,
            (short)7, 400, new String[] { "math" }, "Fourth Seminar");
    }


    // ~Public Methods ........................................................
    public void testInsertIntoEmptyTree() {
        BintreeNode result = internalNode.insert(5, 5, 0, 0, 10, 10, seminar1,
            0);
        assertNotNull(result);
        assertTrue(result instanceof BintreeInternalNode);
    }


    public void testInsertDuplicateLocation() {
        BintreeNode result = internalNode.insert(5, 5, 0, 0, 10, 10, seminar1,
            0);
        result = internalNode.insert(5, 5, 0, 0, 10, 10, seminar2, 0); // Same
                                                                       // location
        assertTrue(result instanceof BintreeInternalNode);
    }


    public void testInsertIntoBothSubtrees() {
        internalNode.insert(5, 5, 0, 0, 20, 20, seminar1, 0);
        internalNode.insert(8, 8, 0, 0, 10, 10, seminar3, 0);
        assertTrue(internalNode.left instanceof BintreeLeafNode);
        assertTrue(internalNode.right instanceof BintreeLeafNode);
    }


    public void testInsertAtBoundary() {
        internalNode.insert(0, 0, 0, 0, 10, 10, seminar1, 0);
        internalNode.insert(10, 10, 0, 0, 10, 10, seminar2, 0);
        assertTrue(internalNode.left instanceof BintreeLeafNode);
        assertTrue(internalNode.right instanceof BintreeLeafNode);
    }


    public void testInsertIntoMultipleDepths() {
        internalNode.insert(5, 5, 0, 0, 10, 10, seminar1, 0);
        internalNode.insert(3, 3, 0, 0, 10, 10, seminar2, 0);
        internalNode.insert(8, 8, 0, 0, 10, 10, seminar3, 0);
        internalNode.insert(6, 7, 0, 0, 10, 10, seminar4, 0);

        assertTrue(internalNode.left instanceof BintreeLeafNode);
        assertTrue(internalNode.right instanceof BintreeInternalNode);
    }


    public void testDeleteWithMergeUp() {
        internalNode.insert(5, 5, 0, 0, 20, 20, seminar1, 0);
        internalNode.insert(8, 8, 0, 0, 20, 20, seminar3, 0);

        BintreeNode result = internalNode.delete(5, 5, 1, 0, 0, 20, 20, 0);
        assertTrue(result instanceof BintreeLeafNode);
    }


    public void testDeleteLastNode() {
        internalNode.insert(5, 5, 0, 0, 10, 10, seminar1, 0);
        Seminar seminar5 = new Seminar(5, "Seminar 5", "2024-10-20", 60,
            (short)5, (short)5, 100, new String[] { "tech" }, "First Seminar");
        internalNode.insert(5, 5, 0, 0, 10, 10, seminar5, 0);
        BintreeNode result = internalNode.delete(5, 5, 1, 0, 0, 10, 10, 0);
        BintreeNode secondResult = internalNode.delete(5, 5, 5, 0, 0, 10, 10,
            0);
        assertTrue(secondResult instanceof BinTreeEmptyNode);
    }


    public void testDeleteNonExistentNode() {
        internalNode.insert(5, 5, 0, 0, 10, 10, seminar1, 0);
        internalNode.insert(3, 3, 0, 0, 10, 10, seminar2, 0);
        BintreeNode result = internalNode.delete(5, 5, 999, 0, 0, 10, 10, 0);
        int nodesVisited = result.search(0, 0, 0, 0, 10, 10, 20, 20, 0);
        assertEquals(3, nodesVisited);
    }


    public void testSearchSuccess() {
        internalNode.insert(9, 9, 0, 0, 10, 10, seminar1, 0);
        internalNode.insert(8, 8, 0, 0, 10, 10, seminar2, 0);
        int nodesVisited = internalNode.search(8, 8, 0, 0, 10, 10, 1, 1, 0);
        assertEquals(2, nodesVisited);
    }


    public void testSearchFailure() {
        internalNode.insert(3, 3, 0, 0, 10, 10, seminar1, 0);
        internalNode.insert(8, 8, 0, 0, 10, 10, seminar2, 0);
        int nodesVisited = internalNode.search(9, 9, 0, 0, 10, 10, 1, 1, 0);
        assertEquals(2, nodesVisited);
    }


    public void testSearchAtBoundary() {
        Seminar seminar5 = new Seminar(5, "Seminar 1", "2024-10-20", 60, (short)1,
            (short)0, 100, new String[] { "tech" }, "First Seminar");
        Seminar seminar6 = new Seminar(6, "Seminar 2", "2024-11-20", 60, (short)1,
            (short)2, 200, new String[] { "science" }, "Second Seminar");
        Seminar seminar7 = new Seminar(7, "Seminar 3", "2024-12-20", 60, (short)2,
            (short)1, 300, new String[] { "math" }, "Third Seminar");
        internalNode.insert(1, 0, 0, 0, 4, 4, seminar5, 0); 
        internalNode.insert(1, 2, 0, 0, 4, 4, seminar6, 0); 
        internalNode.insert(2, 1, 0, 0, 4, 4, seminar7, 0); 

        // create a search centered on (1,1) with radius 1
        int nodesVisited = internalNode.search(0, 0, 0, 0, 4, 4, 3, 3, 0); 

        // all 3 seminars to be found
        assertEquals(5, nodesVisited);

        // search on the edge of the bounding box
        int nodesVisitedOutsideBoundary = internalNode.search(2, 2, 0, 0, 4, 4,
            1, 1, 0);
        assertEquals(2, nodesVisitedOutsideBoundary); 
    }

}
