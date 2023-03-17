package com.example.springcricket.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.util.Pair;

import java.util.List;
@Data
@Document(collection = "teams")
@Builder
public class Team {
    @Id
    String teamName ;
    List<Pair<String,Status>> playersIdList ;
    String captainId ;
    Preference tossPreference;
    
}
