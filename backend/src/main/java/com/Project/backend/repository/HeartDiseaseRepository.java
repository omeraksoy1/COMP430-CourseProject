package com.Project.backend.repository;

import com.Project.backend.model.heartDisease;
import com.Project.backend.resources.HeartDiseaseQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface HeartDiseaseRepository extends JpaRepository<heartDisease, Integer> {
    @Query(value = HeartDiseaseQueries.AverageAgeQuery, nativeQuery = true)
    Double getAverageAge();

    @Query(value = HeartDiseaseQueries.NumRecordsBySexQuery, nativeQuery = true)
    Double getNumRecordsBySex(@Param("sex") String sex);

    @Query(value = HeartDiseaseQueries.ChestPainTypeByHDPositiveQuery , nativeQuery = true)
    ArrayList<String[]> getChestPainTypeByHDPositive();

    @Query(value = HeartDiseaseQueries.AgeGroupsByHDPositiveQuery, nativeQuery = true)
    ArrayList<String[]> getAgeGroupsByHDPositive();

    @Query(value = HeartDiseaseQueries.BPGroupsByHDPositiveQuery , nativeQuery = true)
    ArrayList<String[]> getBPGroupsByHDPositive();

    @Query(value = HeartDiseaseQueries.STSlopeGroupsByHDPositiveQuery, nativeQuery = true)
    ArrayList<String[]> getSTSlopeGroupsByHDPositive();
}