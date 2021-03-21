package com.example.genderchecker.name;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NamesRepository extends JpaRepository<NamesEntity, Long> {

    void deleteNameById(Long id);

    Optional<NamesEntity> findNameById(Long id);
}
