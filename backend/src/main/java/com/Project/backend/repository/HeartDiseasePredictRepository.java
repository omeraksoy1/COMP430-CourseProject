package com.Project.backend.repository;

import com.Project.backend.model.heartDiseasePredict;
import com.Project.backend.queries.HeartDiseasePredictQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface HeartDiseasePredictRepository extends JpaRepository<heartDiseasePredict, Integer> {
    @Query(value = HeartDiseasePredictQueries.AverageAgeQuery, nativeQuery = true)
    Double getAverageAge();

    @Query(value = HeartDiseasePredictQueries.NumRecordsBySexQuery, nativeQuery = true)
    ArrayList<String[]> getNumRecordsBySex();

    @Query(value = HeartDiseasePredictQueries.EducationGroupsByHDPositiveQuery, nativeQuery = true)
    ArrayList<String[]> getEducationGroupsByHDPositive();

    @Query(value = HeartDiseasePredictQueries.CurrentSmokerByHDPositiveQuery, nativeQuery = true)
    ArrayList<String[]> getCurrentSmokerByHDPositive();
}
