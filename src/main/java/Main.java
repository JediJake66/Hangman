import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GameMethods theGame = new GameMethods("JEDI","");
        int guessCount=0;
        String guess="";
        String playAgain = "Y";
        StringBuilder guessList = new StringBuilder();
        do {
            System.out.println("  H A N G M A N  ");
            System.out.println("++======++");
            System.out.println(" |      ||");
           if(guessCount==0){
            System.out.println("        ||");
            System.out.println("        ||");
            System.out.println("        ||");
            System.out.println("        ||");
           }else if(guessCount==1){
               System.out.println(" O      ||");
               System.out.println("        ||");
               System.out.println("        ||");
               System.out.println("        ||");
           }else if(guessCount==2){
               System.out.println(" O      ||");
               System.out.println(" |      ||");
               System.out.println(" |      ||");
               System.out.println("        ||");
           }else if(guessCount==3){
               System.out.println(" O      ||");
               System.out.println("/|      ||");
               System.out.println(" |      ||");
               System.out.println("        ||");
           }else if(guessCount==4){
               System.out.println(" O      ||");
               System.out.println("/|\\     ||");
               System.out.println(" |      ||");
               System.out.println("        ||");
           }else if(guessCount==5){
               System.out.println(" O      ||");
               System.out.println("/|\\     ||");
               System.out.println(" |      ||");
               System.out.println("/       ||");
            }
            System.out.println("===========");
            System.out.println("Missed Guesses: " + theGame.getWrongGuesses());
            System.out.println("____");
            System.out.println("Guess a single letter. Multiple letters incur a penalty!");
            System.out.println("You have " +(6-guessCount)+" guesses remaining.");
            try{
            guess = input.nextLine().toUpperCase();
            }catch (Exception e) {
                           
            }
            if (guessList.toString().contains(guess)) {
                    System.out.println("You've already tried this one");
                }

            else{guessList.append(guess);
            guessCount++;}
            if(guess.length()!=1){
                System.out.println("Please Follow Instructions!");
            }else{
            theGame.checker(guess);}
        if(guessCount==6){
            System.out.println(" O      ||");
            System.out.println("/|\\     ||");
            System.out.println(" |      ||");
            System.out.println("/ \\     ||");
            System.out.println("The man is hung... ");
        System.out.println("You are out of guesses play again with another man? Y/N");
        playAgain=input.next().toUpperCase();
        guessCount=0;
        theGame.setWrongGuesses("");
        }
        }while(playAgain.equals("Y"));
    }
}
