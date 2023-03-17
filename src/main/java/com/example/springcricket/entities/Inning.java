package com.example.springcricket.entities;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Inning {
    private List<BatsmanPerformance> batsmanPerformances ;
    private List<BowlerPerformance> bowlerPerformances ;
    private List<String> scoreList ;
    private int overallScore ;
    private int wicketsFallen ;
    private int fours ;
    private int sixes ;
    

}
