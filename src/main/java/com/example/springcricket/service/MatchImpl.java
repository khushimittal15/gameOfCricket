package com.example.springcricket.service;

import com.example.springcricket.NotFoundException;
import com.example.springcricket.dto.MatchDTO;
import com.example.springcricket.entities.Match;
import com.example.springcricket.repository.IMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class MatchImpl implements IMatchService{
    @Autowired
    private IMatchRepository iMatchRepository ;
    @Autowired
    IScoresCalculationService scoreBoard;
    @Override
    public String enterMatchDetails(MatchDTO matchdto) {
        Match match = Match.builder()
                .matchId(UUID.randomUUID())
                .matchName(matchdto.getMatchName())
                .teamNames(matchdto.getTeamNames())
                .date(new Date())
                .totalOvers(matchdto.getTotalOvers())
                .choiceOfTeam1(matchdto.getChoiceOfTeam1())
                .build();
        try
        {
            match.setScoreboard(scoreBoard.generateScoreBoard(match));
        }
        catch(NotFoundException e){
            throw new NotFoundException(e.getMessage()) ;
        }
        iMatchRepository.save(match) ;

        return match.getMatchId().toString();
    }

    @Override
    public List<Match> seeMatchDetails() {
        return iMatchRepository.findAll() ;
    }
}
