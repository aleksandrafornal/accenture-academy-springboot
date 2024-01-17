package com.accenture.academy.church;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ChurchRepository {
    private final IChurchRepository iChurchRepository;

    public List<ChurchDao> findAll() {
        return iChurchRepository.findAll();
    }

    public void save(ChurchDao churchDao) {
        iChurchRepository.save(churchDao);
    }

    public Optional<ChurchDao> findById(Long id) {
        return iChurchRepository.findById(id);
    }

    public void deleteById(Long id) {
        iChurchRepository.deleteById(id);
    }

    public List<ChurchDao> findAllByName(Optional<String> name) {
        return iChurchRepository.findAllByNameContaining(name);
    }
}
