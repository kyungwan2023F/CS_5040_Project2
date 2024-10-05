import student.TestCase;

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
    // ~Public Methods ........................................................
    public void testCompareToKVPair() {
        assertTrue(testKVPair1.compareTo(testKVPair2) < 0);  
        assertTrue(testKVPair2.compareTo(testKVPair1) > 0);  
        assertEquals(0, testKVPair1.compareTo(testKVPair3));
    }
    
    public void testCompareToKey() {
        assertTrue(testKVPair1.compareTo(2) < 0);  
        assertTrue(testKVPair2.compareTo(1) > 0);
        assertTrue(testKVPair3.compareTo(1) == 0); 
    }
    
    public void testCompareToNullValue() {
        KVPair<Integer, String> testKVPair4 = new KVPair<>(3, null);
        KVPair<Integer, String> testKVPair5 = new KVPair<>(3, "Three");
        assertEquals(0, testKVPair4.compareTo(testKVPair5));
    }
    
    public void testCompareToNullKey() {
        KVPair<Integer, String> testKVPair6 = new KVPair<>(null, "Null");
        // Expect NullPointerException when comparing null key
        Exception exception = null;
        try {
            testKVPair6.compareTo(1);
        } catch (NullPointerException e) {
            exception = e;
        }
        assertNotNull(exception);
    }
    
    public void testNullKVPair() {
        KVPair<Integer, String> testKVPair7 = new KVPair<>(null, null);
        assertNull(testKVPair7.key());
        assertNull(testKVPair7.value());
    }
    
    
    public void testKey() {
        assertTrue(testKVPair1.key() == 1);
        assertTrue(testKVPair2.key() == 2);
        assertTrue(testKVPair3.key() == 1);
    }

    
    public void testValue() {
        assertEquals("One", testKVPair1.value());
        assertEquals("Two", testKVPair2.value());
        assertEquals("Three", testKVPair3.value());
    }
}
