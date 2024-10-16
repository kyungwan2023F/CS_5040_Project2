public class BinTreeRun {

    public static void main(String[] args) {
        int worldSizeX = 128;
        int worldSizeY = 128;

        BinTree tree = new BinTree(worldSizeX, worldSizeY);

        Seminar seminar1 = new Seminar(1, "A", "0610051600", 90,
            (short)10, (short)10, 100, new String[] { "CS" }, "CS Seminar");
        Seminar seminar2 = new Seminar(2, "C", "0610051600", 60,
            (short)10, (short)10, 200, new String[] { "Math" },
            "Math Seminar");
        Seminar seminar3 = new Seminar(10, "D", "0610051600", 120,
            (short)30, (short)10, 300, new String[] { "Physics" },
            "Physics Seminar");
        Seminar seminar4 = new Seminar(3, "D", "0610051600", 120,
            (short)0, (short)0, 300, new String[] { "Physics" },
            "Physics Seminar");
        
        tree.insert(seminar1.x(), seminar1.y(), seminar1);  
        tree.insert(seminar2.x(), seminar2.y(), seminar2);
        tree.insert(seminar3.x(), seminar3.y(), seminar3);  
        tree.insert(seminar4.x(), seminar4.y(), seminar4);  
        tree.print();
        tree.delete(10, 10, 1);
        tree.delete(10, 10, 2);
        tree.search(11, 11, 0);
        tree.search(10, 10, 20);
        
        tree.print();
    }
    // ~ Fields ................................................................

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................

}
