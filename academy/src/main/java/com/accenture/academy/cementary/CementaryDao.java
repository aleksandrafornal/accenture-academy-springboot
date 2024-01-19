package com.accenture.academy.cementary;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CEMENTARY")
public class CementaryDao {
    @Id
    @GeneratedValue
    private Long id;
}
