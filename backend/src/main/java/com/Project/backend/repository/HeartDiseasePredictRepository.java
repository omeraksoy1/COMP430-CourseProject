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

    @Query(value = HeartDiseasePredictQueries.CigsPerDayGroupsByHDPositiveQuery, nativeQuery = true)
    ArrayList<String[]> getCigsPerDayGroupsByHDPositive();

    @Query(value = HeartDiseasePredictQueries.BPMedsGroupsByHDPositiveQuery, nativeQuery = true)
    ArrayList<String[]> getBPMedsGroupsByHDPositive();

    @Query(value = HeartDiseasePredictQueries.PrevalentStrokeByHDPositiveQuery, nativeQuery = true)
    ArrayList<String[]> getPrevalentStrokeByHDPositive();

    @Query(value = HeartDiseasePredictQueries.PrevalentHypertensionBinaryByHDPositiveQuery, nativeQuery = true)
    ArrayList<String[]> getPrevalentHypertensionBinaryByHDPositive();

    @Query(value = HeartDiseasePredictQueries.DiabetesByHDPositiveQuery, nativeQuery = true)
    ArrayList<String[]> getDiabetesByHDPositive();

    @Query(value = HeartDiseasePredictQueries.CholesterolGroupsByHDPositiveQuery, nativeQuery = true)
    ArrayList<String[]> getCholesterolGroupsByHDPositive();

    @Query(value = HeartDiseasePredictQueries.BMIGroupsByHDPositiveQuery, nativeQuery = true)
    ArrayList<String[]> getBMIGroupsByHDPositive();
}
