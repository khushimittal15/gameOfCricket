package com.example.springcricket.service;

import com.example.springcricket.dto.PlayerDTO;
import com.example.springcricket.entities.BowlerPerformance;
import com.example.springcricket.entities.Player;

import java.util.List;


public interface IPlayerService {


     String addPlayers(List<PlayerDTO> playerDTOs);

     String addPlayer(PlayerDTO playerdto);
     List<Player> getPlayers();
     void updateBatsman (String playerId, int currentBatsmanScore, int currentBatsmanFours, int currentBatsmanSixes, int currentBatsmanBallsUsed);
     void updateBowler (List<BowlerPerformance> bowlerPerformances) ;
     Player getPlayerById(String playerID);


}
