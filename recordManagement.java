// Write the Javadoc and use while loop to display
// Since program is going to be classless write separate functions using access modifiers
// Make use of lambda to display records
/* This is  student record management system for an administration */
import java.util.Scanner;
import textio.TextIO;
import java.util.ArrayList;
public class recordManagement{
    static ArrayList<Integer> studentIds = new ArrayList<>();
    static ArrayList<String> studentNames = new ArrayList<>();
    static ArrayList<Integer> studentAges = new ArrayList<>();
    static ArrayList<String> studentGrades = new ArrayList<>();
    // Add student function
    private static void addStudents(int id, String name, int age, String grade){
        // To check if record existed already
        boolean recordExists = false;
        if (studentIds.size() != 0 ) {
            for (int i = 0; i < studentIds.size(); i++) {
                   recordExists = studentIds.get(i) == id ? true : recordExists;
                   break;
            }
        }
        if (recordExists == true) {
            int position = studentIds.indexOf(id);
            String exName = studentNames.get(position);
            String exGrade = studentGrades.get(position);
            int exAge = studentAges.get(position);
            System.out.println("Error: This Id mactches an ID in records");
            System.out.println(id + " " + exName + " " + exAge + " " + exGrade);
            return;
        }
        studentIds.add(id);
        studentNames.add(name);
        studentAges.add(age);
        studentGrades.add(grade);
        } //Add students ends here
    
    private static void updateRecords(int id, String name, int age, String grade){
        boolean noRecord = true;
        if (studentIds.size() != 0 ) {
            for (int i = 0; i < studentIds.size(); i++) {
                   noRecord = studentIds.get(i) == id ? false : noRecord;
                   break;
            }
        }
        if (noRecord == true) {
            System.out.println("Error: There is no record of the ID provided");
            return;
        }
        // Update records
        int position = studentIds.indexOf(id);
        studentNames.set(position, name);
        studentAges.set(position, age);
        studentGrades.set(position, grade);
    }
    // Main to display the admin interface
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

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
                    addStudents(choice, null, choice, null);
                    break;
                case 2:
                    updateRecords(choice, null, choice, null);
                    break;
                case 3:
                    // displayAllRecords
                case 4:
                    System.out.println("You are now Exiting Students Records, Bye!");
                    break;
                default:
                    System.out.println("Error: Invalid Input Try Again!");
                    break;
            }
        } while (choice != 4);
    }
}
