package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bets")
public class BetModel {

    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long userId;
    double amount;
    String color;
    Integer num;
    @ManyToOne(fetch = FetchType.LAZY)
    RouletteModel roulette;

    public BetModel(Long userId, double amount, String color, Integer num){
        this.userId = userId;
        this.amount = amount;
        this.color = color;
        this.num = num;
    }

    BetModel(){
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public RouletteModel getRoulette() {
        return roulette;
    }

    public void setRoulette(RouletteModel roulette) {
        this.roulette = roulette;
    }

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
