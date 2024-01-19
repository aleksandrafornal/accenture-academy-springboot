package com.accenture.academy.cookieAndHeader;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Slf4j
public class DogImageRestController {

    private final DogImageService dogImageService;

    @GetMapping("/dogs")
    void getDogImage(HttpServletResponse response, HttpServletRequest request) throws IOException, InterruptedException {
        String ip = request.getHeader("X-FORWARDED_FOR");
        if (ip == null) {
            ip = request.getRemoteAddr();
            log.info("IP: " + ip);
        }
        Cookie cookie = new Cookie("cookie", "cookie_for_dogs");
        response.addHeader("dog", "cuteDog");
        response.addCookie(cookie);
        dogImageService.getDogImage();
    }
}
