package com.accenture.academy.parish;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IParishRepository extends JpaRepository<ParishDao, Long> {

    @Query(value = "SELECT * FROM ...", nativeQuery = true)
    ParishDao getMyCustomParishes();
}
