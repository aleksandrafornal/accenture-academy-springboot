package com.accenture.academy.apiConsuming.placesApi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlacesApiService {

    @Value("${accenture.academy.places.apikey}")
    private String apiKey;

    @PostConstruct
    void getPlaces() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .uri(URI.create("https://api.geoapify.com/v2/places?categories=commercial.supermarket&filter=rect%3A10.716463143326969%2C48.755151258420966%2C10.835314015356737%2C48.680903341613316&limit=5&apiKey="
                        + apiKey))
                .GET()
                .build();
        HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String response = httpResponse.body().toString();
        log.info(httpResponse.body().toString());

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(response);

        JsonNode features = root.path("features");

        List<Place> places = new ArrayList<>();

        for (JsonNode feature : features) {
            JsonNode properties = feature.path("properties");

            String placeId = properties.path("place_id").asText();
            String name = properties.path("name").asText();
            String country = properties.path("country").asText();
            String city = properties.path("city").asText();

            Place place = new Place(
                    placeId,
                    name,
                    country,
                    city
            );

            places.add(place);
        }

        System.out.println(places);

    }
}
