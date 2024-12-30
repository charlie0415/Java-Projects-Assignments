// Work wih getters and setters
// Ensure data privacy
// Work with obj as params and returns if possible
// more with java dock
// Create Student Class
// Create Course Class
import java.util.*;
import textio.TextIO;;
class Student{
    private String name;
    private String Id;
    // Course grades
    private Map<Course, Double> grades = new HashMap<>();
    // Enrolled Courses
    private List<Course> enrolledCourses = new ArrayList<>();
    //constructor
    public Student(String name, String Id){
        this.name = name;
        this.Id = Id;
    }

    // Name getter and setter
    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    // enrolledCourses getters and Setters
    public List<Course> getEnrolledCourses(){ return enrolledCourses;}

    // Id getter and setter
    public String getId(){return Id;}
    public void setId(String Id){this.Id = Id;}

    // grades getter
    public Map<Course, Double> getGrades(){return grades;}

    // This function is to add courses to the student enrolled courses
    void addCourse(Course subject){
        if (enrolledCourses.contains(subject)) {
            System.out.println("This student has already been enrolled in this course");
        }
        else if (subject.getEnrolledStudents() == subject.getMaxCapacity()) {
            System.out.println("Maximum Capacity has been reached for this Course");
        }
        else{
            enrolledCourses.add(subject);
            subject.incrementEnrolledStudents();
        }
    } // End of add course

    // This function assigns grades
    void assignGrades(Course subject, Double grade){
        if (enrolledCourses.contains(subject)) {
            grades.put(subject, grade);
        }
        else{
            System.out.println("Student is not enrolled in this course: " + subject.getName());
        }
    } // End of assignGrades
} // end of Student Class

class Course{
    private String code;
    private String name;
    private int maxCapacity;
    private int enrolledStudents;
    private static int totalEnrolledStudents;
    // constructor
    public Course (String code, String name, int maxCapacity){
        this.code = code;
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = 0;     
    }
    // Code getter and setter
    public String getCode(){return code;}
    public void setCode(String code){this.code = code;}
    // Name getter and setter
    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    // Maxcap getter and setter
    public int getMaxCapacity(){return maxCapacity;}
    public void setMaxCapacity(int maxCap){this.maxCapacity = maxCap;}
    // Getter for enrolled students
    public int getEnrolledStudents(){return enrolledStudents;}
    // Getter for total enrolled students
    public int getTotalEnrolledStudents(){return totalEnrolledStudents;}
    // Increasing enrolled students
    void incrementEnrolledStudents(){
        if(enrolledStudents < maxCapacity){
            enrolledStudents++;
            totalEnrolledStudents++;
        }
        else{
            System.out.println("Course: " + name + " limit has been reached.");
        }
    } // end of incrementEnrolledStudents
} // end of Course class

class CourseManagement{
    private static List<Course>courses = new LinkedList<>();
    private static HashMap<Student, Double> overallCourseGrades = new HashMap<>();

    // Getter for list of Courses
    public static List<Course> getCourses(){ return courses;}

    // addCourse method
    public static void addCourse(String code, String name, int maxCapacity){
        courses.add(new Course(code, name, maxCapacity));
    }
    // enrollStudent method
    public static void enrollStudent(Student student, Course subject){
        student.addCourse(subject);
    }

    // assignGrade method
    public static void assignGrade(Student student, Course subject, Double grade){
        student.assignGrades(subject, grade);
    }

    // calcOverallGrades method
    public static void calcOverallGrades(Student student){
        Map<Course, Double> grades = student.getGrades();
        double total = 0;
        for (Double i : grades.values()){
            total += i;
        }
        // Math.round is to correct precision error from pogramming languages 
        double gpa = grades.size() > 0 ? Math.round((total/(grades.size()*100))*500.0)/100.0 : 0;
        overallCourseGrades.put(student, gpa);
        System.out.println(student.getName() + " " + student.getId() + " " + gpa);
    }
}

