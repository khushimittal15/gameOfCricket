package com.example.springcricket.controller;


import com.example.springcricket.dto.MatchDTO;
import com.example.springcricket.entities.Match;
import com.example.springcricket.service.IMatchService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(("/match"))
public class MatchController {
    @Autowired
    private IMatchService matchService;

    @PostMapping
    public String enterMatchDetails(@RequestBody MatchDTO matchdto) {
        return matchService.enterMatchDetails(matchdto);
    }

    @GetMapping
    public List<Match> seeAllMatchDetails (){

        return matchService.seeMatchDetails() ;
    }
}
