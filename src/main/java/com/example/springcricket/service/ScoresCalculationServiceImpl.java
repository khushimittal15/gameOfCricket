package com.example.springcricket.service;

import com.example.springcricket.NotFoundException;
import com.example.springcricket.dao.TeamDAO;
import com.example.springcricket.entities.*;
import com.example.springcricket.helper.InningImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Double.POSITIVE_INFINITY;

@Service
public class ScoresCalculationServiceImpl implements IScoresCalculationService {
    @Autowired
    IPlayerService playerService;
    @Autowired
    ITeamService teamService;

    @Autowired
    InningImpl inningImpl;

    @Override
    public ScoreBoard generateScoreBoard(Match match){
        List<String> teamNames = match.getTeamNames();
        Team[] teams = {teamService.seeTeamDetails(teamNames.get(0)), teamService.seeTeamDetails(teamNames.get(0))};

        int tossWinnerTeamIndex = Math.random() * 2 <= 1 ? 0 : 1;
        int battingTeamIndex = Preference.BAT.equals(teams[tossWinnerTeamIndex].getTossPreference()) ? tossWinnerTeamIndex : (tossWinnerTeamIndex + 1) % 2;

        List<Pair<String, Status>> team0PlayersIdList = teams[0].getPlayersIdList().stream().filter(stringStatusPair -> stringStatusPair.getSecond().equals(Status.PRESENT)).toList();
        System.out.println(team0PlayersIdList);
        List<Pair<String, Status>> team1PlayersIdList = teams[1].getPlayersIdList().stream().filter(stringStatusPair -> stringStatusPair.getSecond().equals(Status.PRESENT)).toList();
        List<List<Player>> teamPlayers = new ArrayList<>();
        List<Player> team1Players = new ArrayList<>();
        List<Player> team2Players = new ArrayList<>();
        for (Pair<String, Status> IdStatusPair : team0PlayersIdList) {
            team1Players.add(playerService.getPlayerById(IdStatusPair.getFirst()));
        }
        for (Pair<String, Status> IdStatusPair : team1PlayersIdList) {
            team2Players.add(playerService.getPlayerById(IdStatusPair.getFirst()));
        }
        teamPlayers.add(team1Players);
        teamPlayers.add(team2Players);
        int size = Math.min(team0PlayersIdList.size(), team1PlayersIdList.size());
        TeamDAO[] teamDAOs = new TeamDAO[2];
        teamDAOs[0] = TeamDAO.builder().teamName(teams[0].getTeamName()).captainId(teams[0].getCaptainId()).playersList(teamPlayers.get(0)).tossPreference(teams[0].getTossPreference()).build();
        teamDAOs[1] = TeamDAO.builder().teamName(teams[1].getTeamName()).captainId(teams[1].getCaptainId()).playersList(teamPlayers.get(1)).tossPreference(teams[1].getTossPreference()).build();
        System.out.println(battingTeamIndex+"  "+(battingTeamIndex + 1) % 2);
    try {
        Inning inning1 = inningImpl.createInning(teamDAOs[battingTeamIndex], teamDAOs[(battingTeamIndex + 1) % 2], (int) POSITIVE_INFINITY, size, match.getTotalOvers());
        Inning inning2 = inningImpl.createInning(teamDAOs[(battingTeamIndex + 1) % 2], teamDAOs[battingTeamIndex], inning1.getOverallScore(), size, match.getTotalOvers());

        ScoreBoard scoreBoard = ScoreBoard.builder()
                .tossWinningTeam(teams[tossWinnerTeamIndex])
                .innings(new Inning[]{inning1, inning2})
                .winner(inning1.getOverallScore()>inning2.getOverallScore() ? teamDAOs[battingTeamIndex].getTeamName():teamDAOs[(battingTeamIndex + 1) % 2].getTeamName() )
                .build();
        return scoreBoard;
    }
    catch (NotFoundException e)  {
        throw new NotFoundException(e.getMessage());
    }

}
}