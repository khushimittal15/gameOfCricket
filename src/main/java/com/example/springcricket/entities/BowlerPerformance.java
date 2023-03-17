package com.example.springcricket.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class BowlerPerformance {
    private String playerId ;
    private int runsGiven ;
    private int oversBowled ;
    private int wicketsTaken ;
}
