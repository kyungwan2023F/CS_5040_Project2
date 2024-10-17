import student.TestCase;

// -------------------------------------------------------------------------
/**
 *  Test the Seminar class
 *
 *  @author CS3114/CS5040 staff
 *  @version July 2023, last updated September 2023
 */
public class SeminarTest extends TestCase {
    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        
    }


    /**
     * Check the toString method
     */
    public void testToString()
    {
        String[] keywords = {"Good", "Bad", "Ugly"};
        String expected = "ID: 1729, Title: Seminar Title\n"
            + "Date: 2405231000, Length: 75, X: 15, Y: 33, Cost: 125\n"
            + "Description: This is a great seminar\n"
            + "Keywords: Good, Bad, Ugly";
        Seminar mysem = new Seminar(1729, "Seminar Title", "2405231000", 75,
            (short)15, (short)33, 125, keywords, "This is a great seminar");
        String semPrint = mysem.toString();
        System.out.println("testtoString");
        System.out.println(semPrint);
        assertTrue(semPrint.equals(expected));
        assertTrue(mysem.id() == 1729);
        assertTrue(mysem.cost() == 125);
        assertTrue(mysem.x() == 15);
        assertTrue(mysem.y() == 33);
        assertTrue(mysem.length() == 75);
        assertEquals("Seminar Title", mysem.title());
        assertEquals("This is a great seminar", mysem.description());
        assertTrue(mysem.date().equals("2405231000"));
        String[] tempKeywords = mysem.keywords();
        for (int i = 0; i < keywords.length; i++) {
            assertTrue(tempKeywords[i].equals(keywords[i]));
        }
    }
    
    public void testEmptyKeywords() {
        String[] emptyKeywords = {};
        Seminar emptyKeywordSeminar = new Seminar(1002, "Empty Keywords", "20231002", 60,
                (short) 30, (short) 40, 300, emptyKeywords, "No keywords here");
        assertEquals(0, emptyKeywordSeminar.keywords().length);
        assertEquals("Empty Keywords", emptyKeywordSeminar.title());
    }
    
    
    public void testNullKeywords() {
        String[] nullKeywords = { null, "AI", null };
        Seminar nullKeywordSeminar = new Seminar(1003, "Null Keywords", "20231003", 90,
                (short) 40, (short) 50, 400, nullKeywords, "Seminar with some null keywords");
        String[] tempKeywords = nullKeywordSeminar.keywords();

        // Ensure the null values are handled correctly
        assertNull(tempKeywords[0]);
        assertEquals("AI", tempKeywords[1]);
        assertNull(tempKeywords[2]);
    }
    
    public void testNegativeValues() {
        Seminar negativeSeminar = new Seminar(1004, "Negative Values Seminar", "20231004", 0,
                (short) -10, (short) -20, -100, new String[] { "Error", "Negative" }, "Testing negative values");

        assertEquals(0, negativeSeminar.length());
        assertEquals(-10, negativeSeminar.x());
        assertEquals(-20, negativeSeminar.y());
        assertEquals(-100, negativeSeminar.cost());
    }
    
    public void testEmptyStrings() {
        Seminar emptyStringSeminar = new Seminar(1005, "", "", 60,
                (short) 10, (short) 20, 150, new String[] { "Empty" }, "");

        assertEquals("", emptyStringSeminar.title());
        assertEquals("", emptyStringSeminar.date());
        assertEquals("", emptyStringSeminar.description());
    }
    
    public void testNullTitleAndDescription() {
        Seminar nullTitleSeminar = new Seminar(1006, null, "20231005", 60,
                (short) 15, (short) 25, 200, new String[] { "Null" }, null);

        assertNull(nullTitleSeminar.title());
        assertNull(nullTitleSeminar.description());
    }
    


    /**
     * Check the serialization/deserialization process
     * @throws Exception
     */
    public void testSeminarDS()
        throws Exception
    {
        String[] keywords = {"Good", "Bad", "Ugly"};

        Seminar mysem = new Seminar(1729, "Seminar Title", "2405231000", 75,
            (short)15, (short)33, 125, keywords, "This is a great seminar");
        String semPrint = mysem.toString();
        System.out.println(semPrint);
        assertTrue(semPrint.equals("ID: 1729, Title: Seminar Title\n" +
            "Date: 2405231000, Length: 75, X: 15, Y: 33, Cost: 125\n" +
            "Description: This is a great seminar\n" +
            "Keywords: Good, Bad, Ugly"));
    }
    
    
    public void testEquals() {
        String[] testKeywords1 = {"AI", "ML", "Data Science"};
        String[] testKeywords2 = {"Blockchain", "Cryptocurrency"};

        Seminar testSeminar1 = new Seminar(1001, "AI Seminar", "20231001", 90, (short)10, (short)20, 100, testKeywords1, "AI technologies");
        Seminar testSeminar1Duplicate = new Seminar(1001, "AI Seminar Duplicate", "20231001", 90, (short)10, (short)20, 100, testKeywords1, "AI technologies");
        Seminar testSeminar2 = new Seminar(1002, "Blockchain Seminar", "20231002", 120, (short)30, (short)40, 150, testKeywords2, "Blockchain basics");

        assertTrue(testSeminar1.equals(testSeminar1Duplicate));

        assertFalse(testSeminar1.equals(testSeminar2));

        assertTrue(testSeminar1.equals(testSeminar1));

        assertFalse(testSeminar1.equals(new Object()));
    }
    
    
}
