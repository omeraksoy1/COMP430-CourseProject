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

    @RequestMapping(value = "/cigs-per-day-by-hd-positive", method = RequestMethod.GET)
    public HashMap<String, Double> getCigsPerDayGroupsByHDPositive (@RequestBody Double epsilon) {
        return heartDiseasePredictService.getCigsPerDayGroupsByHDPositive(epsilon);
    }

    @RequestMapping(value = "/bp-meds-groups-by-hd-positive", method = RequestMethod.GET)
    public HashMap<String, Double> getBPMedsGroupsByHDPositive (@RequestBody Double epsilon) {
        return heartDiseasePredictService.getBPMedsGroupsByHDPositive(epsilon);
    }

    @RequestMapping(value = "/prevalent-stroke-by-hd-positive", method = RequestMethod.GET)
    public HashMap<String, Double> getPrevalentStrokeByHDPositive (@RequestBody Double epsilon) {
        return heartDiseasePredictService.getPrevalentStrokeByHDPositive(epsilon);
    }

    @RequestMapping(value = "/prevalent-hypertension-by-hd-positive", method = RequestMethod.GET)
    public HashMap<String, Double> getPrevalentHypertensionBinaryByHDPositive (@RequestBody Double epsilon) {
        return heartDiseasePredictService.getPrevalentHypertensionBinaryByHDPositive(epsilon);
    }

    @RequestMapping(value = "/diabetes-by-hd-positive", method = RequestMethod.GET)
    public HashMap<String, Double> getDiabetesByHDPositive (@RequestBody Double epsilon) {
        return heartDiseasePredictService.getDiabetesByHDPositive(epsilon);
    }

    @RequestMapping(value = "/cholesterol-groups-by-hd-positive", method = RequestMethod.GET)
    public HashMap<String, Double> getCholesterolGroupsByHDPositive (@RequestBody Double epsilon) {
        return heartDiseasePredictService.getCholesterolGroupsByHDPositive(epsilon);
    }

    @RequestMapping(value = "/bmi-groups-by-hd-positive", method = RequestMethod.GET)
    public HashMap<String, Double> getBMIGroupsByHDPositive (@RequestBody Double epsilon) {
        return heartDiseasePredictService.getBMIGroupsByHDPositive(epsilon);
    }
}
