package com.ofa.ustask.model.dto;

public class RandomNumberData {
    private Long id;
    private int randomNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public RandomNumberData(Long id, int randomNumber) {
        this.id = id;
        this.randomNumber = randomNumber;
    }
}
