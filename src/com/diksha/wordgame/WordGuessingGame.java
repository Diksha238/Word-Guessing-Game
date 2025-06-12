package com.diksha.wordgame;

import java.util.Random;
import java.util.Scanner;

public class WordGuessingGame {
    private String wordToGuess;
    private char[] guessedLetters;
    private int attempts;

    public WordGuessingGame(String[] wordList,int maxAttempts){
        Random rand = new Random();
        this.wordToGuess = wordList[rand.nextInt(wordList.length)];
        this.guessedLetters = new char[this.wordToGuess.length()];
        for (int i = 0; i < this.guessedLetters.length; i++) {
            this.guessedLetters[i]='_';

        }
        this.attempts = maxAttempts;

    }
    public String play() {
        Scanner input = new Scanner(System.in);
        while (attempts > 0 ) {
            displayState();
            System.out.println("You have " + attempts + " attempts left....");
            System.out.println("Guess a letter: ");
            char guess = input.nextLine().toLowerCase().charAt(0);

            if(processGuess(guess)){
                System.out.println("You guessed a letter");
                if(new String(this.guessedLetters).equals(wordToGuess)){
                    System.out.println("You have guessed the word!you win");
                    return"Winner!";

                }
            }
            else{
                System.out.println("That guess was incorrect");
                attempts--;
            }
        }
        return "You LOOSE";
    }
    private boolean processGuess(char letter) {
        boolean letterInWord = false;
        for (int i = 0; i < this.wordToGuess.length(); i++) {
            if (this.wordToGuess.charAt(i) == letter) {
                guessedLetters[i] = letter;

                letterInWord = true;
            }

        }
        return letterInWord;
    }
    private void displayState(){
        System.out.println("Guessed letters:"+new String(this.guessedLetters));
    }

    }
