package com.accenture.academy.parish;

import com.accenture.academy.cementary.CementaryDao;
import com.accenture.academy.church.ChurchDao;
import com.accenture.academy.priest.PriestDao;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class ParishDataInitializer {

    private final ParishService parishService;

    @PostConstruct
    void initParishes(){
        ParishDao parishDao = new ParishDao(
                "",
                new PriestDao(
                        "Maciek Maciek",
                        165.00,
                        29
                ),
                new ChurchDao(
                        "Kościół św. Lso",
                        "Łódź",
                        250,
                        10000,
                        10000.00
                ),
                Collections.emptySet(),
                new CementaryDao()
        );

        ParishDao parishDao1 = new ParishDao(
                "",
                null,
                null,
                Collections.emptySet(),
                new CementaryDao()
        );
        parishService.addParish(parishDao);
        parishService.addParish(parishDao1);
    }


}
