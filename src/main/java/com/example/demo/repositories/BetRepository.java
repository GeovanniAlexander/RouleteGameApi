package com.example.demo.repositories;
import java.util.List;
import com.example.demo.models.BetModel;
import com.example.demo.models.RouletteModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BetRepository extends CrudRepository<BetModel, Long>{
    public List<BetModel> findByRoulette(RouletteModel roulette);
}
