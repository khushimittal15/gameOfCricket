package com.example.springcricket.controller;

import com.example.springcricket.dto.MatchResponseDTO;
import com.example.springcricket.dto.TeamDTO;
import com.example.springcricket.dto.TeamResponseDTO;
import com.example.springcricket.entities.Team;
import com.example.springcricket.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    private ITeamService teamService ;
    @PostMapping
    public TeamResponseDTO addNewTeam(@RequestBody TeamDTO teamdto){
        return teamService.addNewTeam(teamdto) ;
    }

    @PatchMapping("/{teamId}/addPlayerUsingId")
    public String addExistingPlayerInTeam(@RequestBody String playerId,@PathVariable("teamId") String teamId){
        return teamService.addPlayerInTeam(teamId,playerId) ;
    }

    @PostMapping("/{teamId}/removePlayerUsingId")
    public String removeExistingPlayerInTeam(@RequestBody String playerId,@PathVariable("teamId") String teamId){
        return teamService.removePlayerFromTeam(teamId,playerId) ;
    }

    @GetMapping("/{teamId}")
    public Team seeTeamDetails(@PathVariable("teamId") String teamID){
        return teamService.seeTeamDetails(teamID);
    }
}
