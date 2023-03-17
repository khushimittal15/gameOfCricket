package com.example.springcricket.helper;

import com.example.springcricket.NotFoundException;
import com.example.springcricket.dao.TeamDAO;
import com.example.springcricket.entities.*;
import com.example.springcricket.service.IPlayerService;
import com.example.springcricket.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InningImpl {
    @Autowired
    IPlayerService playerService;

    public Inning createInning(TeamDAO battingTeam, TeamDAO bowlingTeam, int prevScore, int teamSize, int overs) throws NotFoundException {
        if(battingTeam.getTeamName().equals(bowlingTeam.getTeamName())){
            System.out.println("TEAMS ARE SAME");
        }
        List<BatsmanPerformance> batsmanPerformances = new ArrayList<>();
        List<BowlerPerformance> bowlerPerformances = new ArrayList<>();
        List<String> scoreList = new ArrayList<>();
        int overallScore = 0;
        int wicketsFallen = 0;
        int fours = 0;
        int sixes = 0;
        int currentBatsmanScore = 0;
        int currentBatsmanBallsUsed = 0;
        int currentBatsmanFours = 0;
        int currentBatsmanSixes = 0;

        List<Player> bowlers = bowlingTeam.getPlayersList().stream().filter(player -> PlayerType.BOWLER.equals(player.getPlayerType()) || PlayerType.ALL_ROUNDER.equals(player.getPlayerType())).toList();
        if (bowlers.isEmpty()) {
            throw new NotFoundException("Bowlers or All Rounders are not present in the team so the match can't be played.");
        }
        int numberOfBowlers = bowlers.size();
        int batsmanIndex = 0, bowlerIndex = 0;
        int runsGivenInOver = 0;
        int wicketsTakenInOver = 0;
        for (int over = 1; over <= overs; over++) {
            runsGivenInOver = 0;
            wicketsTakenInOver = 0;
            for (int ball = 1; ball <= 6; ball += 1) {
                String score = RandomNumberGenerator.getScore(battingTeam.getPlayersList().get(batsmanIndex).getPlayerType(), teamSize, overs);
                scoreList.add(score);
                currentBatsmanBallsUsed++;
                if ("W".equals(score)) {
                    wicketsTakenInOver++;
                    wicketsFallen++;
                    batsmanPerformances.add(BatsmanPerformance.builder().playerId(battingTeam.getPlayersList().get(batsmanIndex).getPlayerId()).ballsUsed(currentBatsmanBallsUsed).runs(currentBatsmanScore).fours(currentBatsmanFours).sixes(currentBatsmanSixes).build());
                    playerService.updateBatsman(battingTeam.getPlayersList().get(batsmanIndex).getPlayerId(), currentBatsmanScore, currentBatsmanFours, currentBatsmanSixes, currentBatsmanBallsUsed);
                    batsmanIndex += 1;
                    currentBatsmanScore = 0;
                    currentBatsmanBallsUsed = 0;
                    currentBatsmanFours = 0;
                    currentBatsmanSixes = 0;
                    if (wicketsFallen == teamSize) {
                        return Inning.builder().batsmanPerformances(batsmanPerformances).bowlerPerformances(bowlerPerformances).fours(fours).sixes(sixes).overallScore(overallScore).wicketsFallen(wicketsFallen).scoreList(scoreList).build();
                    }
                } else if ("4".equals(score)) {
                    overallScore += 4;
                    fours += 1;
                    currentBatsmanFours += 1;
                    currentBatsmanScore += 4;
                    runsGivenInOver += 4;
                } else if ("6".equals(score)) {
                    overallScore += 6;
                    sixes += 1;
                    currentBatsmanSixes = 1;
                    currentBatsmanScore += 6;
                    runsGivenInOver += 6;
                } else {
                    int val = Integer.parseInt(score);
                    overallScore += val;
                    currentBatsmanScore += val;
                    runsGivenInOver += val;
                }
                if (overallScore > prevScore) {
                    break;
                }
            }
            if (bowlerPerformances.size() < bowlerIndex + 1) {
                bowlerPerformances.add(BowlerPerformance.builder().oversBowled(1).wicketsTaken(wicketsTakenInOver).playerId(bowlers.get(bowlerIndex).getPlayerId()).runsGiven(runsGivenInOver).build());
            } else {
                BowlerPerformance bowlerPerformanceTillNow = bowlerPerformances.get(bowlerIndex);
                bowlerPerformanceTillNow.setOversBowled(bowlerPerformanceTillNow.getOversBowled() + 1);
                bowlerPerformanceTillNow.setRunsGiven(bowlerPerformanceTillNow.getRunsGiven() + runsGivenInOver);
                bowlerPerformanceTillNow.setWicketsTaken(bowlerPerformanceTillNow.getWicketsTaken() + wicketsTakenInOver);

            }

            bowlerIndex = (bowlerIndex + 1) % numberOfBowlers;

        }

        playerService.updateBowler(bowlerPerformances);

        batsmanPerformances.add(BatsmanPerformance.builder().playerId(battingTeam.getPlayersList().get(batsmanIndex).getPlayerId()).ballsUsed(currentBatsmanBallsUsed).runs(currentBatsmanScore).fours(currentBatsmanFours).sixes(currentBatsmanSixes).build());
        playerService.updateBatsman(battingTeam.getPlayersList().get(batsmanIndex).getPlayerId(), currentBatsmanScore, currentBatsmanFours, currentBatsmanSixes, currentBatsmanBallsUsed);
        return Inning.builder().batsmanPerformances(batsmanPerformances).bowlerPerformances(bowlerPerformances).fours(fours).sixes(sixes).overallScore(overallScore).wicketsFallen(wicketsFallen).scoreList(scoreList).build();
    }

}
