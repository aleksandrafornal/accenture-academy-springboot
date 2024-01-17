package com.accenture.academy.priest;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PriestDataInitializer {
    private final PriestService priestService;

    @PostConstruct
    void initPriests(){
        PriestDao priestDao = new PriestDao(
                "Tomek Nowak",
                165.00,
                29
        );
        PriestDao priestDao1 = new PriestDao(
                "Marek Kowalski",
                185.00,
                39
        );
        PriestDao priestDao2 = new PriestDao(
                "Mariusz Kowal",
                173.00,
                60
        );
        priestService.addPriest(priestDao);
        priestService.addPriest(priestDao1);
        priestService.addPriest(priestDao2);
    }

}
