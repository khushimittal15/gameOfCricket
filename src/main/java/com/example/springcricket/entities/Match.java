package com.example.springcricket.entities;

import com.example.springcricket.dto.TeamDTO;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@Document(collection = "matches")
public class Match {
    @Id
    UUID matchId ;
    String matchName;
    List<String> teamNames;
    Umpire umpire ;
    ScoreBoard scoreboard ;
    Date date ;
    TossChoice choiceOfTeam1 ;
    int numberOfPlayers ;
    int totalOvers ;


}
