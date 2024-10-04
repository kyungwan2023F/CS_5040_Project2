import student.TestCase;

// Name Jaeyoung Shin
public class ControllerTest extends TestCase {
    // ~ Fields ................................................................
    private Controller controller;

    // ~ Constructors ..........................................................
    public void setUp() {
        controller = new Controller();
    }


    // ~Public Methods ........................................................
    public void testControllerInsertSearch() {
        // keyword array for the first seminar
        String[] keywords1 = { "HCI", "Computer_Science", "VT",
            "Virginia_Tech" };
        String[] keywords2 = { "Bioinformatics", "computation_biology",
            "Biology", "Computer_Science", "VT", "Virginia_Tech" };
        String[] keywords3 = { "high_performance_computing", "grids", "VT",
            "computer", "science" };
        String[] keywords4 = { "HPC", "CSE", "computer_science" };

        // Insert the first seminar
        controller.insert(1, "Overview of HCI Research at VT", "0610051600", 90,
            (short)10, (short)10, 45, keywords1,
            "This seminar will present an overview of HCI research at VT");

        // Insert the second seminar
        controller.insert(2,
            "Computational Biology and Bioinformatics in CS at Virginia Tech",
            "0610071600", 60, (short)10, (short)10, 30, keywords2,
            "Introduction to bioinformatics and computation biology");

        controller.insert(10, "Computing Systems Research at VT", "0701250830",
            30, (short)30, (short)10, 17, keywords3,
            "Seminar about the Computing systems research at VT");

        controller.insert(3, "Overview of HPC and CSE Research at VT",
            "1203301125", 35, (short)0, (short)0, 25, keywords4,
            "Learn what kind of research is done on HPC and CSE at VT");

// controller.searchById(1);
// controller.searchById(2);
// controller.searchById(10);

        controller.searchByCost(30, 50);
// controller.searchByCost(50, 100);
//
        controller.searchByDate("0", "1");

        controller.searchByKeyword("VT");

        controller.getCostTree().printTree();
        controller.getDateTree().printTree();
        controller.getKeywordTree().printTree();
    }
}
