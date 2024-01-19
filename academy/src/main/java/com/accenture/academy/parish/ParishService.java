package com.accenture.academy.parish;

import com.accenture.academy.priest.PriestDao;
import com.accenture.academy.priest.PriestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParishService {
    private final ParishRepository parishRepository;
    private final PriestRepository priestRepository;

    List<ParishDao> getAllParishes() {
        return parishRepository.findAll();
    }

    void assignPriestToParish(PriestDao priestDao, ParishDao parishDao){

    }

}
