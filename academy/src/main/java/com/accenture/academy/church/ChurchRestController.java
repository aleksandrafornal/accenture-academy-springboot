package com.accenture.academy.church;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/churches")
@RequiredArgsConstructor
public class ChurchRestController {

    private final ChurchService churchService;
    @GetMapping
    List<ChurchDao> getAllChurches(
            @RequestParam(required = false) Optional<String> name
    ){
        if (name.isPresent()){
            return churchService.getAllByName(name);
        }
        return churchService.getAllChurches();
    }

    @GetMapping("/{id}")
    ResponseEntity getChurchById(@PathVariable Long id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(churchService.getChurchById(id));
        }catch (ChurchNotFoundException exception){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(exception.getMessage());
        }
    }

    @PostMapping
    void addChurch(
            @RequestBody ChurchDto churchDto
    ){
        churchService.addChurch(churchDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateChurch(
            @RequestBody ChurchDto churchDto,
            @PathVariable Long id
    ){
        churchService.update(churchDto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteChurchById(@PathVariable Long id){
        churchService.deleteById(id);
    }
}

