package com.Project.backend.service;

import com.Project.backend.repository.HeartDiseaseRepository;
import com.Project.backend.resources.NumericResult;
import com.Project.backend.resources.SingleColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HeartDiseaseService {
    private final HeartDiseaseRepository heartDiseaseRepository;

    @Autowired
    public HeartDiseaseService(HeartDiseaseRepository heartDiseaseRepository){
        this.heartDiseaseRepository = heartDiseaseRepository;
    }

    public Double averageAge() {
        NumericResult res = new NumericResult();
        double age = heartDiseaseRepository.getAverageAge();
        ArrayList<Double> result = new ArrayList<>();
        result.add(age);
        res.setContent(result);

        return res.addLaplaceNoise(1.0, 1.0).get(0);
    }

    public Double getNumRecordsBySex(String sex) {
        NumericResult res = new NumericResult();
        Double count = heartDiseaseRepository.getNumRecordsBySex(sex);
        ArrayList<Double> result = new ArrayList<>();
        result.add(count);
        res.setContent(result);

        return res.addLaplaceNoise(1.0, 1.0).get(0);
    }

}
