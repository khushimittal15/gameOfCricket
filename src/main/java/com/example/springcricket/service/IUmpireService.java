package com.example.springcricket.service;

import com.example.springcricket.dto.UmpireDTO;
import com.example.springcricket.entities.Umpire;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUmpireService {

    public String addUmpire(UmpireDTO umpire);

    List<Umpire> getAllUmpires();
}
