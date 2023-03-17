package com.example.springcricket.helper;

import com.example.springcricket.entities.PlayerType;
import org.springframework.stereotype.Component;

@Component
public class RandomNumberGenerator {
    public static String getScore(PlayerType playerType, int teamSize, int overs){
        double wicketProbability = ((double) (teamSize)) / (overs * 6) / 2.0;
//        System.out.println("wicket Prob"+wicketProbability);
        if (Math.random() < wicketProbability) {
            return "W";
        }
        int random = (int) (Math.random() * 13);
        String[] batsmanScoreAtBall = {"0", "1", "2", "3", "4", "5", "6", "2", "2", "3", "4", "5", "6"};
        String[] bowlerScoreAtBall = {"0", "0", "1", "1", "1", "2", "2", "3", "4", "5", "6", "0", "W"};

        return playerType == PlayerType.BOWLER ? bowlerScoreAtBall[random] : batsmanScoreAtBall[random];
    }
}
