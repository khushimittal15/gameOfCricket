package com.example.springcricket.repository;

import com.example.springcricket.entities.Match;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IMatchRepository extends MongoRepository<Match, UUID> {} ;
