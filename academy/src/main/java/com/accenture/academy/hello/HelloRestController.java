package com.accenture.academy.hello;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
//@Profile(value = "dev")
public class HelloRestController {
    @GetMapping("/hello")
    String getHello(HttpServletRequest request, HttpServletResponse response) {
        String apiKey = request.getHeader("apikey");
        String ipAddress = request.getHeader("X-FORWARDED_FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
            log.info(ipAddress);
        }
        log.info("ApiKey = " + apiKey);
        Cookie cookie = new Cookie("eluwina", "ciasteczku");
        response.addCookie(cookie);
        return "Hello World from Accenture";
    }
}
