package com.Project.backend.repository;

import com.Project.backend.model.heartDisease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HeartDiseaseRepository extends JpaRepository<heartDisease, Integer> {

}