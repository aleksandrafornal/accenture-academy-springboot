package com.accenture.academy.apiConsuming.placesApi;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "accenture.academy.places")
@Data
@Component
public class PlacesApiConfig {
    private String apiKey;
}
