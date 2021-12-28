package com.Project.backend.repository;

import com.Project.backend.model.heartDisease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface HeartDiseaseRepository extends JpaRepository<heartDisease, Integer> {
    @Query("SELECT AVERAGE(age) FROM heartDisease")
    Integer findAgeAverage();
}