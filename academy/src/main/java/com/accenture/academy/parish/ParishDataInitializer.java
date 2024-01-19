package com.accenture.academy.parish;

import com.accenture.academy.priest.PriestDao;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ParishDataInitializer {

    private final ParishService parishService;

//    @PostConstruct
//    void initParishes(){
//        ParishDao parishDao = new ParishDao(
//                new PriestDao(
//
//                )
//        )
//    }


}
