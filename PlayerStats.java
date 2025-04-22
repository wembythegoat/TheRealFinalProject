public abstract class PlayerStats implements Comparable<PlayerStats>, StatsOperations {
    protected String name;
    protected int points;
    protected int assists;
    protected int rebounds;
    protected int turnovers;

    public PlayerStats() {
        this.name = "";
        this.points = 0;
        this.assists = 0;
        this.rebounds = 0;
        this.turnovers = 0;
    }

    public PlayerStats(String name, int points, int assists, int rebounds, int turnovers) {
        this.name = name;
        this.points = points;
        this.assists = assists;
        this.rebounds = rebounds;
        this.turnovers = turnovers;
    }

    /**
     *
     */
    @Override
    public void addStats() {
        if (points < 0 || assists < 0 || rebounds < 0 || turnovers < 0) {
            throw new IllegalArgumentException("Stats cannot be negative.");
        }
        this.points += points;
        this.assists += assists;
        this.rebounds += rebounds;
        this.turnovers += turnovers;
    }

    /**
     *
     */
    @Override
    public void displayStats() {
        System.out.println("Player: " + name);
        System.out.println("Points: " + points);
        System.out.println("Assists: " + assists);
        System.out.println("Rebounds: " + rebounds);
        System.out.println("Turnovers: " + turnovers);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "PlayerStats{" +
                "name='" + name + '\'' +
                ", points=" + points +
                ", assists=" + assists +
                ", rebounds=" + rebounds +
                ", turnovers=" + turnovers +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getRebounds() {
        return rebounds;
    }

    public void setRebounds(int rebounds) {
        this.rebounds = rebounds;
    }

    public int getTurnovers() {
        return turnovers;
    }

    public void setTurnovers(int turnovers) {
        this.turnovers = turnovers;
    }
    // TODO DO GuardStats, ForwardStats, and CenterStats
}
