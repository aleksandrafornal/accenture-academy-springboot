package com.accenture.academy.parish;

import com.accenture.academy.church.ChurchDto;
import com.accenture.academy.priest.PriestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parishes")
@RequiredArgsConstructor
public class ParishRestController {
    private final ParishService parishService;
    @GetMapping
    List<ParishDao> getAllParishes(){
        return parishService.getAllParishes();
    }

    @GetMapping("/{id}")
    ParishDao getParishById(@PathVariable Long id){
        return parishService.getParishById(id);
    }

    @PostMapping
    void addParish(@RequestBody ParishDto parishDto){
        parishService.addParish(parishDto);
    }

    @PutMapping("/{id}")
    void updateParish(@PathVariable Long id, @RequestBody ParishDto parishDto){
        parishService.updateParish(parishDto, id);
    }

    @PatchMapping("/parishId/{parishId}/priestId/{priestId}")
    void addPriestByIdToParish(@PathVariable Long parishId, @PathVariable Long priestId){
        parishService.assignPriestByIdToParish(priestId, parishId);
    }

    @PatchMapping("/parishId/{parishId}/priest")
    void addNewPriestToParish(@PathVariable Long parishId, @RequestBody PriestDto priestDto){
        parishService.assignNewPriestToParish(priestDto, parishId);
    }

    @PatchMapping("/parishId/{parishId}/churchId/{churchId}")
    void addChurchByIdToParish(@PathVariable Long parishId, @PathVariable Long churchId){
        parishService.assignChurchByIdToParish(churchId, parishId);
    }

    @PatchMapping("/parishId/{parishId}/church")
    void addNewChurchToParish(@PathVariable Long parishId, @RequestBody ChurchDto churchDto){
        parishService.assignNewChurchToParish(churchDto, parishId);
    }

    @PatchMapping("/{parishId}")
    void assignPriestToParish(@RequestBody PriestAssignmentDto priestAssignmentDto,
                              @PathVariable Long parishId){
        parishService.assignPriestToParish(priestAssignmentDto, parishId);
    }




}
