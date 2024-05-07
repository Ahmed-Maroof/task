package com.ofa.ustask.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RandomNumberData {

    private Long id;

    @JsonProperty("randomNumber")
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

    public RandomNumberData(Long id, @JsonProperty("randomNumber") int randomNumber) {
        this.id = id;
        this.randomNumber = randomNumber;
    }

    @Override
    public String toString() {
        return "RandomNumberData{" +
                "id=" + id +
                ", randomNumber=" + randomNumber +
                '}';
    }
}
