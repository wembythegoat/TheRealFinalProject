import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StatsFileManager {

    private static final String FILE_NAME = "stats.txt";

    public static void saveStats(List<PlayerStats> players) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (PlayerStats player : players) {
                String classType = player.getClass().getSimpleName(); // Get subclass type
                writer.println(classType + "," + player.getName() + "," + player.getPoints() + "," +
                        player.getAssists() + "," + player.getRebounds() + "," + player.getTurnovers());
            }
            System.out.println("Stats saved to " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Error saving player stats: " + e.getMessage());
        }
    }

    public static List<PlayerStats> loadStats() {
        List<PlayerStats> players = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    String classType = data[0];
                    String name = data[1];
                    int points = Integer.parseInt(data[2]);
                    int assists = Integer.parseInt(data[3]);
                    int rebounds = Integer.parseInt(data[4]);
                    int turnovers = Integer.parseInt(data[5]);

                    PlayerStats player;
                    switch (classType) {
                        case "GuardStats":
                            player = new GuardStats(name, points, assists, rebounds, turnovers, 0);
                            break;
                        case "ForwardStats":
                            player = new ForwardStats(name, points, assists, rebounds, turnovers, 0.0);
                            break;
                        case "CenterStats":
                            player = new CenterStats(name, points, assists, rebounds, turnovers, 0);
                            break;
                        default:
                            throw new IllegalArgumentException("Unknown player type: " + classType);
                    }
                    players.add(player);
                }
            }
            System.out.println("Stats loaded from " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Error loading player stats: " + e.getMessage());
        }
        return players;
    }
}
