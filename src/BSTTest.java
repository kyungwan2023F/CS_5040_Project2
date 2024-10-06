import student.TestCase;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BSTTest extends TestCase {
    // ~ Fields ................................................................
    private BST<Integer, String> bst;
    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;

    // ~ Constructors ..........................................................
    public void setUp() {
        bst = new BST<>();
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent)); 
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
        assertEquals(7, nodesVisited1);
        
        int nodesVisted2 = bst.findRange(1, 5);
        assertEquals(10, nodesVisted2);
        
        int nodesVisted3 = bst.findRange(4, 6);
        assertEquals(9, nodesVisted3);
        
        int nodesVisted4 = bst.findRange(3, 4);
        assertEquals(6, nodesVisted4);
        
        
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
        assertEquals(4, nodesVisited);
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
        
        int nodesVisited1 = bst.findRange(-3, -1);
        assertEquals(7, nodesVisited);
    }
    
    public void testPrintNull() {
        bst.printTree();
    }
    
    public void testFindRangeLeftTraversal() {
        
        BST<Integer, String> bst = new BST<>();
        bst.insert(new KVPair<>(10, "Ten"));
        bst.insert(new KVPair<>(5, "Five"));
        bst.insert(new KVPair<>(3, "Three"));  
        bst.insert(new KVPair<>(7, "Seven"));  
        bst.insert(new KVPair<>(15, "Fifteen"));

        
        int nodesVisited = bst.findRange(3, 7);
        
        
        assertEquals(7, nodesVisited);  
    }
    
    public void testFindRangeWithConsoleOutput() {
        bst.insert(new KVPair<>(10, "Ten"));
        bst.insert(new KVPair<>(5, "Five"));
        bst.insert(new KVPair<>(3, "Three"));  
        bst.insert(new KVPair<>(7, "Seven"));  
        bst.insert(new KVPair<>(15, "Fifteen"));
        bst.findRange(3, 10);

        String output = outContent.toString().trim();

        assertTrue(output.contains("Three"));
        assertTrue(output.contains("Five"));
        assertTrue(output.contains("Seven"));
        assertTrue(output.contains("Ten"));

        assertFalse(output.contains("Fifteen"));
    }
    
    public void testPrintTreeEmpty() {
        BST<Integer, String> emptyBST = new BST<>();

        emptyBST.printTree();

        String output = outContent.toString().trim();

        assertEquals("This tree is empty", output);
    }
    
    public void testPrintTree() {
        bst.insert(new KVPair<>(10, "Ten"));
        bst.insert(new KVPair<>(5, "Five"));
        bst.insert(new KVPair<>(3, "Three"));  
        bst.insert(new KVPair<>(7, "Seven"));  
        bst.insert(new KVPair<>(15, "Fifteen"));
        bst.printTree();

        String output = outContent.toString().trim();

        String expectedOutput ="(null)\r\n"
            + "    \\\r\n"
            + "    (3)\r\n"
            + "    /\r\n"
            + "(null)\r\n"
            + "        \\\r\n"
            + "        (5)\r\n"
            + "        /\r\n"
            + "(null)\r\n"
            + "    \\\r\n"
            + "    (7)\r\n"
            + "    /\r\n"
            + "(null)\r\n"
            + "            \\\r\n"
            + "            (10)\r\n"
            + "            /\r\n"
            + "    (null)\r\n"
            + "        \\\r\n"
            + "        (15)\r\n"
            + "        /\r\n"
            + "    (null)\r\n"
            + "Number of records: 5";

        assertEquals(expectedOutput, output);
    }
    
    public void testGetHeight() {
        bst.insert(new KVPair<>(1, "One"));
        bst.insert(new KVPair<>(2, "Two"));
        bst.insert(new KVPair<>(10, "Three"));
        bst.insert(new KVPair<>(3, "Four"));
        int height = bst.getHeight();
        assertEquals(4, height);
    }

    
    
    
}
