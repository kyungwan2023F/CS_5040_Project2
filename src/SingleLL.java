public class SingleLL {
    // ~ Fields ................................................................
    private Node head;

    // the size of the linked list
    private int size;

    public static class Node {

        // The Seminar object stored in the node.
        private Seminar seminar;

        // The next node in the sequence.
        private Node next;

        /**
         * Creates a new node with the given data (Seminar)
         *
         * @param seminar
         *            the seminar to put inside the node
         */
        public Node(Seminar seminar) {
            this.seminar = seminar;
        }


        /**
         * Sets the node after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNext(Node n) {
            next = n;
        }


        /**
         * Gets the next node
         *
         * @return the next node
         */
        public Node next() {
            return next;
        }


        /**
         * Gets the seminar object in the node
         *
         * @return the seminar in the node
         */
        public Seminar getSeminar() {
            return seminar;
        }
    }

    // ~ Constructors ..........................................................
    /**
     * Creates a new LinkedList object
     */
    public SingleLL() {
        head = null;
        size = 0;
    }


    // ~Public Methods ........................................................
    // ----------------------------------------------------------
    /**
     * Returns the size of the list.
     * 
     * @return the number of elements in the list
     */
    public int size() {
        return size;
    }


    /**
     * Adds the seminar to the end of the list.
     *
     * @precondition seminar cannot be null
     * @param seminar
     *            the seminar to add
     * @throws IllegalArgumentException
     *             if seminar is null
     */
    public void add(Seminar seminar) {
        // check if the seminar is null
        if (seminar == null) {
            throw new IllegalArgumentException("Seminar is null");
        }

        Node newNode = new Node(seminar);
        Node current = head;
        Node previous = null;

        // empty case
        if (isEmpty()) {
            head = new Node(seminar);
        }

        // other cases
        else {
            while (current != null && current.seminar.id() < seminar.id()) {
                previous = current;
                current = current.next;
            }

            // Case: insert at the head (new seminar has smallest id)
            if (previous == null) {
                newNode.setNext(head);
                head = newNode;
            }
            // General case: insert between `previous` and `current`
            else {
                previous.setNext(newNode);
                newNode.setNext(current);
            }
        }
        size++;
    }


    /**
     * Checks if the list is empty
     *
     * @return true if the list is empty
     */
    public boolean isEmpty() {
        return (size == 0);
    }


    /**
     * Removes the seminar at the given position.
     *
     * @param index
     *            the position of the seminar to remove.
     * @return true if the removal was successful.
     * @throws IndexOutOfBoundsException
     *             if the index is out of bounds.
     */
    public boolean remove(int index) {
        // if the index is invalid or the list is empty
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        // Case: Removing the head (first node)
        if (index == 0) {
            head = head.next(); // Move head to the next node
            size--;
            return true;
        }

        // General case: Removing from middle or end of the list
        Node current = head;
        Node previous = null;
        int currentIndex = 0;

        // Traverse to the node just before the one we want to remove
        while (current != null && currentIndex < index) {
            previous = current;
            current = current.next();
            currentIndex++;
        }

        // Adjust the next pointer of the previous node to skip the removed node
        if (previous != null && current != null) {
            previous.setNext(current.next()); // Bypass the current node
            size--;
            return true;
        }

        // If the node was never found, throw an exception (this should not
        // occur if index bounds are handled)
        throw new IndexOutOfBoundsException("Index is out of bounds");
    }


    /**
     * Gets the seminar at the given position
     *
     * @param index
     *            where the seminar is located
     * @return The seminar at the given position
     * @throws IndexOutOfBoundsException
     *             if no node at the given index
     */
    public Seminar get(int index) {
        Node current = head;
        int currentIndex = 0;
        Seminar seminar = null;
        while (current != null) {
            if (currentIndex == index) {
                seminar = current.seminar;
            }
            currentIndex++;
            current = current.next;
        }
        // check if the seminar was null...
        if (seminar == null) {
            // ... if so throw an exception
            throw new IndexOutOfBoundsException("Index exceeds the size.");
        }
        return seminar;
    }
}
