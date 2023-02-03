package Players;

public class Bowler extends CricketPlayer {
    private byte wicketsTaken;
    private int runsGiven;
    private int ballsBowled;

    public Bowler(String playerName, int playerAge, boolean isBowler) {
        super(playerName, playerAge, true);
    }

    public void changeBowlerPerformance(String run) {

        if ("W".equals(run)) {
            wicketsTaken++;
        } else {
            runsGiven += Integer.parseInt(run);
        }
        ballsBowled++;
    }

    public void getBowlerPerformance(){
        System.out.println(getPlayerName()+" took "+wicketsTaken+" wickets,gave "+runsGiven+" runs in "+ballsBowled+" balls.");
        System.out.println();
    }
}
