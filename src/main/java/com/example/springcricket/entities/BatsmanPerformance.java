package com.example.springcricket.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
public class BatsmanPerformance {

    private String playerId ;
    //batsman data
    private int runs ;
    private int ballsUsed ;
    private double runRate ;
    private int fours ;
    private int sixes ;
}
