package com.accenture.academy.apiConsuming.geolocation;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@Slf4j
@RequiredArgsConstructor
public class GeolocationService {

    private final GeolocationConfig config;

   @PostConstruct
    void getGeolocation() throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .GET()
                .uri(URI.create("https://api.geoapify.com/v1/ipinfo?&apiKey=" + config.getApikey()))
                .build();
        HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        log.info(httpResponse.body().toString());
    }
}
