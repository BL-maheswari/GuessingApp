/*
Key Concepts:

● Scanner input handling ● Control flow (if-else, switch) ● Looping (while, do-while) ● Method invocation ● Input validation

Key Requirements:

● Accept user input ● Validate numeric input ● Compare guessed number with target ● Track number of attempts ● Provide feedback (higher/lower)

Key Benefits: ● Interactive user experience ● Structured decision making ● Reduced runtime errors ● Improved logical thinking ● Clear user feedback loop

Goal: Allow the player to submit a guess and receive immediate feedback.
 */
package com.bl.guessapp;

public class GuessValidator {
    /**
     * Compares guess with target and
     * returns the comparison result.
     */
    public static String validateGuess(int guess, int target) {

        if (guess == target) {
            return "CORRECT";
        } else if (guess < target) {
            return "LOW";
        }
        return "HIGH";
    }


}
