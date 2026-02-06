package com.bl.guessapp;

import java.util.Scanner;
public class GuessApp {

    public static void main(String[] args) throws InvalidInputException {

        Scanner scanner = new Scanner(System.in);
        boolean restart;

        System.out.println("===========================");
        System.out.println("Welcome to the Guessing App");
        System.out.println("===========================");

        do {
            System.out.println("enter player name:");
            String player = scanner.nextLine();

            GameConfig config = new GameConfig();
            config.showRules();

            int attempts = 0;
            int hintsUsed = 0;

            boolean win = false;
            while (attempts < config.getMaxAttempts()) {
                System.out.println("Enter your guess: ");

                /*
                 * User input is validated before
                 * being used in the game logic.
                 */
                int guess = ValidationService.validateInput(scanner.nextLine());
                attempts++;

                String result = GuessValidator.validateGuess(guess, gameConfig.getTargetNumber());

                /*
                 * A hint is generated only after
                 * an incorrect guess and within
                 * the allowed hint limit.
                 */
                if (!"CORRECT".equals(result) && hintsUsed < gameConfig.getMAxHints()) {
                    hintsUsed++;
                    System.out.println(HintService.generateHint(gameConfig.getTargetNumber(), hintsUsed));
                }

                System.out.println(result);

                /*
                 * Stop the loop immediately
                 * if the correct number is guessed.
                 */
                if ("CORRECT".equals(result)) {
                    break;
                }
            }

            StorageService.saveResult(player, attempts, win);
            restart = GameController.restartGame();
        }
        while (restart);
    }
}