import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
