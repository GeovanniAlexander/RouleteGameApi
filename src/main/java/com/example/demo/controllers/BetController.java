package com.example.demo.controllers;
import com.example.demo.models.BetModel;
import com.example.demo.models.RouletteModel;
import com.example.demo.services.BetService;
import com.example.demo.services.RouletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/bet")
public class BetController {
    @Autowired
    BetService betService;
    @Autowired
    RouletteService rouletteService;
    @PostMapping("/create")
    public String createBet(@RequestHeader(value = "userId") Long userId, @RequestBody BetModel bet){
        Long rouletteId = bet.getRoulette().getId();
        bet.setRoulette(rouletteService.findById(rouletteId));
        bet.setUserId(userId);
        String[] resVal = valParams(bet).split(",",2);
        if(resVal[0].equals("OK")){
            betService.saveBet(bet);

            return resVal[1];
        }

        return resVal[1]; 
    } 
    public String valParams(BetModel bet){
        String color = bet.getColor();
        Integer num = bet.getNum();
        double amount = bet.getAmount();
        RouletteModel roulette = bet.getRoulette();
        if(roulette == null)

            return "NO,No se puede realizar la apuesta, la ruleta no existe";
        if(roulette.getStatus().equals("cerrada"))

            return "NO,No se puede realizar la apuesta, la ruleta se encuentra cerrada";
        if(color == null && num == null)

            return "NO,No se puede realizar la apuesta sin un numero o color";
        if(color != null && num != null)

            return "NO,La apuesta no se puede realizar a numero y color al mismo tiempo";
        if(amount <= 0 || amount > 10000)

            return "NO,No se puede realizar la apuesta, el monto debe estar entre 0 y 10000";
        if(num != null){
            if(num < 0 || num > 36){

                return "NO,No se puede realizar la apuesta, el numero debe estar entre 0 y 36";
            }

            return "OK,Apuesta realizada en la ruleta con id: " + bet.getRoulette().getId();
        }
        if(color.toLowerCase().equals("rojo") || color.toLowerCase().equals("negro")){

            return "OK,Apuesta realizada en la ruleta con id: " + bet.getRoulette().getId();
        }

        return "NO,No se puede realizar la apuesta, el color debe ser rojo o negro";
    }
}
