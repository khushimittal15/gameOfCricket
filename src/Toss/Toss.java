package Toss;

import java.lang.Math;
import java.util.Scanner;
import MatchInputs.Match ;
import TeamDetails.TeamDetails ;
public class Toss {
    public static int getTossResult() {
        Scanner sc = new Scanner(System.in);
        System.out.println("TEAM " + Match.teams[Math.random() > 0.5 ? 1 : 0].getTeamName() + " CHOOSE HEAD OR TAILS. FOR HEAD PRESS 0 FOR TAILS PRESS 1");
        int team1TossChoice = sc.nextInt();
        return doToss(team1TossChoice);

    }

    public static TeamDetails takeTossWinningTeamChoice(TeamDetails winningTeam) {
        System.out.println("TEAM " + winningTeam.getTeamName() + " , YOU WON THE TOSS. TO BAT FIRST PRESS 0, TO BOWL FIRST PRESS 1");
        Scanner sc = new Scanner(System.in);
        String choice = sc.next();
        if (choice.equals("0")) {
            return winningTeam;
        }
        return null;
    }

    private static int doToss(int team1TossChoice) {
        double tossVal = Math.random();
        int tossResult = tossVal < 0.5 ? 1 : 0;

        if (team1TossChoice == tossResult) {
            return 1;
        }
        return 2;
    }
}
