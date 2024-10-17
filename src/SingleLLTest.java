import student.TestCase;

public class SingleLLTest
    extends TestCase
{
    // ~ Fields ................................................................
    private SingleLL testList;
    private Seminar testSeminar1;
    private Seminar testSeminar2;
    private Seminar testSeminar3;

    // ~ Constructors ..........................................................
    public void setUp()
    {
        testList = new SingleLL();
        String[] keywords1 = { "A", "a" };
        String[] keywords2 = { "B", "b" };
        String[] keywords3 = { "C", "c" };

        testSeminar1 = new Seminar(
            101,
            "Seminar A",
            "20231001",
            90,
            (short)10,
            (short)20,
            100,
            keywords1,
            "AAAaaa");
        testSeminar2 = new Seminar(
            102,
            "Seminar B",
            "20231002",
            120,
            (short)30,
            (short)40,
            150,
            keywords2,
            "BBBbbb");
        testSeminar3 = new Seminar(
            103,
            "Seminar C",
            "20231003",
            150,
            (short)50,
            (short)60,
            200,
            keywords3,
            "CCCccc");
    }


    // ~Public Methods ........................................................
    public void testAdd()
    {
        testList.add(testSeminar1);
        testList.add(testSeminar2);
        testList.add(testSeminar3);
        assertEquals(3, testList.size());
        assertFalse(testList.isEmpty());
        assertEquals(testSeminar1, testList.get(0));
        assertEquals(testSeminar2, testList.get(1));
        assertEquals(testSeminar3, testList.get(2));
    }


    public void testAddNull()
    {
        Exception exception = null;
        try
        {
            testList.add(null);
        }
        catch (IllegalArgumentException e)
        {
            exception = e;
        }
        assertNotNull(exception);
    }


    public void testRemove()
    {
        testList.add(testSeminar1);
        testList.add(testSeminar2);
        testList.add(testSeminar3);
        assertEquals(3, testList.size());
        testList.remove(0);
        assertEquals(2, testList.size());
        assertEquals(testSeminar2, testList.get(0));
        testList.remove(0);
        assertEquals(1, testList.size());
        assertEquals(testSeminar3, testList.get(0));
        testList.remove(0);
        assertTrue(testList.isEmpty());
    }


    public void testRemoveInvalid()
    {
        testList.add(testSeminar1);
        testList.add(testSeminar2);
        testList.add(testSeminar3);

        Exception exception = null;
        try
        {
            testList.remove(-1); // Invalid index
        }
        catch (IndexOutOfBoundsException e)
        {
            exception = e;
        }
        assertNotNull(exception);

        exception = null;
        try
        {
            testList.remove(3); // Invalid index (greater than size)
        }
        catch (IndexOutOfBoundsException e)
        {
            exception = e;
        }
        assertNotNull(exception);
    }


    public void testGet()
    {
        testList.add(testSeminar1);
        testList.add(testSeminar2);
        testList.add(testSeminar3);
        assertEquals(testSeminar1, testList.get(0));
        assertEquals(testSeminar2, testList.get(1));
        assertEquals(testSeminar3, testList.get(2));
        
        Exception exception = null;
        try {
            testList.get(3);
        } catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertNotNull(exception);
    }

}
