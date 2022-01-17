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

    public HashMap<String, Double> getCigsPerDayGroupsByHDPositive(Double epsilon) {
        NumericResult res = new NumericResult();
        ArrayList<String[]> result;
        ArrayList<String> types = new ArrayList<>();
        ArrayList<Double> counts = new ArrayList<>();
        result = heartDiseasePredictRepository.getCigsPerDayGroupsByHDPositive();

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

    public HashMap<String, Double> getBPMedsGroupsByHDPositive(Double epsilon) {
        NumericResult res = new NumericResult();
        ArrayList<String[]> result;
        ArrayList<String> types = new ArrayList<>();
        ArrayList<Double> counts = new ArrayList<>();
        result = heartDiseasePredictRepository.getBPMedsGroupsByHDPositive();

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

    public HashMap<String, Double> getPrevalentStrokeByHDPositive(Double epsilon) {
        NumericResult res = new NumericResult();
        ArrayList<String[]> result;
        ArrayList<String> types = new ArrayList<>();
        ArrayList<Double> counts = new ArrayList<>();
        result = heartDiseasePredictRepository.getPrevalentStrokeByHDPositive();

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

    public HashMap<String, Double> getPrevalentHypertensionBinaryByHDPositive(Double epsilon) {
        NumericResult res = new NumericResult();
        ArrayList<String[]> result;
        ArrayList<String> types = new ArrayList<>();
        ArrayList<Double> counts = new ArrayList<>();
        result = heartDiseasePredictRepository.getPrevalentHypertensionBinaryByHDPositive();

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
        result = heartDiseasePredictRepository.getDiabetesByHDPositive();

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

    public HashMap<String, Double> getCholesterolGroupsByHDPositive(Double epsilon) {
        NumericResult res = new NumericResult();
        ArrayList<String[]> result;
        ArrayList<String> types = new ArrayList<>();
        ArrayList<Double> counts = new ArrayList<>();
        result = heartDiseasePredictRepository.getCholesterolGroupsByHDPositive();

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
        result = heartDiseasePredictRepository.getBMIGroupsByHDPositive();

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
