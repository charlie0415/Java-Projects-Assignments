// Using a while true loop all parent menu/option should be displyed
// Create class and object contructor for user's entry
// Create Methods to work with options displayed
// Access the array, update it, and update length
// Implement Error handling and test
// Peruse and if possible re-write in most effifcient way
import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    int quantity;

    Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    void addQuantity(int amount) {
        this.quantity += amount;
    }

    void reduceQuantity(int amount) {
        this.quantity -= amount;
    }
}

public class librarySystem {
    static ArrayList<Book> library = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Library System!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Books");
            System.out.println("2. Borrow Books");
            System.out.println("3. Return Books");
            System.out.println("4. Exit");

            int choice = getValidIntegerInput();

            switch (choice) {
                case 1:
                    addBooks();
                    break;
                case 2:
                    borrowBooks();
                    break;
                case 3:
                    returnBooks();
                    break;
                case 4:
                    System.out.println("Exiting the Library System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please choose between 1 and 4.");
            }
        }
    }

    // Add books to the library
    public static void addBooks() {
        System.out.println("Enter book details (title, author, quantity): ");
        String input = scanner.nextLine();
        String[] details = input.split("\\s*,\\s*");

        if (details.length != 3) {
            System.out.println("Error: Please provide exactly 3 values separated by commas.");
            return;
        }

        String title = details[0];
        String author = details[1];
        int quantity;

        try {
            quantity = Integer.parseInt(details[2]);
        } catch (NumberFormatException e) {
            System.out.println("Error: Quantity must be a valid integer.");
            return;
        }

        for (Book book : library) {
            if (book.title.equalsIgnoreCase(title) && book.author.equalsIgnoreCase(author)) {
                book.addQuantity(quantity);
                System.out.println("Quantity updated successfully!");
                return;
            }
        }

        library.add(new Book(title, author, quantity));
        System.out.println("New book added successfully!");
    }

    // Borrow books from the library
    public static void borrowBooks() {
        System.out.println("Enter book title and quantity to borrow (title, quantity): ");
        String input = scanner.nextLine();
        String[] details = input.split("\\s*,\\s*");

        if (details.length != 2) {
            System.out.println("Error: Please provide exactly 2 values separated by commas.");
            return;
        }

        String title = details[0];
        int quantity;

        try {
            quantity = Integer.parseInt(details[1]);
        } catch (NumberFormatException e) {
            System.out.println("Error: Quantity must be a valid integer.");
            return;
        }

        for (Book book : library) {
            if (book.title.equalsIgnoreCase(title)) {
                if (book.quantity >= quantity) {
                    book.reduceQuantity(quantity);
                    System.out.println("Book borrowed successfully!");
                } else {
                    System.out.println("Error: Not enough books available.");
                }
                return;
            }
        }

        System.out.println("Error: Book not found in the library.");
    }

    // Return books to the library
    public static void returnBooks() {
        System.out.println("Enter book title and quantity to return (title, quantity): ");
        String input = scanner.nextLine();
        String[] details = input.split("\\s*,\\s*");

        if (details.length != 2) {
            System.out.println("Error: Please provide exactly 2 values separated by commas.");
            return;
        }

        String title = details[0];
        int quantity;

        try {
            quantity = Integer.parseInt(details[1]);
        } catch (NumberFormatException e) {
            System.out.println("Error: Quantity must be a valid integer.");
            return;
        }

        for (Book book : library) {
            if (book.title.equalsIgnoreCase(title)) {
                book.addQuantity(quantity);
                System.out.println("Book returned successfully!");
                return;
            }
        }

        System.out.println("Error: Book not found in the library.");
    }

    // Helper function to get valid integer input
    private static int getValidIntegerInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }
    }
}
