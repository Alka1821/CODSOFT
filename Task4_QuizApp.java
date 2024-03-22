import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Task4_QuizApp {
    private static final int MAX_QUESTIONS = 5;
    private static final int QUESTION_DURATION_SECONDS = 10;
    private static int score = 0;
    private static int currentQuestionIndex = 0;
    private static Question[] questions = new Question[MAX_QUESTIONS];
    private static Timer timer = new Timer();

    public static void main(String[] args) {
        initializeQuestions();

        System.out.println("Welcome to the Quiz!");
        System.out.println("You have " + QUESTION_DURATION_SECONDS + " seconds to answer each question.");

        askQuestion();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up!");
                displayResult();
            }
        }, QUESTION_DURATION_SECONDS * 1000);
    }

    private static void initializeQuestions() {
        questions[0] = new Question("What is the capital city of Australia?",
                new String[] { "A) Sydney", "B) Melbourne", "C) Canberra ", "D) Brisbanelin" }, "C");
        questions[1] = new Question("What is the chemical symbol for Gold?",
                new String[] { "A) Gd", "B) Go", "C) Ag", "D) Au" }, "D");
        questions[2] = new Question("In what year was the first iPhone released?",
                new String[] { "A) 2005", "B) 2007", "C) 2008", "D) 2010" }, "B");
        questions[3] = new Question("What is the tallest mountain in the world?",
                new String[] { "A) Mount Everest", "B) K2 ", "C) Mount Kilimanjaro", "D) Denali" }, "A");
        questions[4] = new Question("Who is the author of the Harry Potter series?",
                new String[] { "A) J.D. Salinger", "B) Roald Dahl", "C) Suzanne Collins", "D) J.K. Rowling" }, "D");
    }

    private static void askQuestion() {
        if (currentQuestionIndex < MAX_QUESTIONS) {
            Question currentQuestion = questions[currentQuestionIndex];
            System.out.println("\nQuestion " + (currentQuestionIndex + 1) + ": " + currentQuestion.getQuestion());
            for (String option : currentQuestion.getOptions()) {
                System.out.println(option);
            }
            System.out.print("Select an option (A/B/C/D): ");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine().toUpperCase();
            if (answer.equals(currentQuestion.getCorrectAnswer())) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }
            currentQuestionIndex++;
            askQuestion();
        } else {
            displayResult();
        }
    }

    private static void displayResult() {
        System.out.println("\nQuiz Completed!");
        System.out.println("Your Score: " + score + "/" + MAX_QUESTIONS);
    }
}

class Question {
    private String question;
    private String[] options;
    private String correctAnswer;

    public Question(String question, String[] options, String correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
