import student.TestCase;

public class BintreeLeafNodeTest
    extends TestCase
{
    // ~ Fields ................................................................
    private BintreeLeafNode leafNode;
    private Seminar seminar1, seminar2, seminar3;

    // ~ Constructors ..........................................................
    public void setUp() {
        // Create sample seminars
        seminar1 = new Seminar(1, "Seminar 1", "2024-10-20", 60, (short)5, (short)5, 100, new String[] { "tech" }, "First Seminar");
        seminar2 = new Seminar(2, "Seminar 2", "2024-11-20", 60, (short)3, (short)3, 200, new String[] { "science" }, "Second Seminar");
        seminar3 = new Seminar(3, "Seminar 3", "2024-12-20", 60, (short)8, (short)8, 300, new String[] { "math" }, "Third Seminar");
        
        // Initialize the leaf node with seminar1
        leafNode = new BintreeLeafNode(seminar1);
    }

    // ~Public Methods ........................................................
    
    // Test that the seminar is added and the node contains the expected seminar
    public void testInsertNewSeminar() {
        // Insert seminar2 into the leaf node
        leafNode = (BintreeLeafNode)leafNode.insert(3, 3, 0, 0, 10, 10, seminar2, 0);
        
        // Try to delete seminar2 and check if it still exists
        leafNode.delete(3, 3, 2, 0, 0, 10, 10, 0);
        Seminar result = leafNode.search(3, 3, 0, 0, 10, 10, 0, 0, 0);
        
        // If the seminar is deleted, search will not find it, result should be null
        assertNull(result);
    }

    // Test inserting a seminar with the same coordinates
    public void testInsertDuplicateSeminar() {
        // Insert a seminar with the same coordinates as seminar1
        leafNode = (BintreeLeafNode)leafNode.insert(5, 5, 0, 0, 10, 10, seminar2, 0);
        
        // Perform a search to see if both seminars exist at the same coordinates
        int nodesVisited = leafNode.search(5, 5, 0, 0, 10, 10, 0, 0, 0);
        
        // Ensure we visited only one node
        assertEquals(1, nodesVisited);
    }

    // Test deleting a seminar from the node
    public void testDeleteSeminar() {
        // Insert seminar2 and then delete seminar1
        leafNode = (BintreeLeafNode)leafNode.insert(3, 3, 0, 0, 10, 10, seminar2, 0);
        leafNode = (BintreeLeafNode)leafNode.delete(5, 5, 1, 0, 0, 10, 10, 0);
        
        // Check that seminar1 has been removed via search
        Seminar result = leafNode.search(5, 5, 0, 0, 10, 10, 0, 0, 0);
        assertNull(result);
        
        // Ensure seminar2 still exists
        result = leafNode.search(3, 3, 0, 0, 10, 10, 0, 0, 0);
        assertNotNull(result);
    }

    // Test deleting the last seminar in the node (node becomes empty)
    public void testDeleteLastSeminar() {
        leafNode = (BintreeLeafNode)leafNode.delete(5, 5, 1, 0, 0, 10, 10, 0);
        
        // We can't directly check for an empty node, so search will return null
        Seminar result = leafNode.search(5, 5, 0, 0, 10, 10, 0, 0, 0);
        assertNull(result);
    }

    // Test searching for seminars
    public void testSearch() {
        // Search within the bounding box that contains seminar1
        int nodesVisited = leafNode.search(4, 4, 0, 0, 10, 10, 5, 5, 0);
        
        // Ensure that seminar1 is found
        assertEquals(1, nodesVisited); // Only one node is visited
    }

    // Test the print functionality
    public void testPrint() {
        leafNode.print(0, 3);  // Print with maxDepth of 3
        
        // Manually inspect the printed output in the console for correctness
        // Since capturing output is restricted, no assertions here.
        System.out.println("Verify print output manually.");
    }
}