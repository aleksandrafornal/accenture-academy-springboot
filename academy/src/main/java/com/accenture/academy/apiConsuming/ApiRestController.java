package com.accenture.academy.apiConsuming;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/api-consuming")
@RequiredArgsConstructor
public class ApiRestController {

    private final JokeService jokeService;

    private final CatFactService catFactService;

    private final ActivityService activityService;

    @GetMapping("/joke")
    Joke getJoke() throws IOException, InterruptedException {
        return jokeService.getRandomJoke();
    }

    @GetMapping("/catfact")
    CatFact getCatFact() throws IOException, InterruptedException {
        return catFactService.getCatFact();
    }

    @GetMapping("/activity")
    Activity getActivity() throws IOException, InterruptedException {
        Activity activity = activityService.getRandomActivity();
        activityService.saveActivity(activity);
        return activity;
    }
}
