// Write the Javadoc and use while loop to display
// Since program is going to be classless write separate functions using access modifiers
// Working with methods
import textio.TextIO;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * <h1>Student Record Management System</h1>
 * This class implements a Student Record Management System designed for administrators. 
 * It allows administrators to add new student records, update existing records, and view all records.
 * 
 * <p>The system stores student details using ArrayLists for dynamic storage, and 
 * methods provide the functionality for managing records.</p>
 * 
 * <h2>Features:</h2>
 * <ul>
 *   <li>Add new students</li>
 *   <li>Update existing student records</li>
 *   <li>View all student records</li>
 * </ul>
 * 
 * <h2>Usage:</h2>
 * <p>Run the main method to start the program. The menu-driven interface guides the user through the available options.</p>
 * 
 * @author Charles Oluwatuase
 * @version 1.0
 */
public class recordManagement {

    /**
     * Stores the IDs of the students in the system.
     */
    static ArrayList<Integer> studentIds = new ArrayList<>();

    /**
     * Stores the names of the students.
     */
    static ArrayList<String> studentNames = new ArrayList<>();

    /**
     * Stores the ages of the students.
     */
    static ArrayList<Integer> studentAges = new ArrayList<>();

    /**
     * Stores the grades of the students.
     */
    static ArrayList<String> studentGrades = new ArrayList<>();

    /**
     * Calculates the total number of student records in the system.
     * 
     * @return The total number of student records.
     */
    private static int totalRecord() {
        return studentIds.size();
    }

    /**
     * Adds a new student to the system.
     * Ensures that the student ID is not already in the system.
     * 
     * @param id    The unique ID of the student.
     * @param name  The name of the student.
     * @param age   The age of the student.
     * @param grade The grade of the student.
     */
    private static void addStudents(int id, String name, int age, String grade) {
        boolean recordExists = false;

        if (studentIds.size() != 0) {
            for (int i = 0; i < studentIds.size(); i++) {
                if (studentIds.get(i) == id) {
                    recordExists = true;
                    break;
                }
            }
        }

        if (recordExists) {
            int position = studentIds.indexOf(id);
            String exName = studentNames.get(position);
            String exGrade = studentGrades.get(position);
            int exAge = studentAges.get(position);
            System.out.println("Error: This ID matches an ID in the records.");
            System.out.println(id + " " + exName + " " + exAge + " " + exGrade);
            return;
        }

        studentIds.add(id);
        studentNames.add(name);
        studentAges.add(age);
        studentGrades.add(grade);
    }

    /**
     * Updates the record of an existing student based on their ID.
     * 
     * @param id    The ID of the student whose record is to be updated.
     * @param name  The new name of the student.
     * @param age   The new age of the student.
     * @param grade The new grade of the student.
     */
    private static void updateRecords(int id, String name, int age, String grade) {
        boolean noRecord = true;
        int recordPosition = 0;

        if (studentIds.size() != 0) {
            for (int i = 0; i < studentIds.size(); i++) {
                if (studentIds.get(i) == id) {
                    noRecord = false;
                    recordPosition = i;
                    break;
                }
            }
        }

        if (noRecord) {
            System.out.println("Error: There is no record of the ID provided.");
            return;
        }

        studentNames.set(recordPosition, name);
        studentAges.set(recordPosition, age);
        studentGrades.set(recordPosition, grade);
    }

    /**
     * Displays all student records currently stored in the system.
     * If no records are available, it notifies the user.
     */
    private static void displayAllRecords() {
        if (studentIds.size() != 0) {
            for (int i = 0; i < studentIds.size(); i++) {
                System.out.println("ID: " + studentIds.get(i) + 
                                   " NAME: " + studentNames.get(i) + 
                                   " Age: " + studentAges.get(i) + 
                                   " Grade: " + studentGrades.get(i));
            }
            System.out.println("There are a total of " + totalRecord() + " records.");
        } else {
            System.out.println("There are no records to display.");
        }
    }

    /**
     * The main method serves as the entry point of the program.
     * It provides a menu-driven interface for administrators to interact with the system.
     * 
     * <p>Features:</p>
     * <ul>
     *   <li>Add a new student</li>
     *   <li>Update an existing student's record</li>
     *   <li>View all student records</li>
     *   <li>Exit the program</li>
     * </ul>
     * 
     * <p>The program uses the {@code TextIO} library for input handling and error management.</p>
     * 
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        int choice;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Welcome to the Student Record Management System");
            System.err.println("1. Add New Students");
            System.out.println("2. Update Student Information");
            System.out.println("3. View All Students in Record");
            System.out.println("4. Exit");
            System.out.println("Enter your Choice from the Options");
            choice = TextIO.getInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter ID: ");
                    int id = TextIO.getInt();
                    System.out.print("Enter Age: ");
                    int age = TextIO.getInt();
                    System.out.print("Enter Grade: ");
                    String grade = scanner.nextLine();
                    addStudents(id, name, age, grade);
                    break;
                case 2:
                    System.out.print("Enter ID of the student to update: ");
                    int updateId = TextIO.getInt();
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Age: ");
                    int newAge = TextIO.getInt();
                    System.out.print("Enter New Grade: ");
                    String newGrade = scanner.nextLine();
                    updateRecords(updateId, newName, newAge, newGrade);
                    break;
                case 3:
                    displayAllRecords();
                    break;
                case 4:
                    System.out.println("You are now exiting Student Records. Goodbye!");
                    break;
                default:
                    System.out.println("Error: Invalid input. Try again!");
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }
}
