// First create objects of question, extra-answer and correct answer inside an array
// Create a while loop for max number of trial control
// Id the array and display each question and extra-answer
// Collect input and set if collected input matches correct answer with boolean
// Update score with boolean
/* Catch errors: lookout for when a letter is not entered or
 * when the letter entered is beyond A to D
 */
import textio.TextIO;
public class Choice {
    public static void main(String[] args){
        String[][] choiceQuestions = {
            {"Who is the present fastest man in the world",
            " A. Barry Allen \n B. Usain Bolt \n C. Tyson Gay \n D. Justin Gatlin",
            "B"},
            {"How many centimetre makes one metre",
            " A. 10 \n B.1000  \n C. 1 \n D. 100",
            "D"},
            {"The most abundant element in the Universe",
            " A. Oxygen \n B. Nitrogen \n C. Helium \n D. Hydrogen",
            "D"},
            {"The most abundant gaseous element in the World",
            " A. Oxygen \n B. Nitrogen \n C. Helium \n D. Hydrogen",
            "B"},
            {"The unconolized country in Africa",
            " A. Nigeria \n B. Jamaica \n C. Ethiopia \n D. Egypt",
            "C"}
        };
        int question = 0;
        int choices = 1;
        int idxAnswer = 2;
        int score = 0;
        for (int i = 0; i < choiceQuestions.length; i++) {
            System.out.println(choiceQuestions[i][question]);
            System.out.println(choiceQuestions[i][choices]);
            System.out.print("Enter an Option: ");
            String subAnswer = TextIO.getlnString();
            if (!subAnswer.equals("A") && !subAnswer.equals("B") && !subAnswer.equals("C") && !subAnswer.equals("D") && subAnswer.length() > 1) {
                System.err.println("Enter a character from the Choices");
                System.out.println(choiceQuestions[i][question]);
                System.out.println(choiceQuestions[i][choices]);
                System.out.print("Enter an Option: ");
                subAnswer = TextIO.getlnString();   
            }
            // else if (subAnswer.length() > 1) {
            //     System.err.println("Enter a character from the Choices");
            //     System.out.println(choiceQuestions[i][question]);
            //     System.out.println(choiceQuestions[i][choices]);
            //     System.out.print("Enter an Option: ");
            //     subAnswer = TextIO.getlnString();
            // }
            else if(subAnswer.equals(choiceQuestions[i][idxAnswer])) {
                score++;
            }
            else{
                continue;
            }
        };
        double scorePercentage = ((double)score/choiceQuestions.length) * 100;
        System.out.printf("Your final score: %d/%d (%.2f%%)\n", score, choiceQuestions.length, scorePercentage);
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
    }// end of main()
    }
    