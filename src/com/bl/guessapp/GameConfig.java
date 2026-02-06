/*
 * Key Concepts:
 * ● Primitive Data Types
 * ● Random number generation
 * ● Constructor initialization
 * ● Encapsulation (private fields)
 * ● Constants (final keyword)
 *
 *  Key Requirements:
 * ● Generate a random target number within a predefined range
 * ● Initialize maximum attempts
 * ● Initialize hint counter
 * ● Store game configuration
 * ● Display game welcome message and rules
 */
package com.bl.guessapp;

import java.util.Random;

public class GameConfig {
    private final int MIN = 1;
    private final int MAX = 100;
    private final int MAX_ATTEMPTS = 7;
    private final int MAX_HINTS = 3;
    int targetNumber;

    /**
     * constructor is automatically called when a gameCOnfig object is created.
     * it initializes the random target number for the game
     */
    public GameConfig() {
        Random random=new Random();
        this.targetNumber=random.nextInt(MAX-MIN+1)+MIN;

    }
    public int getTargetNumber() {
        return targetNumber;
    }
    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }
    public int getMAxHints() {
        return MAX_HINTS;
    }
    public void showRules() {
        System.out.println("guess a number between "+MIN+" and "+MAX);
        System.out.println("you have "+MAX_ATTEMPTS+" attempts.");
        System.out.println("hints will be provided after wrong guesses.\n");
    }
}
