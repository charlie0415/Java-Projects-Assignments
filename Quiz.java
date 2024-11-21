// First create objects of question, Choices and nswer inside an array
// Loop through array
// Id the array and display each question and choices
// Collect input and set if collected input matches answer with boolean
// Update score with boolean
/* Create function to catch errors: lookout for when a letter is not entered or
 * when the letter entered is beyond A to D
 */
import textio.TextIO;

public class Quiz {
    public static void main(String[] args) {
        String[][] choiceQuestions = {
            {"Who is the present fastest man in the world",
            " A. Barry Allen \n B. Usain Bolt \n C. Tyson Gay \n D. Justin Gatlin",
            "B"},
            {"How many centimetres make one metre",
            " A. 10 \n B.1000  \n C. 1 \n D. 100",
            "D"},
            {"The most abundant element in the Universe",
            " A. Oxygen \n B. Nitrogen \n C. Helium \n D. Hydrogen",
            "D"},
            {"The most abundant gaseous element in the World",
            " A. Oxygen \n B. Nitrogen \n C. Helium \n D. Hydrogen",
            "B"},
            {"The unconquered country in Africa",
            " A. Nigeria \n B. Jamaica \n C. Ethiopia \n D. Egypt",
            "C"}
        };

        int question = 0;
        int choices = 1;
        int idxAnswer = 2;
        int score = 0;

        // Loop through each question
        for (int i = 0; i < choiceQuestions.length; i++) {
            System.out.println(choiceQuestions[i][question]);  // Print question
            System.out.println(choiceQuestions[i][choices]);  // Print choices

            // Call the function to get a valid input answer
            String subAnswer = getValidAnswer(choiceQuestions[i][question], choiceQuestions[i][choices]);

            // Check if the answer is correct
            if (subAnswer.equals(choiceQuestions[i][idxAnswer])) {
                score++;
            }
        }

        // Calculate and display score percentage
        double scorePercentage = ((double) score / choiceQuestions.length) * 100;
        System.out.printf("Your final score: %d/%d (%.2f%%)\n", score, choiceQuestions.length, scorePercentage);

        // Evaluate performance based on score
        switch (score) {
            case 5:
                System.out.println("Excellent");
                break;
            case 4:
                System.out.println("Very Good");
                break;
            case 3:
                System.out.println("Good");
                break;
            default:
                System.out.println("Put more effort, not good enough");
                break;
        }
    }

    // Function to handle input validation and re-prompting
    public static String getValidAnswer(String question, String choices) {
        String subAnswer;

        // Loop until a valid answer is entered
        while (true) {
            System.out.print("Enter an Option: ");
            subAnswer = TextIO.getlnString().toUpperCase();  // Get user input

            // Check if input is valid (only A, B, C, D)
            if (subAnswer.equals("A") || subAnswer.equals("B") || subAnswer.equals("C") || subAnswer.equals("D")) {
                break;  // Valid answer, exit loop
            } else if (subAnswer.length() > 1) {
                // If input length is more than 1, it's invalid
                System.err.println("Enter only a single character (A, B, C, D)");
            } else {
                // If the input is invalid (not one of A, B, C, D)
                System.err.println("Enter a character from the Choices");
            }

            // Reprint the question and choices so the user knows what to choose
            System.out.println(question);
            System.out.println(choices);
        }

        return subAnswer;
    }
}