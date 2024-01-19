package com.accenture.academy.parish;

import com.accenture.academy.cementary.CementaryDao;
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
                null,
                null,
                Collections.emptySet(),
                new CementaryDao()
        );
        parishService.addParish(parishDao);
    }


}
