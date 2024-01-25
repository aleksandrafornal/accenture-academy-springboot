package com.accenture.academy.priest;

import com.accenture.academy.church.ChurchDao;
import com.accenture.academy.church.ChurchMapper;
import com.accenture.academy.church.ChurchNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PriestService {
    private final PriestRepository priestRepository;
    public List<PriestDao> getAllPriests() {
        return priestRepository.findAll();
    }

    public void addPriest(PriestDao priestDao){
        priestRepository.save(priestDao);
    }
    public void addPriest(PriestDto priestDto){
        priestRepository.save(PriestMapper.mapDtoToDao(priestDto));
    }
    public PriestDao getPriestById(Long id) {
        return priestRepository
                .findById(id)
                .orElseThrow(() -> new PriestNotFoundException("Priest with id " + id + " not found"));
    }

    public void update(PriestDto priestDto, Long id) {
        priestRepository.save(PriestMapper.mapDtoToDao(priestDto, id));
    }

    public void deleteById(Long id) {
        priestRepository.deleteById(id);
    }

    public PriestDao findByName(String name){
        return priestRepository
                .findByName(name)
                .orElseThrow(() -> new InvalidNameException("Priest with name " + name + " not found"));
    }
}
