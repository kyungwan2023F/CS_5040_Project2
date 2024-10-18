import student.TestCase;

/**
 * Test class for KVPair class.
 * 
 * @author Kyungwan Do, Jaeyoung Shin
 * @version 10/18/2024
 */
public class KVPairTest
    extends TestCase
{
    // ~ Fields ................................................................
    private KVPair<Integer, String> testKVPair1;
    private KVPair<Integer, String> testKVPair2;
    private KVPair<Integer, String> testKVPair3;

    // ~ Constructors ..........................................................
    public void setUp()
    {
        testKVPair1 = new KVPair<>(1, "One");
        testKVPair2 = new KVPair<>(2, "Two");
        testKVPair3 = new KVPair<>(1, "Three");
    }


    // ----------------------------------------------------------
    /**
     * Tests CompareToKVPair().
     */
    public void testCompareToKVPair()
    {
        assertTrue(testKVPair1.compareTo(testKVPair2) < 0);
        assertTrue(testKVPair2.compareTo(testKVPair1) > 0);
        assertEquals(0, testKVPair1.compareTo(testKVPair3));
    }


    // ----------------------------------------------------------
    /**
     * Tests CompareToKey().
     */
    public void testCompareToKey()
    {
        assertTrue(testKVPair1.compareTo(2) < 0);
        assertTrue(testKVPair2.compareTo(1) > 0);
        assertTrue(testKVPair3.compareTo(1) == 0);
    }


    // ----------------------------------------------------------
    /**
     * Tests CompareToNullValue().
     */
    public void testCompareToNullValue()
    {
        KVPair<Integer, String> testKVPair4 = new KVPair<>(3, null);
        KVPair<Integer, String> testKVPair5 = new KVPair<>(3, "Three");
        assertEquals(0, testKVPair4.compareTo(testKVPair5));
    }


    // ----------------------------------------------------------
    /**
     * Tests CompareToNullKey().
     */
    public void testCompareToNullKey()
    {
        KVPair<Integer, String> testKVPair6 = new KVPair<>(null, "Null");
        // Expect NullPointerException when comparing null key
        Exception exception = null;
        try
        {
            testKVPair6.compareTo(1);
        }
        catch (NullPointerException e)
        {
            exception = e;
        }
        assertNotNull(exception);
    }


    // ----------------------------------------------------------
    /**
     * Tests NullKVPair().
     */
    public void testNullKVPair()
    {
        KVPair<Integer, String> testKVPair7 = new KVPair<>(null, null);
        assertNull(testKVPair7.key());
        assertNull(testKVPair7.value());
    }


    // ----------------------------------------------------------
    /**
     * Tests key().
     */
    public void testKey()
    {
        assertTrue(testKVPair1.key() == 1);
        assertTrue(testKVPair2.key() == 2);
        assertTrue(testKVPair3.key() == 1);
    }


    // ----------------------------------------------------------
    /**
     * Tests value().
     */
    public void testValue()
    {
        assertEquals("One", testKVPair1.value());
        assertEquals("Two", testKVPair2.value());
        assertEquals("Three", testKVPair3.value());
    }
}
