package ScoreCalculations;

import MatchInputs.Match ;
public class CalculateScores {

    public static void calculateScores(Thread th)  {


        int[] team1Score = ScoreBoard.GenerateScoreBoard(Match.teams[0], Match.teams[1],th,-1);
        try {
            th.sleep(1000) ;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        System.out.println("SCORE OF " + Match.teams[0].getTeamName() + " : " + team1Score[0] + "/" + team1Score[1]);
        System.out.println(Match.teams[0].getTeamName() + "'s inning is over");
        System.out.println();


        int[] team2Score = ScoreBoard.GenerateScoreBoard(Match.teams[1], Match.teams[0],th,team1Score[0]);
        try {
            th.sleep(1000) ;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println();
        System.out.println("SCORE OF " + Match.teams[1].getTeamName() + " : " + team2Score[0] + "/" + team2Score[1]);
        System.out.println(Match.teams[1].getTeamName() + "'s inning is over");
        System.out.println();

        try {
            th.sleep(1000) ;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (team1Score[0] > team2Score[0]) System.out.printf("TEAM " + Match.teams[0].getTeamName() + " WON THE MATCH");
        else if (team2Score[0] > team1Score[0]) System.out.println("TEAM " + Match.teams[1].getTeamName() + " WON THE MATCH");
        else System.out.println("MATCH DRAW");
        System.out.println();
    }



}
