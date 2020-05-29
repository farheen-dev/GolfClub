// importing the util library package
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GolfClub{
    //using Hashmap to map the entering golfers name and result they scored
    private static Map<String, Integer> golfer = new HashMap<String, Integer>();
    //using Hashmap to enter the deleted golfers records
    private static Map<String, Integer> restoreRecord= new HashMap<String, Integer>();
    //Taking the input by system
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        //Displaying the welcome message
        System.out.println("Welcome to Springfield Golf Club.");
        // Initializing the option variable
        int option = 0;

        //using while loop until the user enter 4 for the option
        while (option != 4) {

            do {
                // Displaying the main menu
                displayMainMenu();


                // User input validation
                while (!input.hasNextInt()) {
                    System.out.println("Invalid option entered \n");
                    // Displaying the main menu again
                    displayMainMenu();
                    input.next();//remove the none integer that was previously entered
                    // this is a must otherwise the program will loop through infinitely

                }
                // getting the input from the system and assigning it to a variable named option
                option = input.nextInt();

                //Using switch-case for the option 1,2,3,4
                switch (option)
                {
                    case 1:
                        // Calling the enterScore()method created
                        enterScore();
                        break;
                    case 2:
                        // Calling the findGolfer() method created
                        findGolfer();
                        break;
                    case 3:
                        // Calling the displayScoreboard() method created
                        displayScoreboard();
                        break;
                    case 4:
                        System.out.println("Exiting the program");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("The option entered should be in the 1-4 \n");
                }
            } while (option < 1 || option > 4);
        }
    }

    // Creating method for option 1 process
    private static void enterScore()
    {
        // Initializing the choice variable
        int choice=0;
        //using while loop until the user enter 4 for the choice
        while (choice !=5){
            do{
                // Displaying the sub menu
                displaySubMenu();
                // User input validation
                while (!input.hasNextInt()) {
                    System.out.println("Invalid choice entered \n");
                    // Displaying the sub menu again
                    displaySubMenu();
                    input.next();//remove the none integer that was previously entered
                    // this is a must otherwise the program will loop through infinitely
                }

                // getting the input from the system and assigning it to a variable named choice
                choice = input.nextInt();

                //Using switch-case for the choice 1,2,3,4
                switch (choice)
                {
                    case 1:
                        // Calling the playerDetails()method created
                        playerDetails();
                        break;
                    case 2:
                        // Calling the editData() method created
                        editData();
                        break;
                    case 3:
                        // Calling the deleteData() method created
                        deleteData();
                        break;
                    case 4:
                        // Calling the restoreData() method created
                        restoreData();
                        break;
                    case 5:
                        System.out.println("Exiting");
                        return;
                    default:
                        System.out.println("The choice entered should be in the 1-5 \n");
                }
            }while (choice < 1 || choice > 5);
        }
    }

    // Creating method for option 2 process
    private static void findGolfer()
    {
        //Declaring variables found_results and find_golfer
        int found_result;
        String find_golfer;
        System.out.print("Enter the name of the golfer to find:");
        input.nextLine();
        find_golfer = input.nextLine();
        if (golfer.containsKey(find_golfer)) {//searching if the golfer entered by user is in the golfer Hashmap
            found_result = golfer.get(find_golfer);
            System.out.println("The result of " + find_golfer + " is " + found_result + "\n");
        } else {// If the searched  golfer is not in the hashmap golfer
            System.out.println("There is no golfer found in that name");
        }
    }

    // Creating method for option 3 process
    private static void displayScoreboard()
    {
        System.out.println("\nSCORE-BOARD");
        //using linkedlist
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(golfer.entrySet());
        //sort for key
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Map.Entry<String, Integer> item : list) {
            System.out.println(item.getKey()+"-"+item.getValue());
        }
    }

    // Creating method for display main menu
    private static void displayMainMenu()
    {
        System.out.println("\n Select Option:");
        System.out.println("1)	Enter Scores");
        System.out.println("2)	Find Golfer");
        System.out.println("3)	Display Scoreboard");
        System.out.println("4)	Exit Program");
        System.out.println(">");
        System.out.print("Enter an option:");

    }

    // Creating method for display sub menu
    private static void displaySubMenu()
    {
        System.out.println("\n Select a choice");
        System.out.println("1) enter player details");
        System.out.println("2) edit data");
        System.out.println("3) delete data");
        System.out.println("4) restore data");
        System.out.println("5) exit");
        System.out.println(">");
        System.out.print("Enter a choice:");
    }

    // Creating method for choice 1 under enterscore method
    private static void playerDetails()
    {
        // Declaring variable no_of_golfers,results,name and reply
        int no_of_golfers;
        int results;
        String name;
        String reply ="";

        System.out.print("Enter how many golfers in the group:");
        // User input validation
        while (!input.hasNextInt()) {
            System.out.println("Invalid value entered");
            System.out.print("Enter how many golfers in the group:");
            input.next();
        }
        //getting the input from the system and assigning it to a variable named no_of_golfers
        no_of_golfers = input.nextInt();

        System.out.println("Enter the details of golfers in following space provide\n");
        for (int i = 0; i < no_of_golfers; i++) {
            // Displaying user to enter the golfers names
            System.out.print("Enter the name:");
            input.nextLine();
            //getting the input from the system and assigning it to a variable named name
            name = input.nextLine();

            // see if the user entering a already existing name and giving the chance to altering the results or not
            if (golfer.containsKey(name))
            {
                System.out.println("This name is already existing,the result will be altered");
                System.out.println("Do you want to change the results or not?");
                System.out.print("If you want to change enter y or any key and if not press n:");
                reply =input.nextLine().toLowerCase();
                if(reply.equals("n"))
                {
                    do{
                        System.out.print("Enter the name:");
                        name = input.nextLine();
                        if(golfer.containsKey(name))
                        {
                            System.out.println("This name is already existing");
                        }
                    }while (golfer.containsKey(name));
                }
            }

            // User input validation
            System.out.print("Enter the results:");
            while (!input.hasNextInt())
            {
                System.out.println("result should be a number");
                System.out.print("Enter the results:");
                input.next();
            }
            // getting the input from the system and assigning it to a variable named results
            results = input.nextInt();
            do {
                if (results >= 18 && results <= 108) {
                    // appending the results taken from the system to golfer Hashmap made before
                    golfer.put(name, results);

                } else {
                    System.out.println("The result entered should be in the range of 18-108");
                    System.out.print("Enter the results:");
                    //user input validation
                    while (!input.hasNextInt()) {
                        System.out.println("result should be a number");
                        System.out.print("Enter the results:");
                        input.next();
                    }
                    results = input.nextInt();

                    if (results >= 18 && results <= 108) {
                        golfer.put(name, results);
                    }
                }
            } while (!(results >= 18 && results <= 108));
        }
    }

    // Creating method for choice 2 under enterscore method
    private static void editData()
    {
        // Declaring variable answer
        String answer="";
        //displaying the record before editing
        displayRecord();
        System.out.print("Do you want to edit data? if so enter 'y' else not enter 'any key':");
        input.nextLine();
        answer = input.nextLine();
        answer.toLowerCase();
        if (answer.equals("y"))
        {
            playerDetails();
            //displaying the edited new record
            displayRecord();
        }
    }

    // Creating method for choice 3 under enterscore method
    private static void deleteData()
    {
        // Declaring variable removePlayer
        String removePlayer;
        //displaying records before deleting
        displayRecord();
        System.out.print("Enter a name of the golfer to remove:");
        input.nextLine();
        removePlayer = input.nextLine();
        if(golfer.containsKey(removePlayer)) {
            // adding removing payers record to another hashmap named restoreRecord
            restoreRecord.put(removePlayer,golfer.get(removePlayer));
            //removing records of the given name entered by user to remove record
            golfer.remove(removePlayer);
            //displaying records after deleting
            displayRecord();
        }else {// If the searched  golfer to remove is not in the hashmap golfer
            System.out.println("There is no golfer in that name");
        }
    }

    // Creating method for choice 4 under enterscore method
    private static void restoreData()
    {
        String restoreName;
        //displaying records before restoring
        displayRecord();
        System.out.print("Enter the name to restore:");
        input.nextLine();
        restoreName = input.nextLine();
        if (restoreRecord.containsKey(restoreName))
        {
            // adding the golfer in the restoreRecord hashmap to the golfer hashmap
            golfer.put(restoreName,restoreRecord.get(restoreName));
            //displaying records after restoring
            displayRecord();

        }else{
            System.out.println("There is no golfer in that name to restore");
        }
    }

    // Creating method for display records entered
    private static void displayRecord()
    {
        for (String key : golfer.keySet())
        {
            System.out.println(key + " - " + golfer.get(key));
        }
    }


}





