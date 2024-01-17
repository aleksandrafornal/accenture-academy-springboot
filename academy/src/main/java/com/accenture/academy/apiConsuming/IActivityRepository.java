package com.accenture.academy.apiConsuming;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IActivityRepository extends JpaRepository<Activity, String> { }
