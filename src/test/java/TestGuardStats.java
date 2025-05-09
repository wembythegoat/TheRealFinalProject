import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class TestGuardStats {
    @Test
    public void testCalculateAssistToTurnoverRatio_ValidValues() {
        GuardStats player = new GuardStats("Trae Young", 30, 10, 4, 1, 1);

        double ratio = player.calculateAssistToTurnoverRatio(2);

        Assertions.assertEquals(5, ratio);
    }

    @Test
    public void testCalculateAssistToTurnoverRatio_0_Turnovers() {
        GuardStats player = new GuardStats("Steph Curry", 31, 6, 5, 0, 2);

        double ratio = player.calculateAssistToTurnoverRatio(0);

        Assertions.assertEquals(0, ratio);
    }

    @Test
    public void testCalculateAssistToTurnoverRatio_InvalidValues() {
        GuardStats player = new GuardStats("Ja Morant", 28, 6, 6, 2, 1);

        try {
            player.calculateAssistToTurnoverRatio(-5);
            Assertions.fail("Expected IllegalArgumentException was not thrown.");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Turnovers cannot be negative.", e.getMessage());
        }
    }

    @Test
    public void TestDisplayStats() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        GuardStats player = new GuardStats("Jrue Holiday", 15, 5, 3, 2, 3);

        player.displayStats();

        System.setOut(originalOut);

        String expectedOutput = "Player: Jrue Holiday\n" +
                                "Points: 15\n" +
                                "Assists: 5\n" +
                                "Steal: 3\n" +
                                "Assist-to-turnover Ratio: 2.5\n";

        Assertions.assertEquals(expectedOutput, outputStream.toString(), "displayStats() output did not match expected format.");

    }

    @Test
    public void testCompareTo_HigherRatioWins() {
        GuardStats player1 = new GuardStats("Jrue Holiday", 15, 10, 3, 2, 3);
        GuardStats player2 = new GuardStats("Ja Morant", 28, 6, 6, 3, 1);

        Assertions.assertTrue(player1.compareTo(player2) > 0, "Player One should be ranked higher.");
    }

    @Test
    public void testCompareTo_LowerRatioLoses() {
        GuardStats player1 = new GuardStats("Jrue Holiday", 15, 8, 3, 4, 3);
        GuardStats player2 = new GuardStats("Ja Morant", 28, 12, 6, 3, 1);

        Assertions.assertTrue(player1.compareTo(player2) < 0, "Player One should be ranked lower.");
    }
}
