package com.example.demo.services;
import java.util.ArrayList;
import java.util.List;
import com.example.demo.models.BetModel;
import com.example.demo.models.RouletteModel;
import com.example.demo.repositories.BetRepository;
import com.example.demo.repositories.RouletteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RouletteService {
    @Autowired
    RouletteRepository rouletteRepository;
    @Autowired
    BetRepository betRepository;
    public Iterable<RouletteModel> getRoulettes(){

        return rouletteRepository.findAll();
    }
    public RouletteModel saveRoulette( RouletteModel roulette){

        return rouletteRepository.save(roulette);
    }
    public RouletteModel activateRoulette(Long id){
        RouletteModel roulette = rouletteRepository.findById(id).orElse(null);
        if(roulette == null){

            return roulette;
        }
        roulette.setStatus("abierta");

        return rouletteRepository.save(roulette);
    }
    public RouletteModel findById(Long id){

        return rouletteRepository.findById(id).orElse(null);
    }
    public List<BetModel> closeRoulette(Long id){
        RouletteModel roulette = rouletteRepository.findById(id).orElse(null);
        Integer winNumber = (int) (Math.random() * 36);
        String winColor = (winNumber%2 == 0) ? "rojo" : "negro";
        List<BetModel> bets = new ArrayList<BetModel>();
        betRepository.findByRoulette(roulette).stream().forEach(i -> {
            bets.add(validateBet(i, winNumber, winColor));
        });
        roulette.setStatus("cerrada");
        saveRoulette(roulette);

        return bets;
    }
    public BetModel validateBet(BetModel bet, Integer winNum, String winColor){
        Integer num = bet.getNum();
        String color = bet.getColor();
        double amount = bet.getAmount();
        if(num != null){
            if(num == winNum)
                bet.setAmount(amount*5);
            else
                bet.setAmount(0);
        }else if(color.toLowerCase().equals(winColor)) 
            bet.setAmount(amount*1.8);
        else
            bet.setAmount(0);
        betRepository.delete(bet);

        return bet;
    }
}
