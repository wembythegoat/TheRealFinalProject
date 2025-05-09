public class ForwardStats extends PlayerStats implements StatsOperations {
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
     *
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(PlayerStats o) {
        ForwardStats otherForward = (ForwardStats) o;
        return Double.compare(this.calculateEfficiency(10, 20), otherForward.calculateEfficiency(10, 20));
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
     * Adds the provided stats to the player's existing totals.
     * @param points The number of points scored by the player in a game.
     * @param rebounds The number of rebounds secured by the player.
     * @param assists The number of assists made by the player.
     */
    public void addStats(int points, int rebounds, int assists) {
        if (points < 0 || assists < 0 || rebounds < 0) {
            throw new IllegalArgumentException("Stats cannot be negative.");
        }
        super.addStats(points, assists, rebounds);
    }

    public double getFieldGoalPercentage() {
        return fieldGoalPercentage;
    }

    public void setFieldGoalPercentage(double fieldGoalPercentage) {
        this.fieldGoalPercentage = fieldGoalPercentage;
    }
}