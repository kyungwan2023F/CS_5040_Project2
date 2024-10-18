/**
 * The Controller class is responsible for managing the insertion, deletion, and
 * searching of Seminar records using various Binary Search Trees (BSTs) for
 * IDs, dates, costs, keywords, and a BinTree for spatial data.
 * 
 * @author Kyungwan Do, Jaeyoung Shin
 * @version 10/18/2024
 */
public class Controller
{
    // ~ Fields ................................................................
    private BST<Integer, Seminar> idBST;
    private BST<String, Seminar> dateBST;
    private BST<Integer, Seminar> costBST;
    private BST<String, Seminar> keywordBST;
    private BinTree binTree;
    private int worldSize;

    // ----------------------------------------------------------
    /**
     * Create a new Controller object.
     * 
     * @param worldSize
     *            int
     */
    public Controller(int worldSize)
    {
        this.worldSize = worldSize;
        idBST = new BST<>();
        dateBST = new BST<>();
        costBST = new BST<>();
        keywordBST = new BST<>();
        binTree = new BinTree(worldSize, worldSize);
    }


    // ~Public Methods ........................................................
    // ----------------------------------------------------------
    /**
     * Inserts a new Seminar record into the BSTs and BinTree.
     * 
     * @param id
     *            string
     * @param title
     *            string
     * @param date
     *            string
     * @param length
     *            int
     * @param x
     *            int
     * @param y
     *            int
     * @param cost
     *            int
     * @param keywords
     *            string
     * @param description
     *            string
     */
    public void insert(
        int id,
        String title,
        String date,
        int length,
        short x,
        short y,
        int cost,
        String[] keywords,
        String description)
    {
        if (idBST.find(id) != null)
        {
            System.out.println(
                "Insert FAILED - There is already a record with ID " + id);
            return;
        }
        if (x < 0 || y < 0 || x >= worldSize || y >= worldSize)
        {
            System.out.println(
                "Insert FAILED - Bad x, y coordinates: " + x + ", " + y);
            return;
        }
        Seminar seminar = new Seminar(
            id,
            title,
            date,
            length,
            x,
            y,
            cost,
            keywords,
            description);

        KVPair<Integer, Seminar> idPair = new KVPair<>(id, seminar);
        KVPair<String, Seminar> datePair = new KVPair<>(date, seminar);
        KVPair<Integer, Seminar> costPair = new KVPair<>(cost, seminar);

        idBST.insert(idPair);
        dateBST.insert(datePair);
        costBST.insert(costPair);
        binTree.insert(seminar.x(), seminar.y(), seminar);

        for (String keyword : keywords)
        {
            KVPair<String, Seminar> keywordPair =
                new KVPair<>(keyword, seminar);
            keywordBST.insert(keywordPair);
        }

        System.out.println("Successfully inserted record with ID " + id);
        System.out.println(seminar.toString());
    }


    // ----------------------------------------------------------
    /**
     * Searches for a Seminar record by ID and prints the result.
     * 
     * @param id
     *            int
     */
    public void searchById(int id)
    {
        KVPair<Integer, Seminar> result = idBST.find(id);
        if (result != null)
        {
            Seminar seminar = result.value();
            System.out.println("Found record with ID " + id + ":");
            System.out.println(seminar.toString());
        }
        else
        {
            System.out
                .println("Search FAILED -- There is no record with ID " + id);
        }
    }


    // ----------------------------------------------------------
    /**
     * Searches for Seminar records that match a specific keyword and prints the
     * results.
     * 
     * @param keyword
     *            string
     */
    public void searchByKeyword(String keyword)
    {
        System.out.println("Seminars matching keyword " + keyword + ":");
        keywordBST.findRange(keyword, keyword);
    }


    // ----------------------------------------------------------
    /**
     * Searches for Seminar records within a given cost range and prints the
     * results.
     * 
     * @param low
     *            int
     * @param high
     *            int
     */
    public void searchByCost(int low, int high)
    {
        System.out.println(
            "Seminars with costs in range " + low + " to " + high + ":");
        int result = costBST.findRange(low, high);

        System.out.println(result + " nodes visited in this search");
    }


    // ----------------------------------------------------------
    /**
     * Searches for Seminar records within a given date range and prints the
     * results.
     * 
     * @param low
     *            string
     * @param high
     *            string
     */
    public void searchByDate(String low, String high)
    {
        System.out.println(
            "Seminars with dates in range " + low + " to " + high + ":");

        int result = dateBST.findRange(low, high);

        System.out.println(result + " nodes visited in this search");
    }


    // ----------------------------------------------------------
    /**
     * Searches for Seminar records based on location and radius, printing the
     * number of nodes visited
     * 
     * @param x
     *            short
     * @param y
     *            short
     * @param radius
     *            int
     */
    public void searchByLocation(short x, short y, int radius)
    {
        int result = binTree.search(x, y, radius);
        System.out.println(result + " nodes visited in this search");
    }


    // ----------------------------------------------------------
    /**
     * Deletes a Seminar record by ID from the BSTs and BinTree.
     * 
     * @param id
     *            int
     */
    public void delete(int id)
    {
        KVPair<Integer, Seminar> idPair = idBST.find(id);

        if (idPair == null)
        {
            System.out
                .println("Delete FAILED -- There is no record with ID " + id);
            return;
        }
        Seminar currentIDSeminar = idPair.value();
        idBST.remove(idPair);

        KVPair<String, Seminar> datePair =
            new KVPair<>(currentIDSeminar.date(), currentIDSeminar);
        dateBST.remove(datePair);

        KVPair<Integer, Seminar> costPair =
            new KVPair<>(currentIDSeminar.cost(), currentIDSeminar);
        costBST.remove(costPair);

        for (String keyword : currentIDSeminar.keywords())
        {
            KVPair<String, Seminar> keywordPair =
                new KVPair<>(keyword, currentIDSeminar);
            keywordBST.remove(keywordPair);
        }

        binTree.delete(idPair.value().x(), idPair.value().y(), id);

        System.out.println(
            "Record with ID " + id + " successfully deleted from the database");
    }


    // ----------------------------------------------------------
    /**
     * Retrieves the Binary Search Tree (BST) of Seminar costs.
     * 
     * @return cost
     */
    public BST<Integer, Seminar> getCostTree()
    {
        return costBST;
    }


    // ----------------------------------------------------------
    /**
     * Returns date.
     * 
     * @return date
     */
    public BST<String, Seminar> getDateTree()
    {
        return dateBST;
    }


    // ----------------------------------------------------------
    /**
     * returns keyword.
     * 
     * @return keyword
     */
    public BST<String, Seminar> getKeywordTree()
    {
        return keywordBST;
    }


    // ----------------------------------------------------------
    /**
     * Returns id.
     * 
     * @return id
     */
    public BST<Integer, Seminar> getIdTree()
    {
        return idBST;
    }


    // ----------------------------------------------------------
    /**
     * Returns binTree.
     * 
     * @return binTree
     */
    public BinTree getBinTree()
    {
        return binTree;
    }

}
