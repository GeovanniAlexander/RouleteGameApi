package com.example.demo.controllers;
import java.util.List;
import com.example.demo.models.BetModel;
import com.example.demo.models.RouletteModel;
import com.example.demo.services.RouletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
@RequestMapping("/roulette")
public class RouletteController {
    @Autowired
    RouletteService rouletteService;
    @GetMapping()
    public Iterable<RouletteModel> getRoulettes() {

        return rouletteService.getRoulettes();
    }
    @PostMapping("/create")
    public String createRoulette(){
        RouletteModel roulette = new RouletteModel();
        rouletteService.saveRoulette(roulette);

        return "Se creo la ruleta con id: " + roulette.getId();
    }
    @PostMapping("/activate/{id}")
    public String activateRoulette(@PathVariable Long id){
        RouletteModel roulette = rouletteService.activateRoulette(id);
        if(roulette != null){

            return "Fue activada la ruleta con id: " + id;
        }

        return "La ruleta no existe";
    } 
    @GetMapping("/close/{id}")
    public List<BetModel> getMethodName(@PathVariable Long id) {

        return rouletteService.closeRoulette(id);
    }  
}
