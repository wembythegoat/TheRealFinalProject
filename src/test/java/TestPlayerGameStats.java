import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class TestPlayerGameStats {
    @Test
    public void testAddPlayerStats_ValidPlayer() {
        PlayerGameStats gameStats = new PlayerGameStats();
        GuardStats player = new GuardStats("Jrue Holiday", 15, 5, 3, 2, 3);

        gameStats.addPlayerStats(player);

        Assertions.assertTrue(gameStats.getPlayerStats().contains(player));

    }

    @Test
    public void testAddPlayerStats_NullPlayer() {
        PlayerGameStats gameStats = new PlayerGameStats();
        boolean exceptionThrown = false;

        try {
            gameStats.addPlayerStats(null); // Trying to add a null player
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }

        Assertions.assertTrue(exceptionThrown, "Adding a null player should throw an exception.");
    }

    @Test
    public void testDisplayStats() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        PlayerGameStats gameStats = new PlayerGameStats();
        gameStats.addPlayerStats(new GuardStats("Jrue Holiday", 15, 5, 3, 2, 3));

        gameStats.displayStats();

        System.setOut(originalOut);

        String expectedOutput = "Game Player Stats: \n" +
                "Player: Jrue Holiday\n" +
                "Points: 15\n" +
                "Assists: 5\n" +
                "Steal: 3\n" +
                "Assist-to-turnover Ratio: 2.5\n" +
                "---------------------\n";

        Assertions.assertEquals(expectedOutput, outputStream.toString(), "displayStats() output did not match expected format.");
    }
}
