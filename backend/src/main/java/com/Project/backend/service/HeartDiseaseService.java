package com.Project.backend.service;

import com.Project.backend.repository.HeartDiseaseRepository;
import com.Project.backend.resources.NumericResult;
import com.Project.backend.resources.SingleColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class HeartDiseaseService {
    private final HeartDiseaseRepository heartDiseaseRepository;

    @Autowired
    public HeartDiseaseService(HeartDiseaseRepository heartDiseaseRepository){
        this.heartDiseaseRepository = heartDiseaseRepository;
    }

    public ArrayList<Double> averageAge() {
        NumericResult res = new NumericResult();
        double age = heartDiseaseRepository.getAverageAge();
        ArrayList<Double> result = new ArrayList<>();
        result.add(age);
        res.setContent(result);
        res.addLaplaceNoise(1.0, 1.0);
        res.round(2);

        return res.getContent();
    }

    public ArrayList<Double> getNumRecordsBySex(String sex) {
        NumericResult res = new NumericResult();
        Double count = heartDiseaseRepository.getNumRecordsBySex(sex);
        ArrayList<Double> result = new ArrayList<>();
        result.add(count);
        res.setContent(result);
        res.addLaplaceNoise(1.0, 1.0);
        res.round(2);

        return res.getContent();
    }

    public HashMap<String, Double> getChestPainTypeByHDPositive() {
        NumericResult res = new NumericResult();
        ArrayList<String[]> result;
        ArrayList<String> types = new ArrayList<>();
        ArrayList<Double> values = new ArrayList<>();
        result = heartDiseaseRepository.getChestPainTypeByHDPositive();

        for (String[] strings : result) {
            values.add(Double.parseDouble(strings[0]));
            types.add(strings[1]);
        }

        res.setContent(values);
        res.addLaplaceNoise(1.0, 1.0);
        res.round(2);

        HashMap<String, Double> finalResult = new HashMap<>();
        for (int j = 0; j < values.size(); j++) {
            finalResult.put(types.get(j), res.getContent().get(j));
        }

        return finalResult;
    }

    public HashMap<String, Double> getAgeGroupsByHDPositive() {
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
        res.addLaplaceNoise(1.0, 1.0);
        res.round(2);

        HashMap<String, Double> finalResult = new HashMap<>();
        for (int j = 0; j < counts.size(); j++) {
            finalResult.put(ranges.get(j), res.getContent().get(j));
        }

        return finalResult;
    }

    public HashMap<String, Double> getBPGroupsByHDPositive() {
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
        res.addLaplaceNoise(1.0, 1.0);
        res.round(2);

        HashMap<String, Double> finalResult = new HashMap<>();
        for (int j = 0; j < counts.size(); j++) {
            finalResult.put(ranges.get(j), res.getContent().get(j));
        }

        return finalResult;
    }

}
