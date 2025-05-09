public class CenterStats extends PlayerStats implements StatsOperations {
    private int blocks;

    public CenterStats() {
        this.blocks = 0;
    }

    public CenterStats(String name, int points, int assists, int rebounds, int turnovers, int blocks) {
        super(name, points, assists, rebounds, turnovers);
        this.blocks = blocks;
    }

    /**
     * Calculates the player's block rate per game.
     * This metric represents the average number of blocks made by the player over a given number of games.
     * @param totalGames The total number of games played. Must be zero or a positive integer.
     * @return The block rate
     */
    public double calculateBlockRate(int totalGames) {
        if (totalGames == 0) {
            return 0;
        }
        return (double) blocks / totalGames;
    }

    @Override
    public void displayStats() {
        System.out.println("Player: " + super.getName());
        System.out.println("Points: " + super.getPoints());
        System.out.println("Assists: " + super.getAssists());
        System.out.println("Rebounds: " + super.getRebounds());
        System.out.println("Blocks: " + blocks);
        System.out.println("Block Rate: " + calculateBlockRate(10));
    }

    /**
     * Adds the provided stats to the player's existing totals.
     * @param points The number of points scored by the player.
     * @param assists The number of assists made.
     * @param rebounds The number of rebounds secured.
     * @param turnovers The number of turnovers committed.
     * @param blocks The number of blocks recorded.
     */
    public void addStats(int points, int assists, int rebounds, int turnovers, int blocks) {
        if (points < 0 || assists < 0 || rebounds < 0 || turnovers < 0 || blocks < 0) {
            throw new IllegalArgumentException("Stats cannot be negative.");
        }
        super.addStats(points, assists, rebounds);
        this.blocks += blocks;
    }

    /**
     * Compares this center player's block count with another center player's.
     * @param o the object to be compared.
     * @return A negative integer if this player has fewer blocks,
     *        zero if both players have the same number of blocks,
     *        a positive integer if this player has more blocks.
     */
    @Override
    public int compareTo(PlayerStats o) {
        return blocks - ((CenterStats) o).blocks;
    }

    public int getBlocks() {
        return blocks;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }
}
