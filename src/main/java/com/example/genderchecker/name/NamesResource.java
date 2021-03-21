package com.example.genderchecker.name;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/names")
public class NamesResource {

    private final NamesService namesService;

    public NamesResource(NamesService namesService) {
        this.namesService = namesService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<NamesEntity>> getAllNames() {
        List<NamesEntity> names = namesService.findAllNames();
        return new ResponseEntity<>(names, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<NamesEntity> getNameById(@PathVariable("id") Long id) {
        NamesEntity name = namesService.findNameById(id);
        return new ResponseEntity<>(name, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<NamesEntity> addName(@RequestBody NamesEntity namesEntity) {
        NamesEntity newName = namesService.addNewNames(namesEntity);
        return new ResponseEntity<>(newName, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<NamesEntity> updateName(@RequestBody NamesEntity namesEntity) {
        NamesEntity updateName = namesService.updateNames(namesEntity);
        return new ResponseEntity<>(updateName, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteName(@PathVariable("id") Long id) {
        namesService.deleteName(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
