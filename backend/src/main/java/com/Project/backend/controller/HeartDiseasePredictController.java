package com.Project.backend.controller;

import com.Project.backend.service.HeartDiseasePredictService;
import com.Project.backend.service.HeartDiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@CrossOrigin
@RestController // This means that this class is a Controller
@RequestMapping("/api/db2")

public class HeartDiseasePredictController {
    @Autowired
    private HeartDiseasePredictService heartDiseasePredictService;

    @RequestMapping(value = "/average-age", method = RequestMethod.GET)
    public ArrayList<Double> getAverageAge (@RequestBody Double epsilon) {
        return heartDiseasePredictService.averageAge(epsilon);
    }
}
