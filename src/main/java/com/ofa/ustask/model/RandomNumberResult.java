package com.ofa.ustask.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "random_number_results")
public class RandomNumberResult {

    @Id
    private Long id;

    @Column(name = "multiplied_result")
    private int multipliedResult;

    public RandomNumberResult(Long id, int multipliedResult) {
        this.id = id;
        this.multipliedResult = multipliedResult;
    }

    public RandomNumberResult() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMultipliedResult() {
        return multipliedResult;
    }

    public void setMultipliedResult(int multipliedResult) {
        this.multipliedResult = multipliedResult;
    }

    @Override
    public String toString() {
        return "RandomNumberResult{" +
                "id=" + id +
                ", multipliedResult=" + multipliedResult +
                '}';
    }
}
