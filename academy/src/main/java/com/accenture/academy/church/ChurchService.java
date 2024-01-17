package com.accenture.academy.church;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class ChurchService {
    private final ChurchRepository churchRepository;
    List<ChurchDao> getAllChurches() {
        return churchRepository.findAll();
    }

    void addChurch(ChurchDao churchDao){
        churchRepository.save(churchDao);
    }
    void addChurch(ChurchDto churchDto){
        churchRepository.save(ChurchMapper.mapDtoToDao(churchDto));
    }

    public ChurchDao getChurchById(Long id) {
        return churchRepository
                .findById(id)
                .orElseThrow(() -> new ChurchNotFoundException("Church with id " + id + " not found"));
    }

    public void update(ChurchDto churchDto, Long id) {
        churchRepository.save(ChurchMapper.mapDtoToDao(churchDto, id));
    }

    public void deleteById(Long id) {
        churchRepository.deleteById(id);
    }

    public List<ChurchDao> getAllByName(Optional<String> name) {
        return churchRepository.findAllByName(name);
    }
}
