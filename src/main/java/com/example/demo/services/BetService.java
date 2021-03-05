package com.example.demo.services;

import com.example.demo.models.BetModel;
import com.example.demo.repositories.BetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BetService {

    @Autowired
    BetRepository betRepository;

    public BetModel saveBet(BetModel bet){
        return betRepository.save(bet);
    }    
}
