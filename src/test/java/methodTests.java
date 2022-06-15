import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class methodTests {


    GameMethods underTest = new GameMethods("CAT","STOP");

@Test
    public void shouldReturnSecretWord(){
    String secret = underTest.getSecretWord();
    assertEquals("CAT",secret);
}
@Test
    public void shouldReturnWrongGuesses(){
    String wrong = underTest.getWrongGuesses();
    assertEquals("STOP",wrong);
}
@Test
    public void shouldReturnTrueIfGuessIsCorrect(){
    boolean check = underTest.checker("A");
    assertEquals(true,check);
}
@Test
    public void shouldReturnFalseIfGuessIsWrong(){
    boolean check = underTest.checker("R");
    assertEquals(false,check);
}
@Test
    public void shouldAddWrongGuessToWrongGuesses(){
    underTest.checker("B");
    String wrong = underTest.getWrongGuesses();
    assertEquals("STOPB",wrong);
}
}
