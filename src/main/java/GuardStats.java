public class GuardStats extends PlayerStats implements StatsOperations {
    private int steals;

    public GuardStats() {
        this.steals = 0;
    }

    public GuardStats(String name, int points, int assists, int rebounds, int turnovers, int steals) {
        super(name, points, assists, rebounds, turnovers);
        this.steals = steals;
    }

    /**
     *
     * @param turnovers
     * @return
     */
    public double calculateAssistToTurnoverRatio(int turnovers) {
        if (turnovers == 0) {
            return 0;
        }

        if (turnovers < 0) {
            throw new IllegalArgumentException("Turnovers cannot be negative.");
        }

        return (double) assists / turnovers;
    }

    @Override
    public void displayStats() {
        System.out.println("Player: " + getName());
        System.out.println("Points: " + getPoints());
        System.out.println("Assists: " + getAssists());
        System.out.println("Steal: " + steals);
        System.out.println("Assist-to-turnover Ratio: " + calculateAssistToTurnoverRatio(turnovers));
    }

    @Override
    public int compareTo(PlayerStats o) {
        return Double.compare(calculateAssistToTurnoverRatio(turnovers), calculateAssistToTurnoverRatio(o.turnovers));

    }

    /**
     *
     * @param points
     * @param assists
     * @param steals
     */
    public void addStats(int points, int assists, int steals) {
        if (points < 0 || assists < 0 || rebounds < 0 || turnovers < 0) {
            throw new IllegalArgumentException("Stats cannot be negative.");
        }
        super.addStats(points, assists, 0);
        this.steals += steals;
    }

    public int getSteals() {
        return steals;
    }

    public void setSteals(int steals) {
        this.steals = steals;
    }
}
