package com.example.springcricket.repository;

import com.example.springcricket.entities.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeamRepository extends MongoRepository<Team,String> {


}
