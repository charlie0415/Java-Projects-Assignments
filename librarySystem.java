// Using a while true loop all parent menu/option should be displyed
// Create class and object contructor for user's entry
// Create Methods to work with options displayed
// Access the array, update it, and update length
// Implement Error handling and test
// Peruse and if possible re-write in most effifcient way
import textio.TextIO;
public class librarySystem {
    String title, author;
    int quantity;

    librarySystem(String bookTitle, String bookAuthor, int bookQuantity){
        title = bookTitle;
        author = bookAuthor;
        quantity = bookQuantity;
    }

    static librarySystem[] books = new librarySystem[3];

    void updateQuantity(int bookQuantity){

    }

   public static void main(String[] args) {
    books[0] = new librarySystem("Wife", "Arnold", 4);
    books[1] = new librarySystem("Husband", "Timi", 16);
    books[2] = new librarySystem("Ripe", "Mnull", 12);

    while (true){
        System.out.println("Enter the assigned number for your activity:");
        System.out.println("1. Add Books");
        System.out.println("2. Borrow Books");
        System.out.println("3. Return Books");
        System.out.println("4. Exit");
        int operationInput = TextIO.getlnInt();
        System.out.println(books[0].author);
        System.out.println(operationInput);
        addBooks();
    }
   }

   public static String addBooks(){
    System.out.println("Please Enter Name, Author, and Quantity of books, separated by comma");
    String userInput = TextIO.getlnString(); 
    String[] inputSplit = userInput.trim().split("\\s*,\\s*");
    if (inputSplit.length != 3) { // Validate input format
            return "Error: Invalid input format. Please provide exactly 3 values separated by commas.";
     } // this block just decided not to Work
     String name = inputSplit[0];    // Extract and trim the name
     String author = inputSplit[1]; // Extract and trim the author
     int quantity;
     try {
         quantity = Integer.parseInt(inputSplit[2].trim()); // Parse the quantity to an integer
     } catch (NumberFormatException e) {
         return "Error: Quantity must be a valid number.";
     }
     int bookStatus = 0;
     for (int i = 0; i < books.length; i++) {
        if (books[i].title.equals(name) && books[i].author.equals(author)) {
            books[i].quantity += quantity;
            break;
        } else {
            bookStatus++;
        }
     }
     if (bookStatus >= 1) {
        books.length += 1;
        books[books.length-1] = new librarySystem(name, author, quantity);
     }
     // Return a confirmation message
     return "Book Added Successfully: Name = " + name + ", Author = " + author + ", Quantity = " + quantity;
 }
}
