package TeamDetails;

import Players.Bowler;

import java.util.ArrayList;
import MatchInputs.Match ;
import Players.CricketPlayer;

public class TeamDetails {
    private String teamName;
    private int teamSize;
    private Bowler[] team = new Bowler[Match.playersInEachTeam];
    int batsmenCurrentIndex = 0;
    int bowlerCurrentIndex = Match.playersInEachTeam - 1;
    private ArrayList<String> score = new ArrayList<String>();
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Bowler[] getTeam() {
        return team;
    }

    public String getTeamName() {
        return teamName;
    }

    public ArrayList<String> getScore() {
        return score;
    }

    public void addScore(String score) {
        this.score.add(score);
    }

    public void addMembers(String playerName, int playerAge, boolean isBowler) {
        if (isBowler) {
            team[bowlerCurrentIndex] = new Bowler(playerName, playerAge, true);
            bowlerCurrentIndex--;
        } else {
            team[batsmenCurrentIndex] = (Bowler) new Bowler(playerName, playerAge, false);
            batsmenCurrentIndex++;
        }


    }


}
