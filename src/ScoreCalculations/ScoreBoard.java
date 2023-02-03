package ScoreCalculations;

import Players.CricketPlayer;
import ScoreCalculations.calculateEachBallScores;
import MatchInputs.Match;

import TeamDetails.TeamDetails;

public class ScoreBoard {
    public static int[] GenerateScoreBoard(TeamDetails team1, TeamDetails team2,Thread th,int prevTeamScore) {

        int wickets = 0;
        int totalScore = 0;
        int currentBowlerIndex = Match.playersInEachTeam - 1;
        CricketPlayer currentBatsman = null;
        for (int over = 0; over < Match.overs; over++) {

            for (int ball = 0; ball < 6; ball++) {
                currentBatsman = team1.getTeam()[wickets];
                String ballResult = calculateEachBallScores.calculateScoreForEachBall(currentBatsman.isBowler());

                team1.addScore(ballResult);
                if (ballResult == "W") {
                    wickets++;
                    if (wickets == Match.playersInEachTeam) {
                        System.out.print(ballResult + "\t");
                        return new int[]{totalScore, wickets};
                    }
                    team1.getTeam()[wickets].changeBatsmanPerformance(-1);
                } else {
                    int run = Integer.parseInt(ballResult);
                    totalScore += run;
                    team1.getTeam()[wickets].changeBatsmanPerformance(run);
                    if(prevTeamScore != -1 &&  totalScore > prevTeamScore){
                        System.out.print(ballResult + "\t");
                        return new int[]{totalScore,wickets} ;
                    }
                }
                System.out.print(ballResult + "\t");
                try {
                    th.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                team2.getTeam()[currentBowlerIndex != -1 ? currentBowlerIndex : Match.playersInEachTeam-1].changeBowlerPerformance(ballResult);
            }
            System.out.println();
            try {
                th.sleep(700);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            currentBowlerIndex = team2.getTeam()[currentBowlerIndex].isBowler() ? currentBowlerIndex-1 : Match.playersInEachTeam - 1 ;

        }

        return new int[]{totalScore, wickets};

    }


}
