package com.Project.backend.controller;

import com.Project.backend.service.HeartDiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@CrossOrigin(origins = "http://localhost:4200")
@RestController // This means that this class is a Controller
@RequestMapping("/api/db1")
public class HeartDiseaseController {
    @Autowired
    private HeartDiseaseService heartDiseaseService;

    @RequestMapping(value = "/average-age", method = RequestMethod.POST)
    public ArrayList<Double> getAverageAge (@RequestBody Double epsilon) {
        System.out.println("giriyo");

        return heartDiseaseService.averageAge(epsilon);
    }

    @RequestMapping(value = "/num-records-by-sex", method = RequestMethod.POST)
    public HashMap<String, Double> getNumHDbySex (@RequestBody Double epsilon) {
        return heartDiseaseService.getNumRecordsBySex(epsilon);
    }

    @RequestMapping(value = "/chest-pain-type-by-hd-positive", method = RequestMethod.GET)
    public HashMap<String, Double> getChestPainTypeByHDPositive(@RequestBody Double epsilon) {
        return heartDiseaseService.getChestPainTypeByHDPositive(epsilon);
    }

    @RequestMapping(value = "/age-groups-by-hd-positive", method = RequestMethod.GET)
    public HashMap<String, Double> getAgeGroupsByHDPositive(@RequestBody Double epsilon) {
        return heartDiseaseService.getAgeGroupsByHDPositive(epsilon);
    }

    @RequestMapping(value = "/bp-groups-by-hd-positive", method = RequestMethod.GET)
    public HashMap<String, Double> getBPGroupsByHDPositive(@RequestBody Double epsilon) {
        return heartDiseaseService.getBPGroupsByHDPositive(epsilon);
    }

    @RequestMapping(value = "/st-slope-groups-by-hd-positive", method = RequestMethod.GET)
    public HashMap<String, Double> getSTSlopeGroupsByHDPositive(@RequestBody Double epsilon) {
        return heartDiseaseService.getSTSlopeGroupsByHDPositive(epsilon);
    }

    @RequestMapping(value = "/cholesterol-groups-by-hd-positive", method = RequestMethod.GET)
    public HashMap<String, Double> getCholesterolGroupsByHDPositive(@RequestBody Double epsilon) {
        return heartDiseaseService.getCholesterolGroupsByHDPositive(epsilon);
    }

    @RequestMapping(value = "/resting-ecg-groups-by-hd-positive", method = RequestMethod.GET)
    public HashMap<String, Double> getRestingECGGroupsByHDPositive(@RequestBody Double epsilon) {
        return heartDiseaseService.getRestingECGGroupsByHDPositive(epsilon);
    }
    @RequestMapping(value = "/max-hr-groups-by-hd-positive", method = RequestMethod.GET)
    public HashMap<String, Double> getMaxHRGroupsByHDPositive(@RequestBody Double epsilon) {
        return heartDiseaseService.getMaxHRGroupsByHDPositive(epsilon);
    }

    @RequestMapping(value = "/exercise-angina-groups-by-hd-positive", method = RequestMethod.GET)
    public HashMap<String, Double> getExerciseAnginaGroupsByHDPositive(@RequestBody Double epsilon) {
        return heartDiseaseService.getExerciseAnginaGroupsByHDPositive(epsilon);
    }
}

