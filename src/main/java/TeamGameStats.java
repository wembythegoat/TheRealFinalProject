public class TeamGameStats extends GameStats {
    private int totalFouls;
    private int totalTurnovers;

    public TeamGameStats() {
        this.totalFouls = 0;
        this.totalTurnovers = 0;
    }

    public TeamGameStats(String gameDate, String location, int totalScore, int totalFouls, int totalTurnovers) {
        super(gameDate, location, totalScore);
        this.totalFouls = totalFouls;
        this.totalTurnovers = totalTurnovers;
    }

    /**
     * Calculates the team's efficiency based on total score, fouls, and turnovers.
     * Efficiency is defined as the ratio of total score to the sum of fouls and turnovers.
     * @return The team's efficiency
     */
    public double calculateTeamEfficiency() {
        if (totalFouls == 0 && totalTurnovers == 0) {
            return getTotalScore();
        }
        return (double) getTotalScore() / (totalFouls + totalTurnovers);
    }

    /**
     * Adds the provided points and turnovers to the team's game statistics.
     * Also increases the total fouls randomly within a range of 0 to 4.
     * @param points The number of points scored in the game.
     * @param turnovers The number of turnovers committed.
     */
    public void addStats(int points, int turnovers) {
        addScore(points);
        totalTurnovers += turnovers;
        totalFouls += (int) (Math.random() * 5);
    }

    public int getTotalFouls() {
        return totalFouls;
    }

    public void setTotalFouls(int totalFouls) {
        this.totalFouls = totalFouls;
    }

    public int getTotalTurnovers() {
        return totalTurnovers;
    }

    public void setTotalTurnovers(int totalTurnovers) {
        this.totalTurnovers = totalTurnovers;
    }
}
