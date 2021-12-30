package com.Project.backend.repository;

import com.Project.backend.model.heartDisease;
import com.Project.backend.resources.SingleColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface HeartDiseaseRepository extends JpaRepository<heartDisease, Integer> {
    @Query(value = "SELECT AVG(age) FROM heartdisease", nativeQuery = true)
    Double getAverageAge();

    @Query(value = "SELECT COUNT(*) FROM heartdisease h WHERE h.Sex = :sex", nativeQuery = true)
    Double getNumRecordsBySex(@Param("sex") String sex);
}