package com.example.springcricket.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "players")
@Data
@Builder
public class Player {
    //common properties
    @Id
    String playerId ;
    Status status ;
    private String playerName ;
    private int playerAge ;
    private PlayerType playerType ;
    private int matchPlayed ;
//bowler data
    private int runsGiven ;
    private int oversBowled ;
    private int wicketsTaken ;
//batsman data
    private int runsScored ;
    private int ballsPlayed ;
    private double strikeRate ;
    private int fours ;
    private int sixes ;
//    private boolean inSomeTeam  ;

}
