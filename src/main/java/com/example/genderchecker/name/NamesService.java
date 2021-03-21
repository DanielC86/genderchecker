package com.example.genderchecker.name;

import com.example.genderchecker.exception.NameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NamesService {
    private final NamesRepository namesRepository;

    @Autowired
    public NamesService(NamesRepository namesRepository) {
        this.namesRepository = namesRepository;
    }

    public NamesEntity addNewNames(NamesEntity namesEntity){
        return namesEntity;
    }

    public List<NamesEntity> findAllNames() {
        return namesRepository.findAll();
    }

    public NamesEntity updateNames(NamesEntity namesEntity) {
        return namesRepository.save(namesEntity);
    }

    public NamesEntity findNameById(Long id) {
       return namesRepository.findNameById(id).orElseThrow(() -> new NameNotFoundException("name by id " + id + " was not found"));
    }

    public void deleteName(Long id) {
        namesRepository.deleteNameById(id);
    }
}
