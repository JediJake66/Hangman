import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class GameMethods {
    private String secretWord;
    private String wrongGuesses;
    private int guessCount;
    private String blanks="";

    public GameMethods(String secretWord,String wrongGuesses,int guessCount){
        this.secretWord=secretWord;
        this.wrongGuesses=wrongGuesses;
        this.guessCount=guessCount;
    }

    public int getGuessCount() {
        return guessCount;
    }

    public String getSecretWord(){

        return secretWord;
    }
    public String getWrongGuesses(){

        return wrongGuesses;
    }
    public String getBlanks() {
        if (blanks.length() != secretWord.length()) {
            for (int i = 0; i < secretWord.length(); i++) {
                blanks+="_";
            }
        }
        System.out.println(blanks);
        return blanks;
    }
    public void setSecretWord(String secretWord){this.secretWord=secretWord;}
    public void setWrongGuesses(String wrongGuesses){
        this.wrongGuesses=wrongGuesses;
    }
    public void setGuessCount(int guessCount){
        this.guessCount=guessCount;
    }
    public void setBlanks(String blanks){this.blanks=blanks;}

    public void reset(){
        setGuessCount(0);
        setWrongGuesses("");
        setBlanks("");
        assignWord();
    }


    public void assignWord(){
        Scanner wordFile=new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>();
        int lineNumber = ThreadLocalRandom.current().nextInt(1, 605);
        try{
            File text = (new File("C:\\GenSpark\\Projects\\Hangman\\src\\main\\java\\wordList.txt"));
            wordFile = new Scanner(text);
        }catch (FileNotFoundException e){
            System.out.println("File not found. List is empty");
            System.exit(0);
        }
        while(wordFile.hasNextLine()){
            words.add(wordFile.nextLine());
        }
        secretWord=words.get(lineNumber).toUpperCase();
    }

    public boolean checker(String guess){
        if(guess.contains("0")||guess.contains("1")||guess.contains("2")||guess.contains("3")||guess.contains("4")||guess.contains("5")||guess.contains("6")||guess.contains("7")||guess.contains("8")||guess.contains("9")){
            System.out.println("You chose a number....DON'T DO THAT!!");
            return false;
        }
        if(secretWord.contains(guess)){
            for(int i=0;i<secretWord.length();i++){
                if(secretWord.charAt(i)==guess.charAt(0)){
                  blanks=blanks.substring(0,i)+guess+blanks.substring(i+1);
                    }
            }
            return true;
        }
        else{
            if(!wrongGuesses.contains(guess)){
            wrongGuesses+=guess;
            guessCount++;
            }
            return false;
          }
        }


        public void winner(){
        if(blanks.equals(secretWord)){
            System.out.println("You Win!!");
            System.out.println("Play again? y/n");
        }
        }
        public void printMan(){
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
            System.out.println("Missed Guesses: " + wrongGuesses);
            System.out.println("Guess a single letter. Multiple letters incur a penalty!");
            System.out.println("You have " +(6-guessCount)+" guesses remaining.");
        }
}


