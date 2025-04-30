public class CenterStats extends PlayerStats implements StatsOperations {
    private int blocks;

    public CenterStats() {
        this.blocks = 0;
    }

    public CenterStats(String name, int points, int assists, int rebounds, int turnovers, int blocks) {
        super(name, points, assists, rebounds, turnovers);
        this.blocks = blocks;
    }

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

    public void addStats(int points, int assists, int rebounds, int turnovers, int blocks) {
        super.addStats(points, assists, rebounds);
        this.blocks = blocks;
    }

    @Override
    public int compareTo(PlayerStats o) {
        return blocks - ((CenterStats) o).blocks;
    }
}
