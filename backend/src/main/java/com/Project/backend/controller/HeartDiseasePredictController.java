package com.Project.backend.controller;

import com.Project.backend.service.HeartDiseasePredictService;
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

    @RequestMapping(value = "/num-records-by-sex", method = RequestMethod.GET)
    public HashMap<String, Double> getNumHDbySex (@RequestBody Double epsilon) {
        return heartDiseasePredictService.getNumRecordsBySex(epsilon);
    }

    @RequestMapping(value = "/education-groups-by-hd-positive", method = RequestMethod.GET)
    public HashMap<String, Double> getEducationGroupsByHDPositive (@RequestBody Double epsilon) {
        return heartDiseasePredictService.getEducationGroupsByHDPositive(epsilon);
    }

    @RequestMapping(value = "/current-smoker-by-hd-positive", method = RequestMethod.GET)
    public HashMap<String, Double> getCurrentSmokerByHDPositive (@RequestBody Double epsilon) {
        return heartDiseasePredictService.getCurrentSmokerByHDPositive(epsilon);
    }
}
