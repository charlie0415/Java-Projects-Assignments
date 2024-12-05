// Write the Javadoc and use while loop to display
// Since program is going to be classless write separate functions using access modifiers
// Working with methods
/* This is a student record management system for an administration */
import textio.TextIO;
import java.util.ArrayList;
import java.util.Scanner;
public class recordManagement{
    static ArrayList<Integer> studentIds = new ArrayList<>();
    static ArrayList<String> studentNames = new ArrayList<>();
    static ArrayList<Integer> studentAges = new ArrayList<>();
    static ArrayList<String> studentGrades = new ArrayList<>();
    // Method for total records
    private static int totalRecord(){
        return studentIds.size();
    }
    // Add student function
    public static void addStudents(int id, String name, int age, String grade){
        // To check if record existed already
        boolean recordExists = false;
        if (studentIds.size() != 0 ) {
            for (int i = 0; i < studentIds.size(); i++) {
                if (studentIds.get(i) == id){
                    recordExists = true;
                    break;
                }
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
    
    public static void updateRecords(int id, String name, int age, String grade){
        boolean noRecord = true;
        int recordPosition = 0;
        if (studentIds.size() != 0 ) {
            for (int i = 0; i < studentIds.size(); i++) {
                if(studentIds.get(i) == id){
                    noRecord = false;
                    recordPosition = i;
                    break;
                }
            }
        }
        if (noRecord == true) {
            System.out.println("Error: There is no record of the ID provided");
            return;
        }
        // Update records
        studentNames.set(recordPosition, name);
        studentAges.set(recordPosition, age);
        studentGrades.set(recordPosition, grade);
    } // records updates end here

    public static void displayAllRecords(){
        if (studentIds.size() != 0) {
            for (int i = 0; i < studentIds.size(); i++) {
                System.out.println("ID: " + studentIds.get(i) +" NAME: "+ studentNames.get(i) +" Age: "+ studentAges.get(i) +" Grade: "+ studentGrades.get(i));
            }
            System.out.println("There are a total of " + totalRecord() + " Records");
        } else {
            System.out.println("There are no records to display");
        }
    }

    // Main to display the admin interface
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
                    System.out.println("You are now Exiting Students Records, Bye!");
                    break;
                default:
                    System.out.println("Error: Invalid Input Try Again!");
                    break;
            }
        } while (choice != 4);
        scanner.close();
    }
}
