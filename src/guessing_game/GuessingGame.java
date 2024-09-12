package guessing_game;

import java.util.Random;
import static java.lang.StringTemplate.STR;

public class GuessingGame {
    private final int randomNumber;
    private final int guesseslimits = 5;
    private int guesses = 0;

    public GuessingGame(int start, int end) {
        // random number is created based on start and end values
        // For example if 5,10 are passed as start and end. It generates random number that falls in the range of 5 to 10. randomNumber > start and randomNumber<end;
        this.randomNumber = start + new Random().nextInt(end - start + 1) + start;
    }

    /**
     *
     * @return randomNumber
     */
    private int getRandomNumber() {
        return randomNumber;
    }

    /**
     * The method it responds with either successful or losing message depends on the value passed to the function
     * It also maintains state or value for player's attempts if player exceeds limits then it's prompt with losing msg.
     * @param guessingNumber {@code int}
     *
     * @return it responds with either a winning message or losing message with little hint ("Too high" {@code guessingNumber>randomNumber}
     * otherwise "Too low")
     */
    public String guess(int guessingNumber) {
        guesses++;
        String response;
        // if user is not succeeds in finding a number it will return the losingMsg
        if (guesses == guesseslimits && guessingNumber != getRandomNumber()) {
            response = STR."Your game is Over, You had all guesses. The secret Number is \{getRandomNumber()}";
        } else if (guesses > guesseslimits) {
            response = STR."You are limited to \{guesseslimits}";
        } else {
            String tryText = (guesses == 1) ? "try" : "tries";
            String winningMsg = STR."You got it in \{guesses} \{tryText}.";
            String hintText = guessingNumber > getRandomNumber()
                    ?
                    "Your guessed Number is too high"
                    :
                    "Your guessed Number is too low";
            String losingMsg = STR."You didn't get it, \{hintText}";
            response = guessingNumber == getRandomNumber() ? winningMsg : losingMsg;
        }
        return response;
    }
}
