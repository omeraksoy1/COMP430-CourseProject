package com.Project.backend.repository;

import com.Project.backend.model.heartDiseasePredict;
import com.Project.backend.resources.HeartDiseaseQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HeartDiseasePredictRepository extends JpaRepository<heartDiseasePredict, Integer> {
    @Query(value = HeartDiseaseQueries.AverageAgeQuery, nativeQuery = true)
    Double getAverageAge();
}
