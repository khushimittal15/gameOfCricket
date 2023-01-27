public class TeamDetails {
    private String teamName ;
    private CricketPlayer[] team = new CricketPlayer[5] ;
    private int countOfPlayers = 0 ;
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void addMembers(String playerName, int playerAge){
        team[countOfPlayers]  =  new CricketPlayer();
        team[countOfPlayers].setPlayerDetails(playerName, playerAge);
        countOfPlayers++ ;
    }

}
