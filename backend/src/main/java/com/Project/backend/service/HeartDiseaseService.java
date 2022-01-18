package com.Project.backend.service;

import com.Project.backend.repository.HeartDiseaseRepository;
import com.Project.backend.resources.NumericResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class HeartDiseaseService {
    private final HeartDiseaseRepository heartDiseaseRepository;

    @Autowired
    public HeartDiseaseService(HeartDiseaseRepository heartDiseaseRepository){
        this.heartDiseaseRepository = heartDiseaseRepository;
    }

    public ArrayList<Double> averageAge(Double epsilon) {

        NumericResult res = new NumericResult();
        double age = heartDiseaseRepository.getAverageAge();
        ArrayList<Double> result = new ArrayList<>();
        result.add(age);
        res.setContent(result);
        res.addLaplaceNoise(1.0, epsilon);
        res.round(2);

        return res.getContent();
    }

    public HashMap<String, Double> getNumRecordsBySex(Double epsilon) {
        NumericResult res = new NumericResult();
        ArrayList<String[]> result;
        ArrayList<String> types = new ArrayList<>();
        ArrayList<Double> counts = new ArrayList<>();
        result = heartDiseaseRepository.getNumRecordsBySex();

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

    public HashMap<String, Double> getChestPainTypeByHDPositive(Double epsilon) {
        NumericResult res = new NumericResult();
        ArrayList<String[]> result;
        ArrayList<String> types = new ArrayList<>();
        ArrayList<Double> counts = new ArrayList<>();
        result = heartDiseaseRepository.getChestPainTypeByHDPositive();

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

    public HashMap<String, Double> getAgeGroupsByHDPositive(Double epsilon) {
        NumericResult res = new NumericResult();
        ArrayList<String[]> result;
        ArrayList<String> ranges = new ArrayList<>();
        ArrayList<Double> counts = new ArrayList<>();
        result = heartDiseaseRepository.getAgeGroupsByHDPositive();

        for (String[] strings : result) {
            ranges.add(strings[0]);
            counts.add(Double.parseDouble(strings[1]));
        }

        res.setContent(counts);
        res.addLaplaceNoise(1.0, epsilon);
        res.round(2);

        HashMap<String, Double> finalResult = new HashMap<>();
        for (int j = 0; j < counts.size(); j++) {
            finalResult.put(ranges.get(j), res.getContent().get(j));
        }

        return finalResult;
    }

    public HashMap<String, Double> getBPGroupsByHDPositive(Double epsilon) {
        NumericResult res = new NumericResult();
        ArrayList<String[]> result;
        ArrayList<String> ranges = new ArrayList<>();
        ArrayList<Double> counts = new ArrayList<>();
        result = heartDiseaseRepository.getBPGroupsByHDPositive();

        for (String[] strings : result) {
            ranges.add(strings[0]);
            counts.add(Double.parseDouble(strings[1]));
        }

        res.setContent(counts);
        res.addLaplaceNoise(1.0, epsilon);
        res.round(2);

        HashMap<String, Double> finalResult = new HashMap<>();
        for (int j = 0; j < counts.size(); j++) {
            finalResult.put(ranges.get(j), res.getContent().get(j));
        }

        return finalResult;
    }

    public HashMap<String, Double> getSTSlopeGroupsByHDPositive(Double epsilon) {
        NumericResult res = new NumericResult();
        ArrayList<String[]> result;
        ArrayList<String> ranges = new ArrayList<>();
        ArrayList<Double> counts = new ArrayList<>();
        result = heartDiseaseRepository.getSTSlopeGroupsByHDPositive();

        for (String[] strings : result) {
            ranges.add(strings[0]);
            counts.add(Double.parseDouble(strings[1]));
        }

        res.setContent(counts);
        res.addLaplaceNoise(1.0, epsilon);
        res.round(2);

        HashMap<String, Double> finalResult = new HashMap<>();
        for (int j = 0; j < counts.size(); j++) {
            finalResult.put(ranges.get(j), res.getContent().get(j));
        }

        return finalResult;
    }

    public HashMap<String, Double> getCholesterolGroupsByHDPositive(Double epsilon) {
        NumericResult res = new NumericResult();
        ArrayList<String[]> result;
        ArrayList<String> ranges = new ArrayList<>();
        ArrayList<Double> counts = new ArrayList<>();
        result = heartDiseaseRepository.getCholesterolGroupsByHDPositive();

        for (String[] strings : result) {
            ranges.add(strings[0]);
            counts.add(Double.parseDouble(strings[1]));
        }

        res.setContent(counts);
        res.addLaplaceNoise(1.0, epsilon);
        res.round(2);

        HashMap<String, Double> finalResult = new HashMap<>();
        for (int j = 0; j < counts.size(); j++) {
            finalResult.put(ranges.get(j), res.getContent().get(j));
        }

        return finalResult;
    }

    public HashMap<String, Double> getRestingECGGroupsByHDPositive(Double epsilon) {
        NumericResult res = new NumericResult();
        ArrayList<String[]> result;
        ArrayList<String> ranges = new ArrayList<>();
        ArrayList<Double> counts = new ArrayList<>();
        result = heartDiseaseRepository.getRestingECGGroupsByHDPositive();

        for (String[] strings : result) {
            ranges.add(strings[0]);
            counts.add(Double.parseDouble(strings[1]));
        }

        res.setContent(counts);
        res.addLaplaceNoise(1.0, epsilon);
        res.round(2);

        HashMap<String, Double> finalResult = new HashMap<>();
        for (int j = 0; j < counts.size(); j++) {
            finalResult.put(ranges.get(j), res.getContent().get(j));
        }

        return finalResult;
    }

    public HashMap<String, Double> getMaxHRGroupsByHDPositive(Double epsilon) {
        NumericResult res = new NumericResult();
        ArrayList<String[]> result;
        ArrayList<String> ranges = new ArrayList<>();
        ArrayList<Double> counts = new ArrayList<>();
        result = heartDiseaseRepository.getMaxHRGroupsByHDPositive();

        for (String[] strings : result) {
            ranges.add(strings[0]);
            counts.add(Double.parseDouble(strings[1]));
        }

        res.setContent(counts);
        res.addLaplaceNoise(1.0, epsilon);
        res.round(2);

        HashMap<String, Double> finalResult = new HashMap<>();
        for (int j = 0; j < counts.size(); j++) {
            finalResult.put(ranges.get(j), res.getContent().get(j));
        }

        return finalResult;
    }

    public HashMap<String, Double> getExerciseAnginaGroupsByHDPositive(Double epsilon) {
        NumericResult res = new NumericResult();
        ArrayList<String[]> result;
        ArrayList<String> ranges = new ArrayList<>();
        ArrayList<Double> counts = new ArrayList<>();
        result = heartDiseaseRepository.getExerciseAnginaGroupsByHDPositive();

        for (String[] strings : result) {
            ranges.add(strings[0]);
            counts.add(Double.parseDouble(strings[1]));
        }

        res.setContent(counts);
        res.addLaplaceNoise(1.0, epsilon);
        res.round(2);

        HashMap<String, Double> finalResult = new HashMap<>();
        for (int j = 0; j < counts.size(); j++) {
            finalResult.put(ranges.get(j), res.getContent().get(j));
        }

        return finalResult;
    }

}
