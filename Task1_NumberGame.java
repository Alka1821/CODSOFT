import java.util.Scanner;
import java.util.Random;

public class Task1_NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalAttempts = 0;
        int totalRounds = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            totalRounds++;
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;

            System.out.println("\nRound " + totalRounds);
            System.out.println("Enter any random number between 1 and 100.");

            while (true) {
                System.out.print("Enter your guess (between 1 and 100): ");
                int guess = sc.nextInt();
                attempts++;

                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }

                if (guess == numberToGuess) {
                    System.out.println("Congrats! You guess the correct number (" + numberToGuess + ") in " + attempts
                            + " attempts!");
                    totalAttempts += attempts;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low! Try a higher number.");
                } else {
                    System.out.println("Too high! Try a lower number.");
                }
            }

            System.out.print("Do you wanna play again? (yes/no): ");
            String playAgainInput = sc.next().toLowerCase();
            if (!playAgainInput.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nGame over!");
        System.out.println("Total rounds you played: " + totalRounds);
        System.out.println("Total attempts you made: " + totalAttempts);
        System.out.println("Thanks for Playing!");
    }
}











