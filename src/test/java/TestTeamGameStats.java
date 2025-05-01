import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTeamGameStats {
    @Test
    public void testCalculateTeamEfficiency_NoFoulsOrTurnovers() {
        TeamGameStats teamGameStats = new TeamGameStats("2024-04-15", "Home", 100, 0, 0);

        Assertions.assertEquals(100.0, teamGameStats.calculateTeamEfficiency());
    }

    @Test
    public void testCalculateTeamEfficiency_ValidStats() {
        TeamGameStats teamStats = new TeamGameStats("2024-04-15", "Away", 120, 10, 5);

        Assertions.assertEquals(120.0 / (10 + 5), teamStats.calculateTeamEfficiency());
    }

    @Test
    public void testCalculateTeamEfficiency_HighFoulsAndTurnovers() {
        TeamGameStats teamStats = new TeamGameStats("2024-04-15", "Neutral", 100, 20, 10);
        Assertions.assertEquals(100.0 / (20 + 10), teamStats.calculateTeamEfficiency(), 0.001, "Efficiency should decrease with higher fouls/turnovers.");
    }

    @Test
    public void testAddStats() {
        TeamGameStats teamGameStats = new TeamGameStats("2024-04-15", "Home", 80, 10, 5);

        teamGameStats.addStats(20, 3);

        Assertions.assertEquals(100, teamGameStats.getTotalScore());
        Assertions.assertEquals(8, teamGameStats.getTotalTurnovers());
    }
}
