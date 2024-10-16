import student.TestCase;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Test class for KVPair class.
 * 
 * @author Kyungwan Do, Jaeyoung Shin
 * @version 10/18/2024
 */
public class ControllerTest
    extends TestCase
{
    // ~ Fields ................................................................
    private Controller controller;
    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;

    /**
     * Set up test object.
     */
    public void setUp()
    {
        controller = new Controller(128);
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }


    // ----------------------------------------------------------
    /**
     * Tests controllerInsertSearch().
     */
    public void testControllerInsertSearch()
    {
        // keyword array for the first seminar
        String[] keywords1 =
            { "HCI", "Computer_Science", "VT", "Virginia_Tech" };
        String[] keywords2 = { "Bioinformatics", "computation_biology",
            "Biology", "Computer_Science", "VT", "Virginia_Tech" };
        String[] keywords3 = { "high_performance_computing", "grids", "VT",
            "computer", "science" };
        String[] keywords4 = { "HPC", "CSE", "computer_science" };

        controller.searchById(1);
        assertNull(controller.getIdTree().find(1));
        controller.searchByKeyword("HCI");
        assertNull(controller.getKeywordTree().find("HCI"));

        // Insert the first seminar
        controller.insert(
            1,
            "Overview of HCI Research at VT",
            "0610051600",
            90,
            (short)10,
            (short)10,
            45,
            keywords1,
            "This seminar will present an overview of HCI research at VT");
        // Insert the second seminar
        controller.insert(
            2,
            "Computational Biology and Bioinformatics in CS at Virginia Tech",
            "0610071600",
            60,
            (short)10,
            (short)10,
            30,
            keywords2,
            "Introduction to bioinformatics and computation biology");

        controller.insert(
            10,
            "Computing Systems Research at VT",
            "0701250830",
            30,
            (short)30,
            (short)10,
            17,
            keywords3,
            "Seminar about the Computing systems research at VT");

        controller.insert(
            3,
            "Overview of HPC and CSE Research at VT",
            "1203301125",
            35,
            (short)0,
            (short)0,
            25,
            keywords4,
            "Learn what kind of research is done on HPC and CSE at VT");

        controller.insert(
            1,
            "Overview of HCI Research at VT",
            "0610051600",
            90,
            (short)10,
            (short)10,
            45,
            keywords1,
            "This seminar will present an overview of HCI research at VT");

        controller.insert(
            1,
            "Review of HCI Research at VT",
            "0610051600",
            90,
            (short)10,
            (short)10,
            45,
            keywords1,
            "This seminar will present an overview of HCI research at VT");

        String output = outContent.toString().trim();
        assertTrue(
            output
                .contains("Insert FAILED - There is already a record with ID"));

        controller.searchById(1);
        controller.searchById(2);
        controller.searchById(10);

        controller.searchByCost(30, 50);
        assertNotNull(controller.getCostTree().find(45));
        controller.searchByCost(100, 150);
        assertNull(controller.getCostTree().find(125));
        controller.searchByCost(50, 100);

        controller.searchByDate("0", "1");

        controller.searchByKeyword("VT");
        assertEquals(
            "Overview of HPC and CSE Research at VT",
            controller.getKeywordTree().find("HPC").value().title());
        controller.searchByKeyword("CSC");
        assertNull(controller.getKeywordTree().find("CSC"));

        controller.searchById(1);
        assertEquals(
            "Overview of HCI Research at VT",
            controller.getIdTree().find(1).value().title());
        controller.searchById(12);
        assertNull(controller.getIdTree().find(12));

        controller.getCostTree().printTree();
        controller.getDateTree().printTree();
        controller.getKeywordTree().printTree();
        controller.getIdTree().printTree();
    }


    // ----------------------------------------------------------
    /**
     * Tests delete().
     */
    public void testDelete()
    {
        String[] keywords1 =
            { "HCI", "Computer_Science", "VT", "Virginia_Tech" };
        String[] keywords2 = { "Bioinformatics", "computation_biology",
            "Biology", "Computer_Science", "VT", "Virginia_Tech" };
        String[] keywords3 = { "high_performance_computing", "grids", "VT",
            "computer", "science" };
        String[] keywords4 = { "HPC", "CSE", "computer_science" };
        // Insert the first seminar
        controller.insert(
            1,
            "Overview of HCI Research at VT",
            "0610051600",
            90,
            (short)10,
            (short)10,
            45,
            keywords1,
            "This seminar will present an overview of HCI research at VT");
        // Insert the second seminar
        controller.insert(
            2,
            "Computational Biology and Bioinformatics in CS at Virginia Tech",
            "0610071600",
            60,
            (short)10,
            (short)10,
            30,
            keywords2,
            "Introduction to bioinformatics and computation biology");

        controller.insert(
            10,
            "Computing Systems Research at VT",
            "0701250830",
            30,
            (short)30,
            (short)10,
            17,
            keywords3,
            "Seminar about the Computing systems research at VT");

        controller.insert(
            3,
            "Overview of HPC and CSE Research at VT",
            "1203301125",
            35,
            (short)0,
            (short)0,
            25,
            keywords4,
            "Learn what kind of research is done on HPC and CSE at VT");

        controller.delete(3);
        controller.getIdTree().printTree();
        controller.getDateTree().printTree();
        controller.getCostTree().printTree();
        controller.getKeywordTree().printTree();
        controller.delete(3);
    }


    // ----------------------------------------------------------
    /**
     * Tests deleteAll().
     */
    public void testDeleteAll()
    {
        String[] keywords1 =
            { "HCI", "Computer_Science", "VT", "Virginia_Tech" };
        String[] keywords2 = { "Bioinformatics", "computation_biology",
            "Biology", "Computer_Science", "VT", "Virginia_Tech" };
        String[] keywords3 = { "high_performance_computing", "grids", "VT",
            "computer", "science" };
        controller.insert(
            1,
            "Overview of HCI Research at VT",
            "0610051600",
            90,
            (short)10,
            (short)10,
            45,
            keywords1,
            "This seminar will present an overview of HCI research at VT");
        // Insert the second seminar
        controller.insert(
            2,
            "Computational Biology and Bioinformatics in CS at Virginia Tech",
            "0610071600",
            60,
            (short)10,
            (short)10,
            30,
            keywords2,
            "Introduction to bioinformatics and computation biology");

        controller.insert(
            10,
            "Computing Systems Research at VT",
            "0701250830",
            30,
            (short)30,
            (short)10,
            17,
            keywords3,
            "Seminar about the Computing systems research at VT");

        controller.delete(1);
        controller.delete(2);
        controller.delete(10);

        controller.getIdTree().printTree();
        controller.getDateTree().printTree();
        controller.getCostTree().printTree();
        controller.getKeywordTree().printTree();
    }

}
