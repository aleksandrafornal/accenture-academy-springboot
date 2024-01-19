package com.accenture.academy.cookieAndHeader;

import jakarta.annotation.PostConstruct;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@NoArgsConstructor
public class DogImageService {

    @PostConstruct
    void getDogImage() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .uri(URI.create("https://dog.ceo/api/breeds/image/random"))
                .GET()
                .header("DOG", "cuteDog")
                .build();

        HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String response = httpResponse.body().toString();
    }
}