public class courseEnrollment {
    private static List<Student> students = new ArrayList<>();
    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add a New Course");
            System.out.println("2. Enroll Students");
            System.out.println("3. Assign Grades");
            System.out.println("4. Overall Course Grade");
            System.out.println("5. Exit");
            System.out.print("Enter Choice of Option: ");
            int option = TextIO.getlnInt();
            switch (option) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    enrolledStudent();
                    break;
                case 3:
                    assignGrade();
                    break;
                case 4:
                    overallGrade();
                    break;
                default:
                    break;
            }
        } // End of while loop
    } // End of mains

    // Course addition with operation repetiton on admin inteface
    private static void addCourse(){
        boolean repeat = true;
        while (repeat) {
            System.out.print("Course Name: ");
            String name = TextIO.getlnString();
            System.out.print("Course ID: ");
            String code = TextIO.getln();
            System.out.print("Course Maximum Capacity: ");
            int maxCap = TextIO.getlnInt();
            CourseManagement.addCourse(code, name, maxCap);
            System.out.print("Enter 'Y' to continue adding more courses or 'N' to stop: ");
            char input = TextIO.getlnChar();
            if (Character.toLowerCase(input) == 'y') {
                repeat = true;
            }
            else if (Character.toLowerCase(input) == 'n') {
                System.out.println("Course has been added");
                System.out.println("Returning to Main menu");
                repeat = false;
            }
            else{
                System.out.println("Invalid Input, returning to Main menu");
                return;
            }   
        }
    } // END of addCourse

    private static void enrolledStudent(){
        boolean repeat = true;
        while (repeat) {
            System.out.print("Enter Student's Name: ");
            String name = TextIO.getlnString();
            System.out.print("Enter Student's ID: ");
            String id = TextIO.getlnString();
            // Trying to work without boolean check
            Student student = null;
            for (Student i : students){
                if (i.getId().equals(id)) {
                    student = i;
                    break;
                }
            }
            if (student == null) {
                student = new Student(name, id);
                students.add(student);
            }
            // Check if any courses are available
            if (CourseManagement.getCourses().size() <= 0) {
                System.out.println("There is no Course Available to Enroll Students");
                return;
            }
            // List.copyOf to prevent List modification
            List<Course> coursesSubList = new ArrayList<>(List.copyOf(CourseManagement.getCourses()));
            System.out.println("Here is the List of Available Courses");
            for (int i = 0; i < coursesSubList.size(); i++){
                System.out.println(i+1 + " " + coursesSubList.get(i).getName() + " " + coursesSubList.get(i).getCode());
            }   
            System.out.print("Select Course Number to Enroll: ");
            int courseNum = TextIO.getlnInt();
            Course courseName = coursesSubList.get(courseNum-1);
            if (courseNum >0 & courseNum <= coursesSubList.size() & courseName.getEnrolledStudents() < courseName.getMaxCapacity()) {
                CourseManagement.enrollStudent(student, courseName);
                System.out.println("Enrollment Successful");
            }
            else if (courseNum >0 & courseNum <= coursesSubList.size() & courseName.getEnrolledStudents() >= courseName.getMaxCapacity()) {
                System.out.println("Student is not Enrolled Course Limit has been Reached");  
            } else {
                System.out.println("invalid input");
                System.out.println("Enrollment Unsuccessful. Returning to Main Menu");
            }
            repeat = false;
        }
    } // End of enrolledStudent

    private static void assignGrade(){
        // params for the coursemanagement func to be called are Student and Course obj, and Double grades
        boolean repeat = true;
        while (repeat) {
            System.out.println("Enter Student ID: ");
            String Id = TextIO.getlnString();
            Student student = null;
            for(Student s : students){
                if (s.getId().equals(Id)) {
                    student = s;
                }
            }
            if (student == null) {
                System.out.println("Invalid Input\nRecord of Student Id provided does not exit.");
                return;
            }
            if (student.getEnrolledCourses().isEmpty()) {
                System.out.println("Student has not Registered any Course");
                return;
            }
            while (repeat) {
                System.out.println("Here are the Courses Enrolled");
                for(int i = 0; i < student.getEnrolledCourses().size(); i++){
                    System.out.println(i+1 + ". " + student.getEnrolledCourses().get(i).getName());
                }
                System.out.println(student.getEnrolledCourses().size() + 1 + ". " + "Exit");
                System.out.print("Enter a Number from the Choices Above: ");
                int input = TextIO.getlnInt();
                if (input > 0 & input <= student.getEnrolledCourses().size()) {
                    Course course = student.getEnrolledCourses().get(input - 1);
                    System.out.println(course.getName() + " " + course.getCode());
                    System.out.print("Enter Grade: ");
                    Double grade = TextIO.getlnDouble();
                    CourseManagement.assignGrade(student, course, grade);
                    System.out.println("Grades has been Successfully Assigned");
                }
                else if (input == student.getEnrolledCourses().size() + 1) {
                    repeat = false;
                    System.out.println("Exiting Student Course Records");
                } else{
                    System.out.println("Invalid Response");
                    return;
                }
            }
        }
    } // End of assignGrades

    private static void overallGrade(){
        System.out.println("Enter Student Id: ");
        String id = TextIO.getlnString();
        for (Student s : students){
            if(s.getId().equals(id)){
                System.out.println("Here is the Student Overall Grade");
                CourseManagement.calcOverallGrades(s);
                return;
            }
        }
        System.out.println("Invalid Input. Id does not exist in Students' Record");
    } // End of overallGrade
} // End of file class