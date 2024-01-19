package com.accenture.academy.parish;

import com.accenture.academy.church.*;
import com.accenture.academy.member.MemberDao;
import com.accenture.academy.priest.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParishService {
    private final ParishRepository parishRepository;
    private final PriestService priestService;
    private final ChurchService churchService;

    List<ParishDao> getAllParishes() {
        return parishRepository.findAll();
    }

    public ParishDao getParishById(Long id) {
        return parishRepository.getById(id)
                .orElseThrow(() -> new ParishNotFoundException("Parish with id " + id + " not found"));
    }

    void addParish(ParishDto parishDto){
        parishRepository.save(ParishMapper.mapDtoToDao(parishDto));
    }
    void addParish(ParishDao parishDao){
        parishRepository.save(parishDao);
    }
    void updateParish(ParishDto parishDto, Long id){
        parishRepository.save(ParishMapper.mapDtoToDao(parishDto, id));
    }

    void assignPriestByIdToParish(Long priestId, Long parishId) {
        ParishDao parish = parishRepository
                .getById(parishId)
                .orElseThrow(() -> new ParishNotFoundException("Parish with id " + parishId + " not found"));
        parish.setPriestDao(priestService.getPriestById(priestId));
        parishRepository.save(parish);

    }

    void assignNewPriestToParish(PriestDto priestDto, Long parishId) {
        ParishDao parish = parishRepository
                .getById(parishId)
                .orElseThrow(() -> new ParishNotFoundException("Parish with id " + parishId + " not found"));
        priestService.addPriest(priestDto);
        parish.setPriestDao(PriestMapper.mapDtoToDao(priestDto));
        parishRepository.save(parish);
    }

    void assignChurchByIdToParish(Long churchId, Long parishId) {
        ParishDao parish = parishRepository
                .getById(parishId)
                .orElseThrow(() -> new ParishNotFoundException("Parish with id " + parishId + " not found"));
        parish.setChurchDao(churchService.getChurchById(churchId));
        parishRepository.save(parish);
    }

    void assignNewChurchToParish(ChurchDto churchDto, Long parishId) {
        ParishDao parish = parishRepository
                .getById(parishId)
                .orElseThrow(() -> new ParishNotFoundException("Parish with id " + parishId + " not found"));
        churchService.addChurch(churchDto);
        parish.setChurchDao(ChurchMapper.mapDtoToDao(churchDto));
        parishRepository.save(parish);
    }

    void assignMemberToParish(MemberDao memberDao, Long parishId) {
        ParishDao parish = parishRepository
                .getById(parishId)
                .orElseThrow(() -> new ParishNotFoundException("Parish with id " + parishId + " not found"));
        parish.getMembers().add(memberDao);
        parishRepository.save(parish);
    }

    void assignPriestToParish(PriestAssignmentDto priestAssignmentDto, Long id){
        ParishDao parishDao = getParishById(id);
        PriestDao priestDao = priestService.getPriestById(priestAssignmentDto.getPriestId());

        parishDao.setPriestDao(priestDao);
        parishRepository.save(parishDao);
    }

}
