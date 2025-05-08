import java.util.ArrayList;
import java.util.List;

public class PlayerGameStats extends GameStats {
    private List<PlayerStats> playerStats;

    public PlayerGameStats() {
        this.playerStats = new ArrayList<>();
    }

    public PlayerGameStats(String gameDate, String location, int totalScore, List<PlayerStats> playerStats) {
        super(gameDate, location, totalScore);
        this.playerStats = playerStats;
    }

    /**
     *
     * @param player
     */
    public void addPlayerStats(PlayerStats player) {
        if (player == null) {
            throw new IllegalArgumentException("You can't add a null player");
        }
        playerStats.add(player);
    }

    @Override
    public void displayStats() {
        System.out.println("Game Player Stats: ");
        for (PlayerStats player : playerStats) {
            player.displayStats();
            System.out.println("---------------------");
        }
    }

    public List<PlayerStats> getPlayerStats() {
        return playerStats;
    }

    public void setPlayerStats(List<PlayerStats> playerStats) {
        this.playerStats = playerStats;
    }
}
