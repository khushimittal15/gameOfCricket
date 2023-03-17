package com.example.springcricket.repository;

import com.example.springcricket.entities.Umpire;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUmpireRepository extends MongoRepository<Umpire,String> {
}
