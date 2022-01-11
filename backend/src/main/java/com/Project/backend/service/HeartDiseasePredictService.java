package com.Project.backend.service;

import com.Project.backend.repository.HeartDiseasePredictRepository;
import com.Project.backend.repository.HeartDiseaseRepository;
import com.Project.backend.resources.NumericResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
}
