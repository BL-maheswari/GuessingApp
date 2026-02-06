package com.bl.guessapp;

import java.util.Scanner;

/**
 * MAIN CLASS
 *
 * Use Case 5: Game Result Storage
 *
 * This class coordinates the complete game flow
 * and persists the final result after completion.
 *
 * Responsibilities:
 * - Initialize game configuration
 * - Accept and validate user guesses
 * - Generate hints when applicable
 * - Store game result at the end
 *
 * @author Developer
 * @version 5.0
 */
public class GuessApp {

    public static void main(String[] args) throws InvalidInputException{

        Scanner scanner = new Scanner(System.in);

        System.out.println("===========================");
        System.out.println("Welcome to the Guessing App");
        System.out.println("===========================");

        /*
         * Player name is captured once
         * and stored along with game results.
         */
        System.out.println("Enter Player Name: ");
        String player = scanner.nextLine();

        GameConfig gameConfig = new GameConfig();
        gameConfig.showRules();

        int attempts = 0;
        int hintsUsed = 0;

        /*
         * Tracks whether the player
         * successfully guessed the number.
         */
        boolean win = false;

        /*
         * Game loop runs until the player
         * exhausts the maximum attempts.
         */

        while(attempts<gameConfig.getMaxAttempts()){
            System.out.println("Enter your guess: ");

            /*
             * User input is validated before
             * being used in the game logic.
             */
            int guess=ValidationService.validateInput(scanner.nextLine());
            attempts++;

            String result=GuessValidator.validateGuess(guess, gameConfig.getTargetNumber());

            /*
             * A hint is generated only after
             * an incorrect guess and within
             * the allowed hint limit.
             */
            if(!"CORRECT".equals(result) && hintsUsed < gameConfig.getMAxHints()){
                hintsUsed++;
                System.out.println(HintService.generateHint(gameConfig.getTargetNumber(), hintsUsed));
            }

            System.out.println(result);

            /*
             * Stop the loop immediately
             * if the correct number is guessed.
             */
            if ("CORRECT".equals(result)){
                break;
            }
        }

        StorageService.saveResult(player, attempts, win);
    }
}