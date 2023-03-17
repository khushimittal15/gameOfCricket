package com.example.springcricket.service;

import com.example.springcricket.dto.UmpireDTO;
import com.example.springcricket.entities.Umpire;
import com.example.springcricket.repository.IUmpireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UmpireServiceImpl implements IUmpireService {
    @Autowired
    IUmpireRepository umpireRepository ;
    @Override
    public String addUmpire(UmpireDTO umpire) {
        return "Umpire has been added successfully";
    }
    @Override
    public List<Umpire> getAllUmpires() {
        return null;
    }
}
