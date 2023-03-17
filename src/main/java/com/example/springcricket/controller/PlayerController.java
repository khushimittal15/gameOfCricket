package com.example.springcricket.controller;

import com.example.springcricket.dto.PlayerDTO;
import com.example.springcricket.entities.Player;
import com.example.springcricket.service.IPlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseStatus
@RestController
@RequestMapping("/player")
public class PlayerController {
    private final IPlayerService playerService;
    public PlayerController(IPlayerService playerService) {
        this.playerService = playerService;
    }
    @PostMapping("/addMany")
    String addPlayers(@RequestBody List<PlayerDTO> playerDTOs){
        return playerService.addPlayers(playerDTOs) ;
    }
    @PostMapping
    @ResponseBody
    public String addPlayer(@RequestBody PlayerDTO playerdto) {
        System.out.println(playerdto.getPlayerName());
        return playerService.addPlayer(playerdto);
    }

    @ResponseBody
    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getPlayers();
    }
    @GetMapping("/{playerID}")
    public Player getPlayerById(@PathVariable("playerID") String playerID){
        return playerService.getPlayerById(playerID);
    }


}