package com.example.springcricket.service;

import com.example.springcricket.NotFoundException;
import com.example.springcricket.dto.TeamDTO;
import com.example.springcricket.dto.TeamResponseDTO;
import com.example.springcricket.entities.Player;
import com.example.springcricket.entities.Status;
import com.example.springcricket.entities.Team;
import com.example.springcricket.repository.IPlayerRepository;
import com.example.springcricket.repository.ITeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeamServiceImpl implements ITeamService {
    @Autowired
    private ITeamRepository teamRepo;
    @Autowired
    private IPlayerRepository playerRepo;

    @Override
    public TeamResponseDTO addNewTeam(TeamDTO teamdto) {

        TeamResponseDTO response = new TeamResponseDTO();
        Team existingTeam = teamRepo.findById(teamdto.getTeamName()).orElse(null);
        boolean flag = false;
        if (existingTeam == null) {
            Player playercheck = playerRepo.findById(teamdto.getCaptainId()).orElse(null);
            if (playercheck == null) {
                response.setSuccess(false);
                response.setError("Player with playerID " + teamdto.getCaptainId() + " does not exist. First register the player.");
                return response;
            }
            for (String playerId : teamdto.getPlayersIdList()) {

                Player playerCheck = playerRepo.findById(playerId).orElse(null);
                System.out.println(playerCheck);
                if (playerCheck == null) {
                    response.setSuccess(false);
                    response.setError("Player with playerID " + playerId + " does not exist. First register the player.");
                    return response;
                }
                System.out.println(playerId +"   "+teamdto.getCaptainId());
                if (playerId.equals(teamdto.getCaptainId())) {
                    System.out.println("Hey I became true");
                    flag = true;
                }
            }

            List<Pair<String, Status>> players = new ArrayList<>() ;
            for (String playerId : teamdto.getPlayersIdList()) {
                players.add(Pair.of(playerId,Status.PRESENT));
            }
            if (flag == false) {
                players.add(Pair.of(teamdto.getCaptainId(),Status.PRESENT));
            }

            Team team = Team.builder()
                    .teamName(teamdto.getTeamName())
                    .captainId(teamdto.getCaptainId())
                    .playersIdList(players)
                    .tossPreference(teamdto.getTossPreference())
                    .build();
            teamRepo.save(team);
            response.setSuccess(true);
            return response;
        }
        response.setSuccess(false);
        response.setError("This team already exists. Choose different team name.");
        return response;
    }


    @Override
    public String addPlayerInTeam(String teamId, String playerId) {
        Team team = teamRepo.findById(teamId).orElse(null);
        if (team == null) {
            return "No such team exists";
        }
        Player playercheck = playerRepo.findById(playerId).orElse(null);
        List<Pair<String, Status>> players = team.getPlayersIdList();
        players.add(Pair.of(playerId,Status.PRESENT));
        team.setPlayersIdList(players); //check if its mandatory or not
        teamRepo.save(team) ;
        return "player added successfully!";
    }

    @Override
    public Team seeTeamDetails(String teamID) {
        return teamRepo.findById(teamID).orElse(null);
    }

    @Override
    @Query
    public String removePlayerFromTeam(String teamID, String playerId) {
        Team team = teamRepo.findById(teamID).orElse(null);
        if (team == null) {
            return "No such team exists";
        }
        List<Pair<String, Status>> players = team.getPlayersIdList();
        players.set(players.indexOf(Pair.of(playerId,Status.PRESENT)),Pair.of(playerId,Status.DELETED));

        return "player removed successfully!";
    }

}
