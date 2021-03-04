package com.example.demo.repositories;

import com.example.demo.models.RouletteModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouletteRepository extends CrudRepository<RouletteModel, Long>{
    
}
