package com.accenture.academy.apiConsuming;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActivityService {

    private final HttpClient httpClient;

    private final ActivityRepository activityRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void getActivity()  throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .GET()
                .uri(URI.create("https://www.boredapi.com/api/activity"))
                .build();

        HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String response = httpResponse.body().toString();

        ObjectMapper objectMapper = new ObjectMapper();
        Activity activity = objectMapper.readValue(response, Activity.class);

        System.out.println(response);

        log.info("Logging");
        log.info(response);

        log.info("Activity");
        log.info(activity.getActivity());

        log.info("Relaxation");
        log.info(activity.getType());

        log.info("Participants");
        log.info(activity.getParticipants().toString());

        log.info("Price");
        log.info(activity.getPrice().toString());

        log.info("Link");
        log.info(activity.getLink());

        log.info("Key");
        log.info(activity.getKey());

        log.info("Accessibility");
        log.info(activity.getAccessibility().toString());
        activityRepository.saveActivity(activity);
    }

    @EventListener(ApplicationReadyEvent.class)
    public Activity getRandomActivity()  throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .GET()
                .uri(URI.create("https://www.boredapi.com/api/activity"))
                .build();

        HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String response = httpResponse.body().toString();

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response, Activity.class);

    }

    public void saveActivity(Activity activity){
        activityRepository.saveActivity(activity);
    }
}
