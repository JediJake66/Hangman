import java.util.Objects;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GameMethods theGame = new GameMethods("","",0);
        String guess="";
        String playAgain = "Y";
        StringBuilder guessList = new StringBuilder();
        theGame.assignWord();
        while(playAgain.equals("Y")) {
            theGame.printMan();
            theGame.getBlanks();
            guess = input.nextLine().toUpperCase();
//            var result=
//                    Arrays.stream(theGame.getSecretWord().split(""))
//                            .map(l-> guess.contains(l) ? l : "_")
//                            .reduce((acc,next)-> acc + " " + next)
//                            .get();
//            System.out.println(result);
            if (guessList.toString().contains(guess)) {
                    System.out.println("You've already tried this one");
                }
            else{guessList.append(guess);
            }
            if(guess.length()!=1){
                System.out.println("Please Follow Instructions!");
                theGame.setGuessCount(+1);
            }else {
                    theGame.checker(guess);
            }
        if(theGame.getGuessCount()==6){
            System.out.println(" O      ||");
            System.out.println("/|\\     ||");
            System.out.println(" |      ||");
            System.out.println("/ \\     ||");
            System.out.println("The man is hung... ");
            System.out.println("The secret word was " + theGame.getSecretWord());
        System.out.println("Play again with another man? Y/N");
        playAgain=input.next().toUpperCase();
       theGame.reset();
       guessList.delete(0,guessList.length()-1);
        }else if(Objects.equals(theGame.getBlanks(), theGame.getSecretWord())){
            theGame.winner();
            playAgain=input.next().toUpperCase();
            theGame.reset();
            guessList.delete(0,guessList.length()-1);
        }
        }
    }
}
