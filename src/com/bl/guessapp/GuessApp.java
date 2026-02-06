/*
 * GuessingApp-use case 1:Game Initialization
 *
 * this class serves as a the application entry point.
 * it initializes the game configuration and displays game rules.
 * No user input or gameplay logic is implemented at this stage.
 * @author Developer
 * @version 1.0
 *
 */
package com.bl.guessapp;

public class GuessingApp {
    public static void main(String[] args) {
        System.out.println("welcome to the Guessing App");
        GameConfig gemeConfig=new GameConfig();
        gemeConfig.showRules();
    }

}
