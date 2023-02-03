package ScoreCalculations;

import MatchInputs.Match;

public class calculateEachBallScores {
    public static String calculateScoreForEachBall(boolean isBowler) {
        double wicketProbability = ((double) (Match.playersInEachTeam)) / (Match.overs * 6) / 2.0;
//        System.out.println("wicket Prob"+wicketProbability);
        if (Math.random() < wicketProbability) {
            return "W";
        }
        int random = (int) (Math.random() * 13);
        String[] batsmanScoreAtBall = {"0", "1", "2", "3", "4", "5", "6", "2", "2", "3", "4", "5", "6"};
        String[] bowlerScoreAtBall = {"0", "0", "1", "1", "1", "2", "2", "3", "4", "5", "6", "0", "W"};

        return isBowler ? bowlerScoreAtBall[random] : batsmanScoreAtBall[random];

    }
}
