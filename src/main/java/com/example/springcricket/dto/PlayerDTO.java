package com.example.springcricket.dto;

import com.example.springcricket.entities.PlayerType;
import lombok.Data;

@Data
public class PlayerDTO {
    private String playerName ;
    private int playerAge ;
    private PlayerType playerType ;


}
