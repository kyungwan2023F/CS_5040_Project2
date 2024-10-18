import student.TestCase;

public class BintreeInternalNodeTest extends TestCase {
    // ~ Fields ................................................................
    private BintreeInternalNode internalNode;
    private Seminar seminar1, seminar2, seminar3, seminar4, seminar5, seminar6,
        seminar7, seminar8, seminar9;

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
        seminar5 = new Seminar(5, "Seminar 5", "2024-12-30", 60, (short)1,
            (short)1, 100, new String[] { "tech" }, "Fifth Seminar");
        seminar6 = new Seminar(6, "Seminar 6", "2025-01-01", 60, (short)0,
            (short)0, 200, new String[] { "science" }, "Sixth Seminar");
        seminar7 = new Seminar(7, "Seminar 7", "2025-01-05", 60, (short)9,
            (short)9, 300, new String[] { "math" }, "Seventh Seminar");
        seminar8 = new Seminar(8, "Seminar 8", "2025-01-10", 60, (short)4,
            (short)4, 400, new String[] { "math" }, "Eighth Seminar");
        seminar9 = new Seminar(9, "Seminar 9", "2025-01-15", 60, (short)2,
            (short)2, 100, new String[] { "math" }, "Ninth Seminar");
    }


    // ~Public Methods ........................................................
    public void testInsertIntoEmptyTree() {
        BintreeNode result = internalNode.insert(5, 5, 0, 0, 10, 10, seminar1,
            0);
        assertNotNull(result);
        assertTrue(result instanceof BintreeInternalNode);
    }


    public void testInsertMultipleNodesFillingPositions() {
        internalNode.insert(5, 5, 0, 0, 10, 10, seminar1, 0);
        internalNode.insert(3, 3, 0, 0, 10, 10, seminar2, 0);
        internalNode.insert(8, 8, 0, 0, 10, 10, seminar3, 0);
        internalNode.insert(6, 7, 0, 0, 10, 10, seminar4, 0);
        internalNode.insert(1, 1, 0, 0, 10, 10, seminar5, 0);
        internalNode.insert(0, 0, 0, 0, 10, 10, seminar6, 0);
        internalNode.insert(9, 9, 0, 0, 10, 10, seminar7, 0);
        internalNode.insert(4, 4, 0, 0, 10, 10, seminar8, 0);
        internalNode.insert(2, 2, 0, 0, 10, 10, seminar9, 0);

        assertTrue(internalNode.left instanceof BintreeInternalNode); // Check
                                                                      // internal
                                                                      // structure
        assertTrue(internalNode.right instanceof BintreeInternalNode); // Check
                                                                       // depth
    }


    public void testInsertDuplicateLocation() {
        BintreeNode result = internalNode.insert(5, 5, 0, 0, 10, 10, seminar1,
            0);
        result = internalNode.insert(seminar1.x(), seminar1.y(), 0, 0, 10, 10, seminar1, 0);
        assertTrue(result instanceof BintreeInternalNode);
    }


    public void testInsertIntoBothSubtrees() {
        internalNode.insert(5, 5, 0, 0, 20, 20, seminar1, 0);
        internalNode.insert(8, 8, 0, 0, 10, 10, seminar3, 0);
        assertTrue(internalNode.left instanceof BintreeLeafNode);
        assertTrue(internalNode.right instanceof BintreeLeafNode);
    }


    public void testInsertAtBoundary() {
        internalNode.insert(seminar1.x(), seminar1.x(), 0, 0, 10, 10, seminar1, 0);
        Seminar seminar10 = new Seminar(10, "Seminar 10", "2025-01-15", 60, (short)0,
            (short)0, 100, new String[] { "math" }, "Tenth Seminar");
        internalNode.insert(seminar10.x(), seminar10.y(), 0, 0, 10, 10, seminar10, 0);
        int nodesVisited = internalNode.search(4, 4, 0, 0, 10, 10, 3, 3, 0);
        assertEquals(3, nodesVisited);
    }


    public void testInsertIntoMultipleDepths() {
        internalNode.insert(5, 5, 0, 0, 10, 10, seminar1, 0);
        internalNode.insert(seminar2.x(), seminar2.y(), 0, 0, 10, 10, seminar2, 0);
        internalNode.insert(seminar3.x(), seminar3.y(), 0, 0, 10, 10, seminar3, 0);
        internalNode.insert(seminar4.x(), seminar4.x(), 0, 0, 10, 10, seminar4, 0);

        assertTrue(internalNode.left instanceof BintreeLeafNode);
        assertTrue(internalNode.right instanceof BintreeInternalNode);
    }


    public void testDeleteWithMergeUp() {
        internalNode.insert(seminar1.x(), seminar1.y(), 0, 0, 20, 20, seminar1, 0);
        internalNode.insert(seminar3.x(), seminar3.y(), 0, 0, 20, 20, seminar3, 0);

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
        internalNode.insert(seminar1.x(), seminar1.y(), 0, 0, 10, 10, seminar1, 0);
        internalNode.insert(seminar2.x(), seminar2.y(), 0, 0, 10, 10, seminar2, 0);
        BintreeNode result = internalNode.delete(5, 5, 999, 0, 0, 10, 10, 0);
        int nodesVisited = result.search(0, 0, 0, 0, 10, 10, 20, 20, 0);
        assertEquals(3, nodesVisited);
    }


    public void testSearchSuccess() {
        internalNode.insert(seminar1.x(), seminar1.y(), 0, 0, 10, 10, seminar1, 0);
        internalNode.insert(seminar2.x(), seminar2.y(), 0, 0, 10, 10, seminar2, 0);
        int nodesVisited = internalNode.search(8, 8, 0, 0, 10, 10, 1, 1, 0);
        assertEquals(2, nodesVisited);
    }


    public void testSearchFailure() {
        internalNode.insert(seminar1.x(), seminar1.y(), 0, 0, 10, 10, seminar1, 0);
        internalNode.insert(seminar2.x(), seminar2.y(), 0, 0, 10, 10, seminar2, 0);
        int nodesVisited = internalNode.search(9, 9, 0, 0, 10, 10, 1, 1, 0);
        assertEquals(2, nodesVisited);
    }


    public void testInsertDepthLogic() {
        Seminar seminar5 = new Seminar(5, "Seminar 1", "2024-10-20", 60,
            (short)1, (short)6, 100, new String[] { "tech" }, "First Seminar");
        // Insert at depth 0 (even depth), expect split by x-coordinate
        internalNode.insert(5, 5, 0, 0, 10, 10, seminar1, 0); // Root
        internalNode.insert(seminar5.x(), seminar5.y(), 0, 0, 10, 10, seminar5,
            1);

        // check the structure of the tree
        assertTrue(internalNode.left instanceof BinTreeEmptyNode);
        assertTrue(internalNode.right instanceof BintreeInternalNode);
    }


    public void testSearchRespectsDepth() {
        internalNode.insert(5, 5, 0, 0, 10, 10, seminar1, 0);
        internalNode.insert(3, 5, 0, 0, 10, 10, seminar2, 0);
        internalNode.insert(8, 5, 0, 0, 10, 10, seminar3, 0);

        int nodesVisited = internalNode.search(0, 0, 0, 0, 10, 10, 10, 10, 0);
        assertEquals(7, nodesVisited);
    }


    public void testInsertAndDeleteMultipletimes() {
        // Insert nodes into the tree
        Seminar seminar5 = new Seminar(5, "Seminar 5", "2024-10-20", 60,
            (short)5, (short)5, 100, new String[] { "tech" }, "Fifth Seminar");
        internalNode.insert(seminar1.x(), seminar1.y(), 0, 0, 10, 10, seminar1,
            0);
        internalNode.insert(seminar2.x(), seminar2.y(), 0, 0, 10, 10, seminar2,
            0);
        internalNode.insert(seminar3.x(), seminar3.y(), 0, 0, 10, 10, seminar3,
            0);
        internalNode.insert(seminar4.x(), seminar4.y(), 0, 0, 10, 10, seminar4,
            0);
        internalNode.insert(seminar5.x(), seminar5.y(), 0, 0, 10, 10, seminar5,
            0);

        // delete some nodes and check the resulting structure
        internalNode.delete(8, 8, 3, 0, 0, 10, 10, 0);
        internalNode.delete(6, 7, 4, 0, 0, 10, 10, 0);
        internalNode.delete(3, 3, 2, 0, 0, 10, 10, 0);
        internalNode.delete(5, 5, 1, 0, 0, 10, 10, 0);
        internalNode.delete(5, 5, 5, 0, 0, 10, 10, 0);
        assertEquals(internalNode.search(8, 8, 0, 0, 10, 10, 1, 1, 0), 2);
    }


    public void testInsertAtBoundaryB() {
        internalNode.insert(0, 0, 0, 0, 10, 10, seminar1, 0);
        internalNode.insert(10, 10, 0, 0, 10, 10, seminar2, 0);
        internalNode.insert(10, 0, 0, 0, 10, 10, seminar3, 0);
        internalNode.insert(0, 10, 0, 0, 10, 10, seminar4, 0);
        assertFalse(internalNode.left instanceof BintreeInternalNode);
        assertTrue(internalNode.right instanceof BintreeInternalNode);
    }


    public void testDeleteNodesAtVariousPositions() {
        internalNode.insert(5, 5, 0, 0, 10, 10, seminar1, 0);
        internalNode.insert(3, 3, 0, 0, 10, 10, seminar2, 0);
        internalNode.insert(8, 8, 0, 0, 10, 10, seminar3, 0);
        internalNode.insert(6, 7, 0, 0, 10, 10, seminar4, 0);
        internalNode.insert(1, 1, 0, 0, 10, 10, seminar5, 0);

        BintreeNode result = internalNode.delete(3, 3, 2, 0, 0, 10, 10, 0);
        assertFalse(internalNode.left instanceof BintreeInternalNode); // Check
                                                                       // that
                                                                       // deletion
                                                                       // merged
                                                                       // correctly

        result = internalNode.delete(1, 1, 5, 0, 0, 10, 10, 0);
    }


    public void testSearchVariousPositions() {
        internalNode.insert(5, 5, 0, 0, 10, 10, seminar1, 0);
        internalNode.insert(3, 3, 0, 0, 10, 10, seminar2, 0);
        internalNode.insert(8, 8, 0, 0, 10, 10, seminar3, 0);
        internalNode.insert(6, 7, 0, 0, 10, 10, seminar4, 0);
        internalNode.insert(1, 1, 0, 0, 10, 10, seminar5, 0);
        internalNode.insert(9, 9, 0, 0, 10, 10, seminar7, 0);

        int nodesVisited = internalNode.search(3, 3, 0, 0, 10, 10, 1, 1, 0);
        assertEquals(4, nodesVisited); // Ensure the correct number of nodes are
                                       // visited

        nodesVisited = internalNode.search(1, 1, 0, 0, 10, 10, 2, 2, 0);
        assertEquals(5, nodesVisited); // Ensure boundary search is correct
    }


    public void testInsertAndDeleteOnEdgeNodes() {
        // Inserting edge nodes
        internalNode.insert(10, 0, 0, 0, 10, 10, seminar1, 0);
        internalNode.insert(0, 10, 0, 0, 10, 10, seminar2, 0);
        internalNode.insert(10, 10, 0, 0, 10, 10, seminar3, 0);
        internalNode.insert(0, 0, 0, 0, 10, 10, seminar4, 0);

        // Deleting boundary nodes
        BintreeNode result = internalNode.delete(10, 10, 3, 0, 0, 10, 10, 0);
        assertTrue(result instanceof BintreeInternalNode);

        result = internalNode.delete(0, 0, 4, 0, 0, 10, 10, 0);
        assertTrue(result instanceof BintreeInternalNode);
    }


    public void testPrintTree() {
        internalNode.insert(5, 5, 0, 0, 10, 10, seminar1, 0);
        internalNode.insert(3, 3, 0, 0, 10, 10, seminar2, 0);
        internalNode.print(0, 2);
    }


    public void testInsertIntoEmptyTreeC() {
        BintreeNode result = internalNode.insert(5, 5, 0, 0, 10, 10, seminar1,
            0);
        assertNotNull(result);
        assertEquals(BintreeInternalNode.class, result.getClass());
    }


    public void testInsertDuplicateLocationC() {
        internalNode.insert(5, 5, 0, 0, 10, 10, seminar1, 0);
        BintreeNode result = internalNode.insert(5, 5, 0, 0, 10, 10, seminar2,
            0);
        assertEquals(BintreeInternalNode.class, result.getClass());
    }


    public void testInsertIntoBothSubtreesC() {
        internalNode.insert(5, 5, 0, 0, 20, 20, seminar1, 0);
        internalNode.insert(8, 8, 0, 0, 10, 10, seminar3, 0);
        assertEquals(BintreeLeafNode.class, internalNode.left.getClass());
        assertEquals(BintreeLeafNode.class, internalNode.right.getClass());
    }


    public void testInsertAtBoundaryC() {
        internalNode.insert(0, 0, 0, 0, 10, 10, seminar6, 0);
        internalNode.insert(10, 10, 0, 0, 10, 10, seminar2, 0);
        assertEquals(BintreeInternalNode.class, internalNode.left.getClass());
        assertEquals(BinTreeEmptyNode.class, internalNode.right.getClass());
    }


    public void testInsertIntoMultipleDepthsC() {
        internalNode.insert(5, 5, 0, 0, 10, 10, seminar1, 0);
        internalNode.insert(3, 3, 0, 0, 10, 10, seminar2, 0);
        internalNode.insert(8, 8, 0, 0, 10, 10, seminar3, 0);
        internalNode.insert(6, 7, 0, 0, 10, 10, seminar4, 0);

        assertEquals(BintreeLeafNode.class, internalNode.left.getClass());
        assertEquals(BintreeInternalNode.class, internalNode.right.getClass());
    }


    public void testDeleteWithMergeUpC() {
        internalNode.insert(5, 5, 0, 0, 20, 20, seminar1, 0);
        internalNode.insert(8, 8, 0, 0, 20, 20, seminar3, 0);

        BintreeNode result = internalNode.delete(5, 5, 1, 0, 0, 20, 20, 0);
        assertEquals(BintreeLeafNode.class, result.getClass());
    }


    public void testDeleteLastNodeC() {
        internalNode.insert(5, 5, 0, 0, 10, 10, seminar1, 0);
        internalNode.insert(5, 5, 0, 0, 10, 10, seminar5, 0);
        BintreeNode result = internalNode.delete(5, 5, 1, 0, 0, 10, 10, 0);
        BintreeNode secondResult = internalNode.delete(5, 5, 5, 0, 0, 10, 10,
            0);
        assertEquals(BintreeLeafNode.class, secondResult.getClass());
    }


    public void testDeleteNonExistentNodeC() {
        internalNode.insert(5, 5, 0, 0, 10, 10, seminar1, 0);
        internalNode.insert(3, 3, 0, 0, 10, 10, seminar2, 0);
        BintreeNode result = internalNode.delete(5, 5, 999, 0, 0, 10, 10, 0);
        int nodesVisited = result.search(0, 0, 0, 0, 10, 10, 20, 20, 0);
        assertEquals(3, nodesVisited);
    }


    public void testSearchSuccessC() {
        internalNode.insert(9, 9, 0, 0, 10, 10, seminar1, 0);
        internalNode.insert(8, 8, 0, 0, 10, 10, seminar2, 0);
        int nodesVisited = internalNode.search(8, 8, 0, 0, 10, 10, 1, 1, 0);
        assertEquals(2, nodesVisited);
    }


    public void testSearchAtBoundaryC() {
        internalNode.insert(1, 0, 0, 0, 4, 4, seminar5, 0);
        internalNode.insert(1, 2, 0, 0, 4, 4, seminar6, 0);
        internalNode.insert(2, 1, 0, 0, 4, 4, seminar7, 0);

        // Create a search centered on (1,1) with radius 1
        int nodesVisited = internalNode.search(0, 0, 0, 0, 4, 4, 3, 3, 0);
        assertEquals(7, nodesVisited);

        // Search on the edge of the bounding box
        int nodesVisitedOutsideBoundary = internalNode.search(2, 2, 0, 0, 4, 4,
            1, 1, 0);
        assertEquals(2, nodesVisitedOutsideBoundary);
    }


    // Add more cases using the remaining seminars to further test various
    // operations
    public void testSearchWithFullTree() {
        internalNode.insert(5, 5, 0, 0, 10, 10, seminar1, 0);
        internalNode.insert(3, 3, 0, 0, 10, 10, seminar2, 0);
        internalNode.insert(8, 8, 0, 0, 10, 10, seminar3, 0);
        internalNode.insert(6, 7, 0, 0, 10, 10, seminar4, 0);
        internalNode.insert(1, 1, 0, 0, 10, 10, seminar5, 0);
        internalNode.insert(0, 0, 0, 0, 10, 10, seminar6, 0);
        internalNode.insert(9, 9, 0, 0, 10, 10, seminar7, 0);
        internalNode.insert(4, 4, 0, 0, 10, 10, seminar8, 0);
        internalNode.insert(2, 2, 0, 0, 10, 10, seminar9, 0);

        // Search across the whole tree
        int nodesVisited = internalNode.search(5, 5, 0, 0, 10, 10, 5, 5, 0);
        assertEquals(15, nodesVisited);
    }

}
