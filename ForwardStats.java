import java.io.Serializable;
public class ForwardStats extends PlayerStats implements StatsOperations, Comparable<ForwardStats> {
    private double fieldGoalPercentage;

    public ForwardStats() {
        this.fieldGoalPercentage = 0;
    }

    public ForwardStats(String name, int points, int assists, int rebounds, int turnovers, double fieldGoalPercentage) {
        super(name, points, assists, rebounds, turnovers);
        this.fieldGoalPercentage = fieldGoalPercentage;
    }

    /**
     * Calculates efficiency based on field goal percentage, rebounds, and assists.
     * @param fieldGoalMade Number of successful shots made.
     * @param fieldGoalAttempted Number of total attempts.
     * @return Efficiency rating.
     */
    public double calculateEfficiency(int fieldGoalMade, int fieldGoalAttempted) {
        if (fieldGoalAttempted == 0) {
            return 0;
        }
        double fgPercentage = ((double) fieldGoalMade / fieldGoalAttempted) * 100;
        return (fgPercentage + super.getRebounds() + super.getAssists()) / 3;
    }

    /**
     * Compares two ForwardStats players based on efficiency rating.
     * @param other Another ForwardStats player.
     * @return -1, 0, or 1 based on comparison.
     */
    @Override
    public int compareTo(ForwardStats other) {
        return Double.compare(this.fieldGoalPercentage, other.fieldGoalPercentage);
    }

    /**
     * Displays player's stats, including efficiency rating.
     */
    @Override
    public void displayStats() {
        System.out.println("Player: " + super.getName());
        System.out.println("Points: " + super.getPoints());
        System.out.println("Assists: " + super.getAssists());
        System.out.println("Rebounds: " + super.getRebounds());
        System.out.println("Field Goal Percentage: " + fieldGoalPercentage + "%");
        System.out.println("Efficiency Rating: " + calculateEfficiency(10, 20)); // Example values
    }

    /**
     * Adds forward-specific stats.
     */
    public void addStats(int points, int rebounds, int assists) {
        super.addStats(points, assists, rebounds);
    }
}