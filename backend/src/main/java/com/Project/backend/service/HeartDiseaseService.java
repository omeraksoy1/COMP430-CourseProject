package com.Project.backend.service;

import com.Project.backend.repository.HeartDiseaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeartDiseaseService {
    private final HeartDiseaseRepository heartDiseaseRepository;

    @Autowired
    public HeartDiseaseService(HeartDiseaseRepository heartDiseaseRepository){this.heartDiseaseRepository = heartDiseaseRepository;}
    public Integer avgAge(){
        return heartDiseaseRepository.findAgeAverage();
    }

}
