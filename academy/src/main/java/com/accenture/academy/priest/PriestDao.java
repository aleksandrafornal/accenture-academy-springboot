package com.accenture.academy.priest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.*;

@Entity
@Data
@NoArgsConstructor
class PriestDao {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    private Double heightInCm;
    private Integer age;

    public PriestDao(String name, Double heightInCm, Integer age) {
        this.name = name;
        this.heightInCm = heightInCm;
        this.age = age;
    }
}
