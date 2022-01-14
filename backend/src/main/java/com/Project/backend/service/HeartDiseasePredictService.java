package com.Project.backend.service;

import com.Project.backend.repository.HeartDiseasePredictRepository;
import com.Project.backend.resources.NumericResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class HeartDiseasePredictService {

    private final HeartDiseasePredictRepository heartDiseasePredictRepository;

    @Autowired
    public HeartDiseasePredictService(HeartDiseasePredictRepository heartDiseasePredictRepository){
        this.heartDiseasePredictRepository = heartDiseasePredictRepository;
    }

    public ArrayList<Double> averageAge(Double epsilon) {
        NumericResult res = new NumericResult();
        double age = heartDiseasePredictRepository.getAverageAge();
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
        result = heartDiseasePredictRepository.getNumRecordsBySex();

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

    public HashMap<String, Double> getEducationGroupsByHDPositive(Double epsilon) {
        NumericResult res = new NumericResult();
        ArrayList<String[]> result;
        ArrayList<String> types = new ArrayList<>();
        ArrayList<Double> counts = new ArrayList<>();
        result = heartDiseasePredictRepository.getEducationGroupsByHDPositive();

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

    public HashMap<String, Double> getCurrentSmokerByHDPositive(Double epsilon) {
        NumericResult res = new NumericResult();
        ArrayList<String[]> result;
        ArrayList<String> types = new ArrayList<>();
        ArrayList<Double> counts = new ArrayList<>();
        result = heartDiseasePredictRepository.getCurrentSmokerByHDPositive();

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
