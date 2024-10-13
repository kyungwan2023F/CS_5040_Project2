public class Controller {
    // ~ Fields ................................................................
    private BST<Integer, Seminar> idBST;
    private BST<String, Seminar> dateBST;
    private BST<Integer, Seminar> costBST;
    private BST<String, Seminar> keywordBST;

    public Controller() {
        idBST = new BST<>();
        dateBST = new BST<>();
        costBST = new BST<>();
        keywordBST = new BST<>();
    }


    // ~Public Methods ........................................................
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * 
     * @param id
     * @param title
     * @param date
     * @param length
     * @param x
     * @param y
     * @param cost
     * @param keywords
     * @param description
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
        String description) {
        if (idBST.find(id) != null) {
            System.out.println(
                "Insert FAILED - There is already a record with ID " + id);
            return;
        }

        Seminar seminar = new Seminar(id, title, date, length, x, y, cost,
            keywords, description);

        KVPair<Integer, Seminar> idPair = new KVPair<>(id, seminar);
        KVPair<String, Seminar> datePair = new KVPair<>(date, seminar);
        KVPair<Integer, Seminar> costPair = new KVPair<>(cost, seminar);

        idBST.insert(idPair);
        dateBST.insert(datePair);
        costBST.insert(costPair);

        for (String keyword : keywords) {
            KVPair<String, Seminar> keywordPair = new KVPair<>(keyword,
                seminar);
            keywordBST.insert(keywordPair);
        }

        System.out.println("Successfully inserted record with ID " + id);
        System.out.println(seminar.toString());
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * 
     * 
     * @param id
     */
    public void searchById(int id) {
        KVPair<Integer, Seminar> result = idBST.find(id);
        if (result != null) {
            Seminar seminar = result.value();
            System.out.println("Found record with ID " + id + ":");
            System.out.println(seminar.toString());
        }
        else {
            System.out.println("Search FAILED -- There is no record with ID "
                + id);
        }
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * 
     * @param keyword
     */
    public void searchByKeyword(String keyword) {
        System.out.println("Seminars matching keyword " + keyword + ":");
        keywordBST.findRange(keyword, keyword);
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * 
     * @param low
     * @param high
     */
    public void searchByCost(int low, int high) {
        System.out.println("Seminars with costs in range " + low + " to " + high
            + ":");
        int result = costBST.findRange(low, high);

        System.out.println(result + " nodes visited in this search");
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * 
     * @param low
     * @param high
     */
    public void searchByDate(String low, String high) {
        System.out.println("Seminars with dates in range " + low + " to " + high
            + ":");

        int result = dateBST.findRange(low, high);

        System.out.println(result + " nodes visited in this search");
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here
     * 
     * 
     * @param x
     * @param y
     * @param radius
     */
    public void searchByLocation(short x, short y, int radius) {
        return;
    }


    public void delete(int id) {
        KVPair<Integer, Seminar> idPair = idBST.find(id);

        if (idPair == null) {
            System.out.println("Delete FAILED -- There is no record with ID "
                + id);
            return;
        }
        Seminar currentIDSeminar = idPair.value();
        idBST.root = idBST.remove(idPair);

        KVPair<String, Seminar> datePair = new KVPair<>(currentIDSeminar.date(),
            currentIDSeminar);
        dateBST.root = dateBST.remove(datePair);

        KVPair<Integer, Seminar> costPair = new KVPair<>(currentIDSeminar
            .cost(), currentIDSeminar);
        costBST.root = costBST.remove(costPair);

        for (String keyword : currentIDSeminar.keywords()) {
            KVPair<String, Seminar> keywordPair = new KVPair<>(keyword,
                currentIDSeminar);
            keywordBST.root = keywordBST.remove(keywordPair);
        }

        System.out.println("Record with ID " + id
            + " successfully deleted from the database");
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * 
     * @return
     */
    public BST<Integer, Seminar> getCostTree() {
        return costBST;
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * 
     * @return
     */
    public BST<String, Seminar> getDateTree() {
        return dateBST;
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * 
     * @return
     */
    public BST<String, Seminar> getKeywordTree() {
        return keywordBST;
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your meth
     * d here.
     * 
     * @return
     */
    public BST<Integer, Seminar> getIdTree() {
        return idBST;
    }

}
