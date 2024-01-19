package com.accenture.academy.parish;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/parishes")
@RequiredArgsConstructor
public class ParishRestController {
    private final ParishService parishService;
    @GetMapping
    List<ParishDao> getAllParishes(){
        return parishService.getAllParishes();
    }
}
