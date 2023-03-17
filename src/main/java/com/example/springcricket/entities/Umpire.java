package com.example.springcricket.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "umpires")
@Data
public class Umpire {
    @Id
    Long umpireId ;
    String name ;
    int age ;
    String country ;
    int matchesUmpired ;


}
