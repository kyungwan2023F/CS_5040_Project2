import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * The CommandProcessor class processes commands read from an input file,
 * executing operations on the provided Controller object such as insert,
 * search, delete, and print operations on Seminar records.
 * 
 * @author Kyungwan Do, Jaeyoung Shin
 * @version 10/18/2024
 */
public class CommandProcessor
{
    /**
     * The controller that manages the operations on Seminar records.
     */
    private Controller controller;

    // ----------------------------------------------------------
    /**
     * Create a new CommandProcessor object.
     * 
     * @param controller
     *            controller
     */
    public CommandProcessor(Controller controller)
    {
        this.controller = controller;
    }


    // ----------------------------------------------------------
    /**
     * Reads and processes commands from the specified file line by line,
     * executing actions such as insert, search, delete, and print based on the
     * input commands.
     * 
     * @param filename
     *            string
     */
    public void beginParsingByLine(String filename)
    {
        try
        {
            Scanner sc = new Scanner(new File(filename));
            while (sc.hasNextLine())
            {
                String line = sc.nextLine();

                if (line.isEmpty())
                {
                    continue;
                }

                Scanner scancmd = new Scanner(line);
                if (!scancmd.hasNext())
                {
                    scancmd.close();
                    continue;
                }

                String cmd = scancmd.next().trim();

                switch (cmd)
                {
                    case "insert":
                        int id = Integer.parseInt(scancmd.next().trim());
                        String title = sc.nextLine().trim();
                        String dateLine = sc.nextLine().trim();
                        String keywordsLine = sc.nextLine().trim();
                        String description = sc.nextLine().trim();

                        Scanner detailScanner = new Scanner(dateLine);
                        String dateTime = detailScanner.next();
                        int length = Integer.parseInt(detailScanner.next());
                        Short x = Short.parseShort(detailScanner.next());
                        Short y = Short.parseShort(detailScanner.next());
                        int cost = Integer.parseInt(detailScanner.next());

                        detailScanner.close();

                        ArrayList<String> keywordsList = new ArrayList<>();
                        Scanner keywordScanner = new Scanner(keywordsLine);
                        while (keywordScanner.hasNext())
                        {
                            String keyword = keywordScanner.next().trim();
                            if (!keyword.isEmpty())
                            {
                                keywordsList.add(keyword); // Add each keyword
                            }
                        }
                        keywordScanner.close();

                        String[] keywordsArray =
                            keywordsList.toArray(new String[0]);

                        controller.insert(
                            id,
                            title,
                            dateTime,
                            length,
                            x,
                            y,
                            cost,
                            keywordsArray,
                            description);
                        break;
                    case "search":
                        String type = scancmd.next().trim();

                        switch (type)
                        {
                            case "ID":
                                int key =
                                    Integer.parseInt(scancmd.next().trim());
                                controller.searchById(key);
                                break;
                            case "keyword":
                                String keyword = scancmd.next().trim();
                                controller.searchByKeyword(keyword);
                                break;
                            case "cost":
                                int min =
                                    Integer.parseInt(scancmd.next().trim());
                                int max =
                                    Integer.parseInt(scancmd.next().trim());

                                controller.searchByCost(min, max);
                                break;
                            case "date":
                                String low = scancmd.next().trim();
                                String high = scancmd.next().trim();
                                controller.searchByDate(low, high);
                                break;
                            case "location":
                                Short xLocation =
                                    Short.parseShort(scancmd.next().trim());
                                Short yLocation =
                                    Short.parseShort(scancmd.next().trim());

                                int radius = 0;
                                if (scancmd.hasNext())
                                {
                                    radius =
                                        Integer.parseInt(scancmd.next().trim());
                                }
                                controller.searchByLocation(
                                    xLocation,
                                    yLocation,
                                    radius);
                                break;
                            default:
                                break;
                        }
                        break;
                    case "delete":
                        id = Integer.parseInt(scancmd.next().trim());
                        controller.delete(id);
                        break;
                    case "print":
                        String printType = scancmd.next().trim();
                        switch (printType)
                        {
                            case "ID":
                                System.out.println("ID Tree:");
                                controller.getIdTree().printTree();
                                break;
                            case "keyword":
                                System.out.println("Keyword Tree:");
                                controller.getKeywordTree().printTree();
                                break;
                            case "cost":
                                System.out.println("Cost Tree:");
                                controller.getCostTree().printTree();
                                break;
                            case "date":
                                System.out.println("Date Tree:");
                                controller.getDateTree().printTree();
                                break;
                            case "location":
                                controller.getBinTree().print();
                                break;
                            default:
                                break;
                        }
                        break;

                    default:
                        break;
                }
                scancmd.close();
            }
            sc.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
