import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import student.TestCase;

/**
 * @author {Your Name Here}
 * @version {Put Something Here}
 */
public class ProblemSpecTest extends TestCase {
    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        // Nothing here
    }


    /**
     * Read contents of a file into a string
     * 
     * @param path
     *            File name
     * @return the string
     * @throws IOException
     */
    static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);
    }

    // ----------------------------------------------------------


    /**
     * Example 1: This method runs on a command sample IO file
     * You will write similar test cases
     * using different text files
     * 
     * @throws IOException
     */
    public void testPostedSample() throws IOException {
        // Setting up all the parameters
        String[] args = new String[2];
        args[0] = "128";
        args[1] = "solutionTestData/P2_sampleInput.txt";

        // Invoke main method of our Graph Project
        SemSearch.main(args);

        // Actual output from your System console
        String actualOutput = systemOut().getHistory();

        // Expected output from file
        String expectedOutput = readFile(
            "solutionTestData/P2_sampleOutput.txt");

        // Compare the two outputs
        // TODO: uncomment the following line
        // once you have implemented your project
        assertFuzzyEquals(expectedOutput, actualOutput);
        assertEquals("Location Tree:\n" + "E\n" + "ID Tree:\n"
            + "This tree is empty\n"
            + "Search FAILED -- There is no record with ID 1\n"
            + "Seminars matching keyword VT:\n"
            + "Insert FAILED - Bad x, y coordinates: -1, 10\n"
            + "Insert FAILED - Bad x, y coordinates: 10, 128\n"
            + "Successfully inserted record with ID 1\n"
            + "ID: 1, Title: Overview of HCI Research at VT\n"
            + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\n"
            + "Description: This seminar will present an overview of HCI research at VT\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\n"
            + "Successfully inserted record with ID 2\n"
            + "ID: 2, Title: Computational Biology and Bioinformatics in CS at Virginia Tech\n"
            + "Date: 0610071600, Length: 60, X: 10, Y: 10, Cost: 30\n"
            + "Description: Introduction to   bioinformatics and computation biology\n"
            + "Keywords: Bioinformatics, computation_biology, Biology, Computer_Science, VT, Virginia_Tech\n"
            + "Successfully inserted record with ID 10\n"
            + "ID: 10, Title: Computing Systems Research at VT\n"
            + "Date: 0701250830, Length: 30, X: 30, Y: 10, Cost: 17\n"
            + "Description: Seminar about the      Computing systems research at      VT\n"
            + "Keywords: high_performance_computing, grids, VT, computer, science\n"
            + "Successfully inserted record with ID 3\n"
            + "ID: 3, Title: Overview of HPC and CSE Research at VT\n"
            + "Date: 1203301125, Length: 35, X: 0, Y: 0, Cost: 25\n"
            + "Description: Learn what kind of    research is done on HPC  and CSE at VT\n"
            + "Keywords: HPC, CSE, computer_science\n" + "ID Tree:\n"
            + "            (null)\n" + "                \\\n"
            + "                (1)\n" + "                /\n"
            + "        (null)\n" + "            \\\n" + "            (2)\n"
            + "            /\n" + "(null)\n" + "    \\\n" + "    (3)\n"
            + "    /\n" + "(null)\n" + "        \\\n" + "        (10)\n"
            + "        /\n" + "    (null)\n" + "Number of records: 4\n"
            + "Date Tree:\n" + "            (null)\n" + "                \\\n"
            + "                (0610051600)\n" + "                /\n"
            + "        (null)\n" + "            \\\n"
            + "            (0610071600)\n" + "            /\n" + "    (null)\n"
            + "        \\\n" + "        (0701250830)\n" + "        /\n"
            + "(null)\n" + "    \\\n" + "    (1203301125)\n" + "    /\n"
            + "(null)\n" + "Number of records: 4\n" + "Keyword Tree:\n"
            + "                    (null)\n" + "                        \\\n"
            + "                        (Bioinformatics)\n"
            + "                        /\n" + "                (null)\n"
            + "                    \\\n" + "                    (Biology)\n"
            + "                    /\n" + "        (null)\n"
            + "            \\\n" + "            (CSE)\n" + "            /\n"
            + "        (null)\n" + "                \\\n"
            + "                (Computer_Science)\n" + "                /\n"
            + "            (null)\n" + "                            \\\n"
            + "                            (Computer_Science)\n"
            + "                            /\n"
            + "                        (null)\n"
            + "                                \\\n"
            + "                                (HCI)\n"
            + "                                /\n" + "            (null)\n"
            + "                \\\n" + "                (HPC)\n"
            + "                /\n" + "            (null)\n"
            + "                    \\\n" + "                    (VT)\n"
            + "                    /\n" + "                (null)\n"
            + "                        \\\n" + "                        (VT)\n"
            + "                        /\n" + "                    (null)\n"
            + "                            \\\n"
            + "                            (VT)\n"
            + "                            /\n" + "                (null)\n"
            + "                    \\\n"
            + "                    (Virginia_Tech)\n"
            + "                    /\n" + "                (null)\n"
            + "                        \\\n"
            + "                        (Virginia_Tech)\n"
            + "                        /\n" + "                (null)\n"
            + "                    \\\n"
            + "                    (computation_biology)\n"
            + "                    /\n" + "    (null)\n" + "        \\\n"
            + "        (computer)\n" + "        /\n" + "(null)\n" + "    \\\n"
            + "    (computer_science)\n" + "    /\n" + "(null)\n"
            + "            \\\n" + "            (grids)\n" + "            /\n"
            + "        (null)\n" + "                \\\n"
            + "                (high_performance_computing)\n"
            + "                /\n" + "        (null)\n" + "            \\\n"
            + "            (science)\n" + "            /\n" + "        (null)\n"
            + "Number of records: 18\n" + "Cost Tree:\n" + "    (null)\n"
            + "        \\\n" + "        (17)\n" + "        /\n" + "(null)\n"
            + "    \\\n" + "    (25)\n" + "    /\n" + "(null)\n"
            + "            \\\n" + "            (30)\n" + "            /\n"
            + "        (null)\n" + "                \\\n"
            + "                (45)\n" + "                /\n"
            + "            (null)\n" + "Number of records: 4\n"
            + "Location Tree:\n" + "                            (I)\n"
            + "                        (E)\n" + "                        (I)\n"
            + "                    (E)\n" + "                    (I)\n"
            + "                (E)\n" + "                (I)\n"
            + "            (E)\n" + "            (I)\n"
            + "        (Leaf with 1 objects: 10)\n" + "        (I)\n"
            + "    (E)\n" + "    (I)\n" + "(Leaf with 2 objects: 1 2)\n"
            + "(Leaf with 1 objects: 3)\n"
            + "Insert FAILED - There is already a record with ID 10\n"
            + "Seminars matching keyword VT:\n"
            + "ID: 10, Title: Computing Systems Research at VT\n"
            + "Date: 0701250830, Length: 30, X: 30, Y: 10, Cost: 17\n"
            + "Description: Seminar about the      Computing systems research at      VT\n"
            + "Keywords: high_performance_computing, grids, VT, computer, science\n"
            + "ID: 2, Title: Computational Biology and Bioinformatics in CS at Virginia Tech\n"
            + "Date: 0610071600, Length: 60, X: 10, Y: 10, Cost: 30\n"
            + "Description: Introduction to   bioinformatics and computation biology\n"
            + "Keywords: Bioinformatics, computation_biology, Biology, Computer_Science, VT, Virginia_Tech\n"
            + "ID: 1, Title: Overview of HCI Research at VT\n"
            + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\n"
            + "Description: This seminar will present an overview of HCI research at VT\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\n"
            + "Found record with ID 1:\n"
            + "ID: 1, Title: Overview of HCI Research at VT\n"
            + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\n"
            + "Description: This seminar will present an overview of HCI research at VT\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\n"
            + "Seminars with costs in range 30 to 50:\n"
            + "ID: 2, Title: Computational Biology and Bioinformatics in CS at Virginia Tech\n"
            + "Date: 0610071600, Length: 60, X: 10, Y: 10, Cost: 30\n"
            + "Description: Introduction to   bioinformatics and computation biology\n"
            + "Keywords: Bioinformatics, computation_biology, Biology, Computer_Science, VT, Virginia_Tech\n"
            + "ID: 1, Title: Overview of HCI Research at VT\n"
            + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\n"
            + "Description: This seminar will present an overview of HCI research at VT\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\n"
            + "7 nodes visited in this search\n"
            + "Seminars within 1 units of -1, 0:\n"
            + "Found a record with key value 3 at 0, 0\n"
            + "8 nodes visited in this search\n"
            + "Seminars within 2000 units of -1, 0:\n"
            + "Found a record with key value 3 at 0, 0\n"
            + "Found a record with key value 1 at 10, 10\n"
            + "Found a record with key value 2 at 10, 10\n"
            + "Found a record with key value 10 at 30, 10\n"
            + "15 nodes visited in this search\n"
            + "Seminars within 0 units of 10, 10:\n"
            + "Found a record with key value 1 at 10, 10\n"
            + "Found a record with key value 2 at 10, 10\n"
            + "8 nodes visited in this search\n"
            + "Seminars within 0 units of 11, 11:\n"
            + "8 nodes visited in this search\n"
            + "Seminars within 20 units of 10, 10:\n"
            + "Found a record with key value 3 at 0, 0\n"
            + "Found a record with key value 1 at 10, 10\n"
            + "Found a record with key value 2 at 10, 10\n"
            + "Found a record with key value 10 at 30, 10\n"
            + "11 nodes visited in this search\n"
            + "Seminars with dates in range 0 to 1:\n"
            + "ID: 1, Title: Overview of HCI Research at VT\n"
            + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\n"
            + "Description: This seminar will present an overview of HCI research at VT\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\n"
            + "ID: 2, Title: Computational Biology and Bioinformatics in CS at Virginia Tech\n"
            + "Date: 0610071600, Length: 60, X: 10, Y: 10, Cost: 30\n"
            + "Description: Introduction to   bioinformatics and computation biology\n"
            + "Keywords: Bioinformatics, computation_biology, Biology, Computer_Science, VT, Virginia_Tech\n"
            + "ID: 10, Title: Computing Systems Research at VT\n"
            + "Date: 0701250830, Length: 30, X: 30, Y: 10, Cost: 17\n"
            + "Description: Seminar about the      Computing systems research at      VT\n"
            + "Keywords: high_performance_computing, grids, VT, computer, science\n"
            + "8 nodes visited in this search\n"
            + "Record with ID 1 successfully deleted from the database\n"
            + "ID Tree:\n" + "        (null)\n" + "            \\\n"
            + "            (2)\n" + "            /\n" + "(null)\n" + "    \\\n"
            + "    (3)\n" + "    /\n" + "(null)\n" + "        \\\n"
            + "        (10)\n" + "        /\n" + "    (null)\n"
            + "Number of records: 3\n" + "Location Tree:\n"
            + "                            (I)\n"
            + "                        (E)\n" + "                        (I)\n"
            + "                    (E)\n" + "                    (I)\n"
            + "                (E)\n" + "                (I)\n"
            + "            (E)\n" + "            (I)\n"
            + "        (Leaf with 1 objects: 10)\n" + "        (I)\n"
            + "    (E)\n" + "    (I)\n" + "(Leaf with 1 objects: 2)\n"
            + "(Leaf with 1 objects: 3)\n", actualOutput);
    }


    /**
     * Example 2: This method runs on a command sample IO file
     * You will write similar test cases
     * using different text files
     * 
     * @throws IOException
     */
    public void testPostedSyntaxSample() throws IOException {
        // Setting up all the parameters
        String[] args = new String[2];
        args[0] = "128";
        args[1] = "solutionTestData/P2_syntaxInsertInput.txt";

        // Invoke main method of our Graph Project
        SemSearch.main(args);

        // Actual output from your System console
        String actualOutput = systemOut().getHistory();

        // Expected output from file
        String expectedOutput = readFile(
            "solutionTestData/P2_syntaxInsertOutput.txt");

        // Compare the two outputs
        // TODO: uncomment the following line
        // once you have implemented your project
        assertFuzzyEquals(expectedOutput, actualOutput);
        assertEquals(expectedOutput, actualOutput);
    }
}
