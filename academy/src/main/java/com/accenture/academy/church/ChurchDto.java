package com.accenture.academy.church;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class ChurchDto {
    private String name;
    private String nameOfCity;
    private Integer numberOfSeats;
    private Integer numberOfMembers;
    private Double budget;

}
