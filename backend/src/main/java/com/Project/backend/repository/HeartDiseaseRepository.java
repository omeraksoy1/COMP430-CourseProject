package com.Project.backend.repository;

import com.Project.backend.model.heartDisease;
import com.Project.backend.resources.HeartDiseaseQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface HeartDiseaseRepository extends JpaRepository<heartDisease, Integer> {
    @Query(value = HeartDiseaseQueries.AverageAgeQuery, nativeQuery = true)
    Double getAverageAge();

    @Query(value = HeartDiseaseQueries.NumRecordsBySexQuery, nativeQuery = true)
    ArrayList<String[]> getNumRecordsBySex();

    @Query(value = HeartDiseaseQueries.ChestPainTypeByHDPositiveQuery , nativeQuery = true)
    ArrayList<String[]> getChestPainTypeByHDPositive();

    @Query(value = HeartDiseaseQueries.AgeGroupsByHDPositiveQuery, nativeQuery = true)
    ArrayList<String[]> getAgeGroupsByHDPositive();

    @Query(value = HeartDiseaseQueries.BPGroupsByHDPositiveQuery , nativeQuery = true)
    ArrayList<String[]> getBPGroupsByHDPositive();

    @Query(value = HeartDiseaseQueries.STSlopeGroupsByHDPositiveQuery, nativeQuery = true)
    ArrayList<String[]> getSTSlopeGroupsByHDPositive();

    @Query(value = HeartDiseaseQueries.CholesterolGroupsByHDPositiveQuery, nativeQuery = true)
    ArrayList<String[]> getCholesterolGroupsByHDPositive();

    @Query(value = HeartDiseaseQueries.RestingECGGroupsByHDPositiveQuery, nativeQuery = true)
    ArrayList<String[]> getRestingECGGroupsByHDPositive();

    @Query(value = HeartDiseaseQueries.MaxHRGroupsByHDPositiveQuery, nativeQuery = true)
    ArrayList<String[]> getMaxHRGroupsByHDPositive();

    @Query(value = HeartDiseaseQueries.ExerciseAnginaGroupsByHDPositiveQuery, nativeQuery = true)
    ArrayList<String[]> getExerciseAnginaGroupsByHDPositive();
}