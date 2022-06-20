import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        GameMethods theGame = new GameMethods("","",0);
        String guess="";
        String playAgain = "Y";
        StringBuilder guessList = new StringBuilder();
        theGame.assignWord();
        do {
            theGame.printMan();

            try{
            guess = input.nextLine().toUpperCase();
            }catch (Exception e) {
                           
            }
            if (guessList.toString().contains(guess)) {
                    System.out.println("You've already tried this one");
                }

            else{guessList.append(guess);
            }
            if(guess.length()!=1){
                System.out.println("Please Follow Instructions!");
                theGame.setGuessCount(+1);
            }else {
                try {
                    theGame.checker(guess);
                } catch (Exception e) {
                    System.out.println("Don't enter numbers!");
                }
            }

        if(theGame.getGuessCount()==6){
            System.out.println(" O      ||");
            System.out.println("/|\\     ||");
            System.out.println(" |      ||");
            System.out.println("/ \\     ||");
            System.out.println("The man is hung... ");
        System.out.println("You are out of guesses play again with another man? Y/N");
        playAgain=input.next().toUpperCase();
        theGame.setGuessCount(0);
        theGame.setWrongGuesses("");
        }
        }while(playAgain.equals("Y"));
    }
}
