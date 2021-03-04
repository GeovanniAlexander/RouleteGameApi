package com.example.demo.repositories;

import com.example.demo.models.BetModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetRepository extends CrudRepository<BetModel, Long>{
    
}
