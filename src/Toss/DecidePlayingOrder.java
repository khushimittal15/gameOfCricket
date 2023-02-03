package Toss;

import MatchInputs.Match;
import TeamDetails.TeamDetails;

public class DecidePlayingOrder {
    public static void decidePlayingOrder() {
        int winningTeam = Toss.getTossResult();
        TeamDetails battingFirst = Toss.takeTossWinningTeamChoice(Match.teams[winningTeam - 1]);
        if (battingFirst == null) {
        } else if (battingFirst == Match.teams[1]) {
            TeamDetails temp = Match.teams[1];
            Match.teams[1] = Match.teams[0];
            Match.teams[0] = temp;
        }
    }
}
