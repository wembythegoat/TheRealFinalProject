import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestCenterStats {
    @Test
    public void testCalculateBlockRate_ValidGames() {
        CenterStats player = new CenterStats("Joel Embiid", 25, 5, 10, 3, 40);
        double blockRate = player.calculateBlockRate(20);

        Assertions.assertEquals(2.0, blockRate);
    }

    @Test
    public void testCalculateBlockRate_ZeroGames() {
        CenterStats player = new CenterStats("Joel Embiid", 25, 5, 10, 3, 40);
        double blockRate = player.calculateBlockRate(0);

        Assertions.assertEquals(0.0, blockRate);
    }

    @Test
    public void testCompareTo() {
        CenterStats player1 = new CenterStats("Joel Embiid", 25, 5, 10, 3, 40);
        CenterStats player2 = new CenterStats("Rudy Gobert", 20, 4, 12, 2, 50);

        Assertions.assertTrue(player1.compareTo(player2) < 0);
        Assertions.assertTrue(player2.compareTo(player1) > 0);
        Assertions.assertEquals(-10, player1.compareTo(player2));
    }

    @Test
    public void testAddStats() {
        CenterStats player = new CenterStats("Joel Embiid", 25, 5, 10, 3, 40);
        player.addStats(10, 3, 2, 3, 5);

        Assertions.assertEquals(35, player.getPoints());
        Assertions.assertEquals(8, player.getAssists());
        Assertions.assertEquals(12, player.getRebounds());
        Assertions.assertEquals(6, player.getTurnovers());
    }

    @Test
    public void testDisplayStats() {
        // Arrange: Redirect console output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Create a test player instance
        CenterStats player = new CenterStats("Jokic", 30, 8, 10, 5, 5);

        // Act: Call displayStats()
        player.displayStats();

        // Restore system output
        System.setOut(originalOut);

        // Expected output (formatted properly)
        String expectedOutput = "Player: Jokic\n" +
                "Points: 30\n" +
                "Assists: 8\n" +
                "Rebounds: 10\n" +
                "Blocks: 5\n" +
                "Block Rate: " + player.calculateBlockRate(10) + "\n";

        // Assert: Compare captured output with expected result
        Assertions.assertEquals(expectedOutput, outputStream.toString(), "displayStats() output did not match expected format.");
    }
}

