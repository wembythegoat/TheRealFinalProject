public class GameStats implements StatsOperations {
    protected String gameDate;
    protected String location;
    protected int totalScore;

    public GameStats() {
        this.gameDate = "";
        this.location = "";
        this.totalScore = 0;
    }

    public GameStats(String gameDate, String location, int totalScore) {
        this.gameDate = gameDate;
        this.location = location;
        this.totalScore = totalScore;
    }

    @Override
    public void displayStats() {
        System.out.println("Game Date: " + gameDate);
        System.out.println("Location: " + location);
        System.out.println("Total Score: " + totalScore);
    }

    /**
     * Adds the provided points to the team's total score.
     * @param points The number of points to be added to the total score.
     */
    public void addScore(int points) {
        if (points < 0) {
            throw new IllegalArgumentException("Points cannot be negative");
        }
        totalScore += points;
    }

    public String getGameDate() {
        return gameDate;
    }

    public void setGameDate(String gameDate) {
        this.gameDate = gameDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
}
