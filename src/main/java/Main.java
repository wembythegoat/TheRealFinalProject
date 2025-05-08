import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] arg) {
        List<PlayerStats> players = new ArrayList<>();
        players.add(new GuardStats("Stephen Curry", 30, 8, 4, 2, 2));
        players.add(new ForwardStats("LeBron James", 25, 10, 9, 3, 50.0));
        players.add(new CenterStats("Joel Embiid", 28, 4, 12, 2, 5));

        StatsFileManager.saveStats(players);

        List<PlayerStats> loadedPlayers = StatsFileManager.loadStats();
        for (PlayerStats player : loadedPlayers) {
            System.out.println(player);
        }

    }
    //TODO DO THAT AND DO THIS WITH A LITTLE BIT OF THAT
}
