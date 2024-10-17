import student.TestCase;

public class BintreeInternalNodeTest
    extends TestCase
{
    // ~ Fields ................................................................
    private BintreeInternalNode testNode;
    private Seminar testSeminar1;
    private Seminar testSeminar2;
    private Seminar testSeminar3;
    // ~ Constructors ..........................................................
    public void setUp() {
        testNode = new BintreeInternalNode();
        String[] keywords1 = {"AI", "ML"};
        String[] keywords2 = {"Blockchain", "Cryptocurrency"};
        String[] keywords3 = {"Quantum", "Computing"};

        testSeminar1 = new Seminar(101, "AI Seminar", "20231001", 90, (short)10, (short)20, 100, keywords1, "AI technologies");
        testSeminar2 = new Seminar(102, "Blockchain Seminar", "20231002", 120, (short)30, (short)40, 150, keywords2, "Blockchain basics");
        testSeminar3 = new Seminar(103, "Quantum Computing Seminar", "20231003", 150, (short)50, (short)60, 200, keywords3, "Quantum advancements");
    }
    // ~Public Methods ........................................................
    public void testInsert() {
        testNode = (BintreeInternalNode) testNode.insert(10, 20, 0, 0, 100, 100, testSeminar1, 0);
        assertNotNull(testNode.left);  // Seminar should be on the left

        // Insert seminar2 (should go right)
        testNode = (BintreeInternalNode) testNode.insert(30, 40, 0, 0, 100, 100, testSeminar2, 0);
        assertNotNull(testNode.right);  // Seminar should be on the right

        // Insert seminar3 (should also go right)
        testNode = (BintreeInternalNode) testNode.insert(50, 60, 0, 0, 100, 100, testSeminar3, 0);
        assertNotNull(testNode.right);  // Ensure it's inserted on the right

        // Ensure left node is still occupied by seminar1
        assertTrue(testNode.left instanceof BintreeLeafNode);
        // Ensure right node is occupied
        assertTrue(testNode.right instanceof BintreeInternalNode);
    }
}
