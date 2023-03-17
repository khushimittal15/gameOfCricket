package com.example.springcricket.dto;

import com.example.springcricket.entities.ScoreBoard;
import com.example.springcricket.entities.Team;
import com.example.springcricket.entities.TossChoice;
import com.example.springcricket.entities.Umpire;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MatchDTO {
    String matchName;
    List<String> teamNames;
    int totalOvers;
    TossChoice choiceOfTeam1;

}
