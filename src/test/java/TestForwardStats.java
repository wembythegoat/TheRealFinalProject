import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestForwardStats {
    @Test
    public void testCalculateEfficiency() {
        ForwardStats player = new ForwardStats("LeBron James", 25, 7, 8, 3, 50.0);

        double efficiency = player.calculateEfficiency(10, 20);

        Assertions.assertEquals(21.666666666666668, efficiency);
    }

    @Test
    public void testCompareTo() {
        ForwardStats player1 = new ForwardStats("LeBron James", 25, 7, 8, 3, 50.0);
        ForwardStats player2 = new ForwardStats("Kevin Durant", 27, 5, 7, 2, 55.0);

        Assertions.assertFalse(player1.compareTo(player2) < 0);
    }

    @Test
    public void testDisplayStatus() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        ForwardStats player = new ForwardStats("LeBron James", 25, 7, 8, 3, 50.0);
        player.displayStats();

        System.setOut(originalOut);
        String expectedOutput = "Player: LeBron James\n" +
                "Points: 25\n" +
                "Assists: 7\n" +
                "Rebounds: 8\n" +
                "Field Goal Percentage: 50.0%\n" +
                "Efficiency Rating: 21.666666666666668\n";

        Assertions.assertEquals(expectedOutput, outputStream.toString(), "displayStats() output doesn't match expected format.");
    }

    @Test
    public void testAddStats() {
        ForwardStats player = new ForwardStats("LeBron James", 25, 7, 8, 3, 50.0);
        player.addStats(10, 3, 2);

        Assertions.assertEquals(35, player.getPoints());
        Assertions.assertEquals(9, player.getAssists());
        Assertions.assertEquals(11, player.getRebounds());
    }
}
