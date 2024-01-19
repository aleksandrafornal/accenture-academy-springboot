package com.accenture.academy.church;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "CHURCH")
public class ChurchDao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String nameOfCity;
    private Integer numberOfSeats;
    private Integer numberOfMembers;
    private Double budget;


    public ChurchDao(String name, String nameOfCity, Integer numberOfSeats, Integer numberOfMembers, Double budget) {
        this.name = name;
        this.nameOfCity = nameOfCity;
        this.numberOfSeats = numberOfSeats;
        this.numberOfMembers = numberOfMembers;
        this.budget = budget;
    }
}
