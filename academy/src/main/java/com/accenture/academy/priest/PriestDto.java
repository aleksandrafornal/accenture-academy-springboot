package com.accenture.academy.priest;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PriestDto {
    @Pattern(regexp = "^[A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]+(?: [A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]+)+$", message = "First and last name must start with capital letter and must be separated")
    private String name;
    @NotNull(message = "Height must not be null")
    private Double heightInCm;
    @NotNull(message = "Age must not be blank")
    @Min(value = 18, message = "Must be adult to become priest")
    private Integer age;
}
