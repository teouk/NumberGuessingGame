import java.util.Scanner;

public class NumberGuessing {

    public static final String WELCOME = "Welcome to the Number Guessing Game!";
    public static final String START_GUESSING = "I’ve picked a number between 1 and 100. Start guessing!";
    public static final String ENTER_YOUR_GUESS = "Enter your guess: ";
    public static final String NOT_VALID_NUMBER = "Please enter a valid number!";
    public static final String LOW_TRY_AGAIN = "Too low! Try again.";
    public static final String HIGH_TRY_AGAIN = "Too high! Try again.";
    public static final String PLAYER_WINS = "You guessed the correct number %s in %s attempts. Well done!";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Generate random number between 1 and 100
        int secretNumber = (int)(Math.random() * 100) + 1;
        int attempts = 0;

        System.out.println(WELCOME);
        System.out.println(START_GUESSING);

        while (true) {
            System.out.print(ENTER_YOUR_GUESS);

            // Check if input is an integer
            if (!sc.hasNextInt()) {
                System.out.println(NOT_VALID_NUMBER);
                sc.next(); // Clear invalid input
                continue;
            }

            int guess = sc.nextInt();
            attempts++;

            // Check the guess
            if (guess == secretNumber) {
                System.out.printf(PLAYER_WINS, secretNumber, attempts);
                break;
            } else if (guess < secretNumber) {
                System.out.println(LOW_TRY_AGAIN);
            } else {
                System.out.println(HIGH_TRY_AGAIN);
            }
        }
        sc.close();
    }
}