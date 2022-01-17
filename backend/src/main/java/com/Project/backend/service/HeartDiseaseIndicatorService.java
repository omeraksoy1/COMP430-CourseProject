package com.Project.backend.service;

import com.Project.backend.repository.HeartDiseaseIndicatorRepository;
import com.Project.backend.resources.NumericResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class HeartDiseaseIndicatorService {

    private final HeartDiseaseIndicatorRepository heartDiseaseIndicatorRepository;

    @Autowired
    public HeartDiseaseIndicatorService(HeartDiseaseIndicatorRepository heartDiseaseIndicatorRepository) {
        this.heartDiseaseIndicatorRepository = heartDiseaseIndicatorRepository;
    }

    public HashMap<String, Double> getHighBloodPressureByHDPositive(Double epsilon) {
        NumericResult res = new NumericResult();
        ArrayList<String[]> result;
        ArrayList<String> types = new ArrayList<>();
        ArrayList<Double> counts = new ArrayList<>();
        result = heartDiseaseIndicatorRepository.getHighBloodPressureByHDPositive();

        for (String[] strings : result) {
            types.add(strings[0]);
            counts.add(Double.parseDouble(strings[1]));
        }

        res.setContent(counts);
        res.addLaplaceNoise(1.0, epsilon);
        res.round(2);

        HashMap<String, Double> finalResult = new HashMap<>();
        for (int j = 0; j < counts.size(); j++) {
            finalResult.put(types.get(j), res.getContent().get(j));
        }

        return finalResult;
    }

    public HashMap<String, Double> getHighCholesterolByHDPositive(Double epsilon) {
        NumericResult res = new NumericResult();
        ArrayList<String[]> result;
        ArrayList<String> types = new ArrayList<>();
        ArrayList<Double> counts = new ArrayList<>();
        result = heartDiseaseIndicatorRepository.getHighCholesterolByHDPositive();

        for (String[] strings : result) {
            types.add(strings[0]);
            counts.add(Double.parseDouble(strings[1]));
        }

        res.setContent(counts);
        res.addLaplaceNoise(1.0, epsilon);
        res.round(2);

        HashMap<String, Double> finalResult = new HashMap<>();
        for (int j = 0; j < counts.size(); j++) {
            finalResult.put(types.get(j), res.getContent().get(j));
        }

        return finalResult;
    }

    public HashMap<String, Double> getBMIGroupsByHDPositive(Double epsilon) {
        NumericResult res = new NumericResult();
        ArrayList<String[]> result;
        ArrayList<String> types = new ArrayList<>();
        ArrayList<Double> counts = new ArrayList<>();
        result = heartDiseaseIndicatorRepository.getBMIGroupsByHDPositive();

        for (String[] strings : result) {
            types.add(strings[0]);
            counts.add(Double.parseDouble(strings[1]));
        }

        res.setContent(counts);
        res.addLaplaceNoise(1.0, epsilon);
        res.round(2);

        HashMap<String, Double> finalResult = new HashMap<>();
        for (int j = 0; j < counts.size(); j++) {
            finalResult.put(types.get(j), res.getContent().get(j));
        }

        return finalResult;
    }

    public HashMap<String, Double> getSmokerByHDPositive(Double epsilon) {
        NumericResult res = new NumericResult();
        ArrayList<String[]> result;
        ArrayList<String> types = new ArrayList<>();
        ArrayList<Double> counts = new ArrayList<>();
        result = heartDiseaseIndicatorRepository.getSmokerByHDPositive();

        for (String[] strings : result) {
            types.add(strings[0]);
            counts.add(Double.parseDouble(strings[1]));
        }

        res.setContent(counts);
        res.addLaplaceNoise(1.0, epsilon);
        res.round(2);

        HashMap<String, Double> finalResult = new HashMap<>();
        for (int j = 0; j < counts.size(); j++) {
            finalResult.put(types.get(j), res.getContent().get(j));
        }

        return finalResult;
    }

    public HashMap<String, Double> getStrokeByHDPositive(Double epsilon) {
        NumericResult res = new NumericResult();
        ArrayList<String[]> result;
        ArrayList<String> types = new ArrayList<>();
        ArrayList<Double> counts = new ArrayList<>();
        result = heartDiseaseIndicatorRepository.getStrokeByHDPositive();

        for (String[] strings : result) {
            types.add(strings[0]);
            counts.add(Double.parseDouble(strings[1]));
        }

        res.setContent(counts);
        res.addLaplaceNoise(1.0, epsilon);
        res.round(2);

        HashMap<String, Double> finalResult = new HashMap<>();
        for (int j = 0; j < counts.size(); j++) {
            finalResult.put(types.get(j), res.getContent().get(j));
        }

        return finalResult;
    }

    public HashMap<String, Double> getDiabetesByHDPositive(Double epsilon) {
        NumericResult res = new NumericResult();
        ArrayList<String[]> result;
        ArrayList<String> types = new ArrayList<>();
        ArrayList<Double> counts = new ArrayList<>();
        result = heartDiseaseIndicatorRepository.getDiabetesByHDPositive();

        for (String[] strings : result) {
            types.add(strings[0]);
            counts.add(Double.parseDouble(strings[1]));
        }

        res.setContent(counts);
        res.addLaplaceNoise(1.0, epsilon);
        res.round(2);

        HashMap<String, Double> finalResult = new HashMap<>();
        for (int j = 0; j < counts.size(); j++) {
            finalResult.put(types.get(j), res.getContent().get(j));
        }

        return finalResult;
    }

    public HashMap<String, Double> getPhysActivityByHDPositive(Double epsilon) {
        NumericResult res = new NumericResult();
        ArrayList<String[]> result;
        ArrayList<String> types = new ArrayList<>();
        ArrayList<Double> counts = new ArrayList<>();
        result = heartDiseaseIndicatorRepository.getPhysActivityByHDPositive();

        for (String[] strings : result) {
            types.add(strings[0]);
            counts.add(Double.parseDouble(strings[1]));
        }

        res.setContent(counts);
        res.addLaplaceNoise(1.0, epsilon);
        res.round(2);

        HashMap<String, Double> finalResult = new HashMap<>();
        for (int j = 0; j < counts.size(); j++) {
            finalResult.put(types.get(j), res.getContent().get(j));
        }

        return finalResult;
    }

    public HashMap<String, Double> getFruitsByHDPositive(Double epsilon) {
        NumericResult res = new NumericResult();
        ArrayList<String[]> result;
        ArrayList<String> types = new ArrayList<>();
        ArrayList<Double> counts = new ArrayList<>();
        result = heartDiseaseIndicatorRepository.getFruitsByHDPositive();

        for (String[] strings : result) {
            types.add(strings[0]);
            counts.add(Double.parseDouble(strings[1]));
        }

        res.setContent(counts);
        res.addLaplaceNoise(1.0, epsilon);
        res.round(2);

        HashMap<String, Double> finalResult = new HashMap<>();
        for (int j = 0; j < counts.size(); j++) {
            finalResult.put(types.get(j), res.getContent().get(j));
        }

        return finalResult;
    }

    public HashMap<String, Double> getVeggiesByHDPositive(Double epsilon) {
        NumericResult res = new NumericResult();
        ArrayList<String[]> result;
        ArrayList<String> types = new ArrayList<>();
        ArrayList<Double> counts = new ArrayList<>();
        result = heartDiseaseIndicatorRepository.getVeggiesByHDPositive();

        for (String[] strings : result) {
            types.add(strings[0]);
            counts.add(Double.parseDouble(strings[1]));
        }

        res.setContent(counts);
        res.addLaplaceNoise(1.0, epsilon);
        res.round(2);

        HashMap<String, Double> finalResult = new HashMap<>();
        for (int j = 0; j < counts.size(); j++) {
            finalResult.put(types.get(j), res.getContent().get(j));
        }

        return finalResult;
    }

    public HashMap<String, Double> getHeavyAlcoholConsumptionByHDPositive(Double epsilon) {
        NumericResult res = new NumericResult();
        ArrayList<String[]> result;
        ArrayList<String> types = new ArrayList<>();
        ArrayList<Double> counts = new ArrayList<>();
        result = heartDiseaseIndicatorRepository.getHeavyAlcoholConsumptionByHDPositive();

        for (String[] strings : result) {
            types.add(strings[0]);
            counts.add(Double.parseDouble(strings[1]));
        }

        res.setContent(counts);
        res.addLaplaceNoise(1.0, epsilon);
        res.round(2);

        HashMap<String, Double> finalResult = new HashMap<>();
        for (int j = 0; j < counts.size(); j++) {
            finalResult.put(types.get(j), res.getContent().get(j));
        }

        return finalResult;
    }

    public HashMap<String, Double> getAnyHealthcareByHDPositive(Double epsilon) {
        NumericResult res = new NumericResult();
        ArrayList<String[]> result;
        ArrayList<String> types = new ArrayList<>();
        ArrayList<Double> counts = new ArrayList<>();
        result = heartDiseaseIndicatorRepository.getAnyHealthcareByHDPositive();

        for (String[] strings : result) {
            types.add(strings[0]);
            counts.add(Double.parseDouble(strings[1]));
        }

        res.setContent(counts);
        res.addLaplaceNoise(1.0, epsilon);
        res.round(2);

        HashMap<String, Double> finalResult = new HashMap<>();
        for (int j = 0; j < counts.size(); j++) {
            finalResult.put(types.get(j), res.getContent().get(j));
        }

        return finalResult;
    }

    public HashMap<String, Double> getNoDoctorBCofCostByHDPositiveQuery(Double epsilon) {
        NumericResult res = new NumericResult();
        ArrayList<String[]> result;
        ArrayList<String> types = new ArrayList<>();
        ArrayList<Double> counts = new ArrayList<>();
        result = heartDiseaseIndicatorRepository.getNoDoctorBCofCostByHDPositiveQuery();

        for (String[] strings : result) {
            types.add(strings[0]);
            counts.add(Double.parseDouble(strings[1]));
        }

        res.setContent(counts);
        res.addLaplaceNoise(1.0, epsilon);
        res.round(2);

        HashMap<String, Double> finalResult = new HashMap<>();
        for (int j = 0; j < counts.size(); j++) {
            finalResult.put(types.get(j), res.getContent().get(j));
        }

        return finalResult;
    }

}
