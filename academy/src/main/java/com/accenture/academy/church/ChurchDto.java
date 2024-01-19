package com.accenture.academy.church;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
class ChurchDto {

    @NotNull(message = "Name must not be null")
    private String name;

    @NotBlank(message = "Name of city must not be blank")
    private String nameOfCity;
    private Integer numberOfSeats;
    private Integer numberOfMembers;

    @Min(value = 1000, message = "Budget must be at least 1000")
    private Double budget;

}
