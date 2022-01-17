package com.Project.backend.repository;

import com.Project.backend.model.heartDiseaseIndicator;
import com.Project.backend.queries.HeartDiseaseIndicatorQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface HeartDiseaseIndicatorRepository extends JpaRepository<heartDiseaseIndicator, Integer> {
    @Query(value = HeartDiseaseIndicatorQueries.HighBloodPressureByHDPositiveQuery, nativeQuery = true)
    ArrayList<String[]> getHighBloodPressureByHDPositive();

    @Query(value = HeartDiseaseIndicatorQueries.HighCholesterolByHDPositiveQuery, nativeQuery = true)
    ArrayList<String[]> getHighCholesterolByHDPositive();

    @Query(value = HeartDiseaseIndicatorQueries.BMIGroupsByHDPositiveQuery, nativeQuery = true)
    ArrayList<String[]> getBMIGroupsByHDPositive();

    @Query(value = HeartDiseaseIndicatorQueries.SmokerByHDPositiveQuery, nativeQuery = true)
    ArrayList<String[]> getSmokerByHDPositive();

    @Query(value = HeartDiseaseIndicatorQueries.StrokeByHDPositiveQuery, nativeQuery = true)
    ArrayList<String[]> getStrokeByHDPositive();

    @Query(value = HeartDiseaseIndicatorQueries.DiabetesByHDPositiveQuery, nativeQuery = true)
    ArrayList<String[]> getDiabetesByHDPositive();

    @Query(value = HeartDiseaseIndicatorQueries.PhysActivityByHDPositiveQuery, nativeQuery = true)
    ArrayList<String[]> getPhysActivityByHDPositive();

    @Query(value = HeartDiseaseIndicatorQueries.FruitsByHDPositiveQuery, nativeQuery = true)
    ArrayList<String[]> getFruitsByHDPositive();

    @Query(value = HeartDiseaseIndicatorQueries.VeggiesByHDPositiveQuery, nativeQuery = true)
    ArrayList<String[]> getVeggiesByHDPositive();

    @Query(value = HeartDiseaseIndicatorQueries.HeavyAlcoholConsumptionByHDPositiveQuery, nativeQuery = true)
    ArrayList<String[]> getHeavyAlcoholConsumptionByHDPositive();

    @Query(value = HeartDiseaseIndicatorQueries.AnyHealthcareByHDPositiveQuery, nativeQuery = true)
    ArrayList<String[]> getAnyHealthcareByHDPositive();

    @Query(value = HeartDiseaseIndicatorQueries.NoDoctorBCofCostByHDPositiveQuery, nativeQuery = true)
    ArrayList<String[]> getNoDoctorBCofCostByHDPositiveQuery();
}
