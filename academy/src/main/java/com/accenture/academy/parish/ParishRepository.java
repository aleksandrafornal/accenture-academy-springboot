package com.accenture.academy.parish;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ParishRepository {
    private final IParishRepository iParishRepository;

    public List<ParishDao> findAll(){
        return iParishRepository.findAll();
    }
    public Optional<ParishDao> getById(Long id) { return iParishRepository.findById(id);}

    public void save(ParishDao parishDao) { iParishRepository.save(parishDao);}

}
