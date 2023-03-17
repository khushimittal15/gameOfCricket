package com.example.springcricket.service;

import com.example.springcricket.dto.MatchResponseDTO;
import com.example.springcricket.dto.PlayerDTO;
import com.example.springcricket.dto.TeamDTO;
import com.example.springcricket.dto.TeamResponseDTO;
import com.example.springcricket.entities.Team;
import org.springframework.stereotype.Service;

public interface ITeamService {

    TeamResponseDTO addNewTeam(TeamDTO teamdto);

    String addPlayerInTeam(String teamId ,String playerId);

    Team seeTeamDetails(String teamID);

    String removePlayerFromTeam(String teamId, String playerId);
}
