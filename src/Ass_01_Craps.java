
import java.util.Scanner;
import java.util.Random;

public class Ass_01_Craps {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rnd = new Random();

        String playAgain;

        do {
            // Roll the two dice
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int sum = die1 + die2;

            System.out.println("\nRolling the dice...");
            System.out.println("Die 1: " + die1);
            System.out.println("Die 2: " + die2);
            System.out.println("Sum: " + sum);

            // Check the initial roll
            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win!");
            } else {
                // The initial sum becomes the point
                int point = sum;
                System.out.println("The point is " + point + ".");

                // Keep rolling until the player wins or loses
                while (true) {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    sum = die1 + die2;

                    System.out.println("\nRolling the dice...");
                    System.out.println("Die 1: " + die1);
                    System.out.println("Die 2: " + die2);
                    System.out.println("Sum: " + sum);

                    if (sum == point) {
                        System.out.println("Made point and won!");
                        break;
                    } else if (sum == 7) {
                        System.out.println("Got a seven and lost.");
                        break;
                    } else {
                        System.out.println("Trying for point...");
                    }
                }
            }

            // Ask whether to play again
            do {
                System.out.print("\nDo you want to play again? (Y/N): ");
                playAgain = input.nextLine();

                if (!playAgain.equalsIgnoreCase("Y")
                        && !playAgain.equalsIgnoreCase("N")) {
                    System.out.println("Please enter Y or N.");
                }
            } while (!playAgain.equalsIgnoreCase("Y")
                    && !playAgain.equalsIgnoreCase("N"));

        } while (playAgain.equalsIgnoreCase("Y"));

        System.out.println("Thanks for playing!");

        input.close();
    }
}
