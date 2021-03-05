package com.example.demo.controllers;

import com.example.demo.models.BetModel;
import com.example.demo.models.RouletteModel;
import com.example.demo.services.BetService;
import com.example.demo.services.RouletteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bet")
public class BetController {
    @Autowired
    BetService betService;
    @Autowired
    RouletteService rouletteService;

    @PostMapping("/create")
    public String createBet(@RequestParam Long userId, @RequestParam double amount, @RequestParam(required = false) String color, @RequestParam(required = false) Integer num, @RequestParam Long rouletteId){
        RouletteModel roulette = rouletteService.findById(rouletteId);
        BetModel bet = new BetModel(userId, amount, color, num);
        if(roulette == null)
            return "No se puede realizar la apuesta, la ruleta no existe";
        if(roulette.getStatus().equals("cerrada"))
            return "No se puede realizar la apuesta, la ruleta se encuentra cerrada";
        if(color == null && num == null)
            return "No se puede realizar la apuesta sin un numero o color";
        if(color != null && num != null)
            return "La apuesta no se puede realizar a numero y color al mismo tiempo";
        if(amount < 0 || amount > 10000)
            return "No se puede realizar la apuesta, el monto debe estar entre 0 y 10000";
        if(num != null){
            if(num < 0 || num > 36)
                return "No se puede realizar la apuesta, el numero debe estar entre 0 y 36";
            bet.setRoulette(roulette);
            betService.saveBet(bet);
            return "Apuesta realizada en la ruleta con id: " + rouletteId;
        }
        if(color.toLowerCase().equals("rojo") || color.toLowerCase().equals("negro")){
            bet.setRoulette(roulette);
            betService.saveBet(bet);
            return "Apuesta realizada en la ruleta con id: " + rouletteId;
        }
        return "No se puede realizar la apuesta, el color debe ser rojo o negro";
    } 
}
