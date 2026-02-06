/*
USE CASE-3: HINT GENERATION

Key Concepts: ● Conditional logic ● Modulus and arithmetic operators ● Method abstraction ● Encapsulation of hint logic

Key Requirements: ● Generate hints after incorrect guesses ● Limit number of hints ● Provide meaningful hints (even/odd, range, divisibility) ● Increase difficulty gradually ● Ensure hints don’t reveal exact number

Key Benefits: ● Enhanced user engagement ● Progressive difficulty learning ● Encourages analytical thinking ● Clean separation of hint logic ● Reusable hint engine

Goal: Provide helpful hints to guide the player toward the correct answer.
 */
package com.bl.guessapp;

public class HintService {
    /*
     * Generates a hint based on how many hints
     * have already been used.
     *
     * Hints provides partial information without
     * revealing the exact number.
     */
    public static String generateHint(int target, int hintCount) {

        if (hintCount == 1) {
            return (target % 2 == 0)
                    ? "Hint: Number is EVEN"
                    : "Hint: NUmber is ODD";
        } else if (hintCount == 2) {
            return (target > 50)
                    ? "Hint: Number is greater than 50"
                    : "Hint: Number is 50 or less";
        }

        return "No more hints available";
    }
}