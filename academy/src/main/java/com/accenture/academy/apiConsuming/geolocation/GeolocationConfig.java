package com.accenture.academy.apiConsuming.geolocation;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "accenture.academy")
@Data

public class GeolocationConfig {
    private String apikey;
}
