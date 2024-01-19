package com.accenture.academy.apiConsuming.placesApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Place {
    @JsonProperty("place_id")
    private String placeId;
    private String name;
    private String country;
    private String city;

    public Place(String placeId, String name, String country, String city) {
        this.placeId = placeId;
        this.name = name;
        this.country = country;
        this.city = city;
    }
}
