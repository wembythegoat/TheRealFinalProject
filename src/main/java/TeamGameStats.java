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
     *
     * @return
     */
    public double calculateTeamEfficiency() {
        if (totalFouls == 0 && totalTurnovers == 0) {
            return getTotalScore();
        }
        return (double) getTotalScore() / (totalFouls + totalTurnovers);
    }

    /**
     *
     * @param points
     * @param turnovers
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
// TODO PlayerGameStats
