package com.example.demo.models;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "roulettes")
public class RouletteModel {
    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String status;
    @OneToMany(mappedBy = "roulette", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<BetModel> bets;
    public RouletteModel(){
        this.status = "cerrada";
    }
    public Long getId() {

        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getStatus() {

        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }    
}
