public class GameMethods {
    private String secretWord = "CAT";
    private String wrongGuesses;

    public GameMethods(String secretWord,String wrongGuesses){
        this.secretWord=secretWord;
        this.wrongGuesses=wrongGuesses;
    }

    public String getSecretWord(){

        return secretWord;
    }
    public String getWrongGuesses(){

        return wrongGuesses;
    }
    public void setWrongGuesses(String wrongGuesses){
        this.wrongGuesses=wrongGuesses;
    }

    public boolean checker(String guess){
        if(secretWord.contains(guess)){
            System.out.println("play again? y/n");
            return true;
        }else{
            if(!wrongGuesses.contains(guess)){
            wrongGuesses+=guess;}
            return false;
        }

        }
    }

