import student.TestCase;

public class BSTTest extends TestCase {
    // ~ Fields ................................................................
    private BST<Integer, String> bst;

    // ~ Constructors ..........................................................
    public void setUp() {
        bst = new BST<>();
    }


    // ~Public Methods ........................................................
    public void testInsertFind() {
        assertNull(bst.find(1));
        KVPair<Integer, String> testPair1 = new KVPair<>(1, "One");
        KVPair<Integer, String> testPair2 = new KVPair<>(2, "Two");
        KVPair<Integer, String> testPair3 = new KVPair<>(3, "Three");
        KVPair<Integer, String> testPair4 = new KVPair<>(4, "Four");
        KVPair<Integer, String> testPair5 = new KVPair<>(5, "Five");
        KVPair<Integer, String> testPair6 = new KVPair<>(6, "Six");
        bst.insert(testPair1);
        bst.insert(testPair2);
        bst.insert(testPair3);
        bst.insert(testPair4);
        bst.insert(testPair5);
        bst.insert(testPair6);
        assertEquals("One", bst.find(1).value());
        assertEquals("Two", bst.find(2).value());
        assertEquals("Three", bst.find(3).value());
        assertEquals("Four", bst.find(4).value());
        assertEquals("Five", bst.find(5).value());
        assertNotNull(bst.find(6));
        assertNull(bst.find(10));
        bst.printTree();
    }


    public void testFindRange() {
        KVPair<Integer, String> testPair1 = new KVPair<>(1, "One");
        KVPair<Integer, String> testPair2 = new KVPair<>(2, "Two");
        KVPair<Integer, String> testPair3 = new KVPair<>(3, "Three");
        KVPair<Integer, String> testPair4 = new KVPair<>(4, "Four");
        KVPair<Integer, String> testPair5 = new KVPair<>(5, "Five");
        KVPair<Integer, String> testPair6 = new KVPair<>(6, "Six");
        bst.insert(testPair1);
        bst.insert(testPair2);
        bst.insert(testPair3);
        bst.insert(testPair4);
        bst.insert(testPair5);
        bst.insert(testPair6);
        int nodesVisited1 = bst.findRange(2, 4);
        assertEquals(9, nodesVisited1);
        
        
        bst.printTree();
    }
    
    


    public void testFindRangeEmptyTree() {
        int nodesVisited = bst.findRange(2, 4);
        assertEquals(1, nodesVisited); 
    }
    
    
    public void testInsertDuplicate() {
        KVPair<Integer, String> testPair1 = new KVPair<>(3, "Three");
        KVPair<Integer, String> testPair2 = new KVPair<>(3, "DuplicateThree");

        bst.insert(testPair1);
        bst.insert(testPair2);

        assertEquals(2, bst.size());
    }
    
    public void testInsertNegative() {
        KVPair<Integer, String> testPair1 = new KVPair<>(-2, "NegativeTwo");
        bst.insert(testPair1);
        assertEquals("NegativeTwo", bst.find(-2).value());
        assertNull(bst.find(0));
    }
    
    public void testFindRangeSame() {
        KVPair<Integer, String> testPair1 = new KVPair<>(1, "One");
        KVPair<Integer, String> testPair2 = new KVPair<>(2, "Two");
        KVPair<Integer, String> testPair3 = new KVPair<>(3, "Three");
        KVPair<Integer, String> testPair4 = new KVPair<>(4, "Four");
        KVPair<Integer, String> testPair5 = new KVPair<>(5, "Five");
        KVPair<Integer, String> testPair6 = new KVPair<>(6, "Six");
        bst.insert(testPair1);
        bst.insert(testPair2);
        bst.insert(testPair3);
        bst.insert(testPair4);
        bst.insert(testPair5);
        bst.insert(testPair6);
        int nodesVisited = bst.findRange(3, 3);
        assertEquals(6, nodesVisited);
    }
    
    
    public void testFindRangeOutOfBounds() {
        KVPair<Integer, String> testPair1 = new KVPair<>(1, "One");
        KVPair<Integer, String> testPair2 = new KVPair<>(2, "Two");
        KVPair<Integer, String> testPair3 = new KVPair<>(3, "Three");
        KVPair<Integer, String> testPair4 = new KVPair<>(4, "Four");
        KVPair<Integer, String> testPair5 = new KVPair<>(5, "Five");
        KVPair<Integer, String> testPair6 = new KVPair<>(6, "Six");
        bst.insert(testPair1);
        bst.insert(testPair2);
        bst.insert(testPair3);
        bst.insert(testPair4);
        bst.insert(testPair5);
        bst.insert(testPair6);
        int nodesVisited = bst.findRange(10, 15);
        assertEquals(7, nodesVisited);
    }
    
    
    
}
