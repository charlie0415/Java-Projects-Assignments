// I am trying to create the Library system from scratch again using textio
// I will create a class, method and object constructor
// Then use arraylist to store the objects
import java.util.ArrayList;
import java.util.Scanner;
import textio.TextIO;
class Book {
    String author, title;
    int quantity;
    // Creating object constructor
    Book(String title, String author, int quantity){
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    // Creating a quantity increasing method
    void increaseBook(int amount){
        amount += amount;
    }
    // Quantity reducing method
    void reduceBook(int amount){
        amount -= amount;
    }
}
public class libSystem {

    // Creating an arraylist to hold the book objects users will be creating
    static ArrayList<Book> library = new ArrayList<>();
    // Textio has been frustrating and misbehaving
    static Scanner scanner = new Scanner(System.in); 
   
    public static void main(String[] args){
        while (true) {
            System.out.println("Welcome to the Libray");
            System.out.println("Please Enter from any number from the Options below:");
            System.out.println("1.Add Books");
            System.out.println("2.Borrow Books");
            System.out.println("3.Return Books");
            System.out.println("4.Exit");
            int choice = getValidInput();;

            //Error and function handling for parent entry
            switch (choice) {
                case 1:
                    addBooks();
                    break;
                case 2:
                    borrowBooks();
                    break;
                case 3:
                    // returnBooks();
                    break;
                case 4:
                    System.out.println("You are now Exiting the Library. Thanks for your time.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        } //While loop end here
    } // main ends here

    public static void addBooks(){
        boolean add = true;
        while (add == true) {
            System.out.println("Enter inorder separated by comma: Title, Author, Quantity");
            String userInput = scanner.nextLine();

            // Splitting input to an array
            String[] inputDetails = userInput.split("\\s*,\\s*");

            // Checking if userinput is three
            if (inputDetails.length != 3) {
                System.out.println("Error: Ensure you've entered three inputs separated by Comma");
                return;
            }

            String title = inputDetails[0];
            String author = inputDetails[1];
            int quantity;

            // Catching the error for the number
            try {
                quantity = Integer.parseInt(inputDetails[2]);
            } catch (NumberFormatException e) {
                System.out.println("Error: Enter Quantity in integer");
                return;
            }

            // Updating/ Adding the book array
            for (Book book : library){
                if(book.title.equalsIgnoreCase(title)){
                    book.increaseBook(quantity);
                    System.out.println("Book has been successfully added!");
                    return;
                }
            }

            library.add(new Book(title, author, quantity));
            System.out.println("Do you Wish to Add More Books");
            System.out.println("Enter y for Yes or n for No:");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("y")) {
                continue;
            }
            else if (response.equalsIgnoreCase("n")) {
                System.out.println("Book has been successfully added!");
                add= false;
            }
            else {
                System.out.println("Error: Invalid Input");
                return;  
            }
        } // Loop stops here
            
    } //Add books end here

    // Borrow books function
    public static void borrowBooks(){
        boolean repeat = true;
        while (repeat == true) {
            System.out.println("Enter the Title and Quantity of book separated by comma");
            // Split user input
            String[] splittedInput = scanner.nextLine().split("\\s*,\\s*");
            // Check if Input is correct
            if (splittedInput.length !=2 ) {
                System.out.println("Error: Ensure you've entered two values");
                return;
            }
            // Parse and assign the input
            String title = splittedInput[0];
            int quantity;

            // Error handling for quantity
            try {
                quantity = Integer.parseInt(splittedInput[1]);
            } catch (NumberFormatException e) {
                System.out.println("Error: Second value is not a number");
                return;
            }

            // Checking if borrowed quantity isnt more than registered quantity


            // Reducing book quantity
            boolean availBook = false;
            for (Book book : library) {
                if (book.title.equalsIgnoreCase(title)) {
                    if (quantity >0 && quantity <= book.quantity) {
                        book.reduceBook(quantity);
                    } else {
                        System.out.println("Error: The quantity you provided is more than we have.");
                    }
                    availBook = true;
                    break;
                }
            }

            // Handle that of false for optimization
            if (availBook == false) {
                System.out.println("Requested Book is not Available in Library");
            }

            // which to borrow book again
            System.out.println("Do you which you borrow again");
            System.out.println("Enter 'y' for Yes and 'n' for No:");
            char input = TextIO.getChar();

            if (Character.toString(input).equalsIgnoreCase("y")) {
                continue;
            } else {
                repeat = false;
            }
        }
    } // Borrow ends here

    // Private Starts here
    private static int getValidInput(){
        while (true) {
            try {
               return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid input");
            }
        }
    }
}