package ScoreCalculations;

import Players.Bowler;
import MatchInputs.Match ;
import TeamDetails.TeamDetails ;
public class playersFinalPerformances {

    public static void playersFinalPerformances() {
        System.out.println("BATSMEN PERFORMANCES :");
        int i = 1;
        for (TeamDetails team : Match.teams) {
            System.out.println("INNING " + i);
            i++;
            System.out.println();
            for (Bowler player : team.getTeam()) {
                player.getBatsmanPerformance();
            }
        }
        System.out.println();
        System.out.println("BOWLERS PERFORMANCES :");
        i = 1;
        for (int idx = 1; idx > -1; idx--) {
            System.out.println("INNING " + i);
            i++;
            System.out.println();
            for (Bowler player : Match.teams[idx].getTeam()) {
                if (player.isBowler()) {
                    player.getBowlerPerformance();
                }


            }
        }
    }
}
