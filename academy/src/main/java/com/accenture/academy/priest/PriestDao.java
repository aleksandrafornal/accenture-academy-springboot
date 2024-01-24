package com.accenture.academy.priest;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "PRIEST")
public class PriestDao {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    @Column(name = "height")
    private Double heightInCm;
    private Integer age;

    @Embedded
    private Location location;

    public PriestDao(String name, Double heightInCm, Integer age) {
        this.name = name;
        this.heightInCm = heightInCm;
        this.age = age;
    }
}
