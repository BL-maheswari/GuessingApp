/*
Use Case 4: Error Handling & Validation
 *
 * This class coordinates the game execution while ensuring
 * all user inputs are safely validated before processing.
 *
 * Responsibilities:
 * - Initialization game configuration
 * - Accept user input
 * - Validate input using ValidationService
 * - Handles game flow without crashing on invalid input
 *
 * @author Developer
 * @version 4.0
 */

package com.bl.guessapp;

import java.util.Scanner;

public class GuessApp {
    public static void main(String[] args) throws InvalidInputException{

        System.out.println("Welcome to the Guessing App");

        GameConfig gameConfig = new GameConfig();
        gameConfig.showRules();

        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        int hintsUsed = 0;

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
            if(!"CORRECT".equals(result) && hintsUsed < gameConfig.getMaxHints()){
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
    }
}
