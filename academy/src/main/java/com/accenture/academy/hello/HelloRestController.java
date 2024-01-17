package com.accenture.academy.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
    @GetMapping("/hello")
    String getHello(){
        return "Hello World from Accenture";
    }
}
