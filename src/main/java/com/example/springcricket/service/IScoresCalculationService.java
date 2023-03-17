package com.example.springcricket.service;

import com.example.springcricket.entities.Match;
import com.example.springcricket.entities.ScoreBoard;
import org.springframework.stereotype.Service;


public interface IScoresCalculationService {
    ScoreBoard generateScoreBoard(Match match);
}
