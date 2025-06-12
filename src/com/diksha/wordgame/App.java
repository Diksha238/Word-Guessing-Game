package com.diksha.wordgame;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        String[] words={"java","programming","class","computer","method"};
        Scanner input = new Scanner(System.in);
        boolean shouldPlayAgain=false;
        int wins=0;
        int losses=0;


        do{
            WordGuessingGame game=new WordGuessingGame(words,10);
            String result = game.play();
            if(result.equals("Winner!")){
                wins+=1;

            }
            else{
                losses+=1;
            }
            System.out.println("wins: "+wins+" ,losses: "+losses);
            System.out.print("Would you like to play again? (y/n): ");
            char playAgain=input.nextLine().toLowerCase().charAt(0);
            shouldPlayAgain=(playAgain=='y');


        }while(shouldPlayAgain);
        System.out.println("Thanks for playing!");

    }


}
