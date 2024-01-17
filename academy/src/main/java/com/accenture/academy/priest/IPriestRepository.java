package com.accenture.academy.priest;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPriestRepository extends JpaRepository<PriestDao, Long> {
    Optional<PriestDao> findPriestDaoByName(String name);
}
