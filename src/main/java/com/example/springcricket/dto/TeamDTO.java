package com.example.springcricket.dto;
import com.example.springcricket.entities.Preference;
import com.example.springcricket.entities.Status;
import lombok.Data;
import org.springframework.data.util.Pair;

import java.util.List;
@Data
public class TeamDTO {
    String teamName ;
    List<String> playersIdList ;
    String captainId ;
    Preference tossPreference;
}
