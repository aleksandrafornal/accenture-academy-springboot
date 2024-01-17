package com.accenture.academy.priest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/priests")
@RequiredArgsConstructor
class PriestRestController {
    private final PriestService priestService;
    @GetMapping
    List<PriestDao> getAllPriests(){
        return priestService.getAllPriests();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    PriestDao getPriestById(@PathVariable Long id){
        return priestService.getPriestById(id);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    PriestDao getPriestByName(@PathVariable String name){
        return priestService.findByName(name);
    }

    @PostMapping
    void addChurch(
            @RequestBody PriestDto priestDto
    ){
        priestService.addPriest(priestDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updatePriest(
            @RequestBody PriestDto priestDto,
            @PathVariable Long id
    ){
        priestService.update(priestDto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePriestById(@PathVariable Long id){
        priestService.deleteById(id);
    }
}
