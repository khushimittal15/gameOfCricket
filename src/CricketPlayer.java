public class CricketPlayer {
    private String playerName ;
    private int playerAge ;
    public void setPlayerDetails(String playerName, int playerAge){
        this.setPlayerName(playerName);
        this.setPlayerAge(playerAge);
    }

    private String getPlayerName() {
        return playerName;
    }

    private void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    private int getPlayerAge() {
        return playerAge;
    }

    private void setPlayerAge(int getPlayerAge) {

        this.playerAge = getPlayerAge;
    }
}
