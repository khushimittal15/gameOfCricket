package Players;

public class CricketPlayer {
    private String playerName;
    private int playerAge;
    private boolean isBowler = false;
    private float strikeRate;
    private int scoredTillNow;
    private int numberOfBallsSpent;

    public CricketPlayer(String playerName, int playerAge, boolean isBowler) {
        this.setPlayerName(playerName);
        this.setPlayerAge(playerAge);
        this.setBowler(isBowler);
    }

    public String getPlayerName() {
        return playerName;
    }

    private void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerAge() {
        return playerAge;
    }

    private void setPlayerAge(int getPlayerAge) {
        this.playerAge = getPlayerAge;
    }

    public void setBowler(boolean isBowler) {
        this.isBowler = isBowler;
    }

    public boolean isBowler() {
        return isBowler;
    }

    public void changeBatsmanPerformance(int runs) {
        if(runs != -1){
            scoredTillNow += runs;
        }
        numberOfBallsSpent++;
        strikeRate = (float) ((scoredTillNow / numberOfBallsSpent) * 100);
    }
    public void getBatsmanPerformance(){
        System.out.println("TOTAL RUNS SCORED BY "+playerName+" ARE "+scoredTillNow+" WITH STRIKE RATE OF : "+strikeRate);
        System.out.println("TOTAL BALLS SPENT :"+numberOfBallsSpent);
        System.out.println();
    }


}
