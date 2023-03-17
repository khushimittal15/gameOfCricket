package com.example.springcricket.entities;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;
@Builder
public class ScoreBoard {
    private Team tossWinningTeam ;
    private String winner ;
    private Inning[] innings;

    public int getFours() {
        return innings[0].getFours() + innings[1].getFours();
    }

    public int getSixes() {
        return innings[0].getSixes() + innings[1].getSixes();
    }
}
