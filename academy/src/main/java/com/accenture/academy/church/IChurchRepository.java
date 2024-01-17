package com.accenture.academy.church;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IChurchRepository extends JpaRepository<ChurchDao, Long> {
    List<ChurchDao> findAllByNameContaining(Optional<String> name);
}
