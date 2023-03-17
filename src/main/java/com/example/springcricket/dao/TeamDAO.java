package com.example.springcricket.dao;

import com.example.springcricket.entities.Player;
import com.example.springcricket.entities.Preference;
import com.example.springcricket.entities.Status;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.util.Pair;

import java.util.List;
@Builder
@Data
public class TeamDAO {
    @Id
    String teamName ;
    List<Player> playersList ;
    String captainId ;
    Preference tossPreference;

}
