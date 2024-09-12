package guessing_game;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int minRange = 1;
        int maxRange = 10;

        boolean quit = false;

        GuessingGame game = new GuessingGame(minRange, maxRange);

        System.out.println("Welcome to The Guessing Game");
        System.out.println("============================");

        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(STR."Guess the Number between \{minRange} and \{maxRange}: ");

            // handles invalid user inputs
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid number.");
                System.out.print(STR."Guess the Number between \{minRange} and \{maxRange}: ");
                sc.next();
            }

            int guessingNumber = sc.nextInt();

            String response = game.guess(guessingNumber);
            System.out.println(response);

            // exiting condition
            if (response.contains("You got it") || response.contains("game is Over")) {
                quit = true;
            }

        } while (!quit);

    }
}
