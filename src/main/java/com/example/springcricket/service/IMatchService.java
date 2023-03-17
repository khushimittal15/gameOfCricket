package com.example.springcricket.service;

import com.example.springcricket.dto.MatchDTO;
import com.example.springcricket.entities.Match;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IMatchService {
    String enterMatchDetails(MatchDTO matchdto);
    List<Match> seeMatchDetails();
}
