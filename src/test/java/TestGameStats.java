import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestGameStats {

    @Test
    public void testDisplayStats() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        GameStats gameStats = new GameStats("2025-05-09", "Home", 100);

        gameStats.displayStats();

        System.setOut(originalOut);

        String expectedOutput = "Game Date: 2025-05-09\n" +
                                "Location: Home\n" +
                                "Total Score: 100\n";

        Assertions.assertEquals(expectedOutput, outputStream.toString(), "displayStats() output did not match expected format.");
    }

    @Test
    public void testAddScore_ValidPoints() {
        GameStats gameStats = new GameStats();
        gameStats.addScore(10);
        Assertions.assertEquals(10, gameStats.totalScore);
    }

    @Test
    public void testAddScore_NegativePoints() {
        GameStats gameStats = new GameStats();
        boolean expected = false;

        try {
            gameStats.addScore(-5); // Trying to add negative points
        } catch (IllegalArgumentException e) {
            expected = true;
        }

        Assertions.assertTrue(expected, "Adding negative points should throw an exception.");
    }
}
