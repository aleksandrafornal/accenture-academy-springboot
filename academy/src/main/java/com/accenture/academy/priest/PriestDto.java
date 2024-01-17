package com.accenture.academy.priest;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class PriestDto {
    private String name;
    private Double heightInCm;
    private Integer age;
}
