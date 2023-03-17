package com.example.springcricket.controller;
import com.example.springcricket.dto.UmpireDTO;
import com.example.springcricket.entities.Umpire;
import com.example.springcricket.service.IUmpireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/umpire")
public class UmpireController {
    @Autowired
    IUmpireService umpireService;
    @PostMapping
    public String addUmpire(@RequestBody UmpireDTO umpiredto){
        return umpireService.addUmpire(umpiredto);
    }

    @GetMapping
    public List<Umpire> getAllUmpires(){
        return umpireService.getAllUmpires() ;
    }

}
