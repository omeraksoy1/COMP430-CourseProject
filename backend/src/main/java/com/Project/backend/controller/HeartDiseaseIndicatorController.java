package com.Project.backend.controller;

import com.Project.backend.queries.HeartDiseaseIndicatorQueries;
import com.Project.backend.service.HeartDiseaseIndicatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin
@RestController // This means that this class is a Controller
@RequestMapping("/api/db3")

public class HeartDiseaseIndicatorController {
    @Autowired
    private HeartDiseaseIndicatorService heartDiseaseIndicatorService;

    @RequestMapping(value = "/high-bp-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getHighBloodPressureByHDPositive(@RequestBody Double epsilon) {
        return heartDiseaseIndicatorService.getHighBloodPressureByHDPositive(epsilon);
    }

    @RequestMapping(value = "/high-chol-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getHighCholesterolByHDPositive(@RequestBody Double epsilon) {
        return heartDiseaseIndicatorService.getHighCholesterolByHDPositive(epsilon);
    }

    @RequestMapping(value = "/bmi-groups-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getBMIGroupsByHDPositive(@RequestBody Double epsilon) {
        return heartDiseaseIndicatorService.getBMIGroupsByHDPositive(epsilon);
    }

    @RequestMapping(value = "/smoker-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getSmokerByHDPositive(@RequestBody Double epsilon) {
        return heartDiseaseIndicatorService.getSmokerByHDPositive(epsilon);
    }

    @RequestMapping(value = "/stroke-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getStrokeByHDPositive(@RequestBody Double epsilon) {
        return heartDiseaseIndicatorService.getStrokeByHDPositive(epsilon);
    }

    @RequestMapping(value = "/diabetes-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getDiabetesByHDPositive(@RequestBody Double epsilon) {
        return heartDiseaseIndicatorService.getDiabetesByHDPositive(epsilon);
    }

    @RequestMapping(value = "/physical-activity-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getPhysActivityByHDPositive(@RequestBody Double epsilon) {
        return heartDiseaseIndicatorService.getPhysActivityByHDPositive(epsilon);
    }

    @RequestMapping(value = "/fruits-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getFruitsByHDPositive(@RequestBody Double epsilon) {
        return heartDiseaseIndicatorService.getFruitsByHDPositive(epsilon);
    }

    @RequestMapping(value = "/veggies-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getVeggiesByHDPositive(@RequestBody Double epsilon) {
        return heartDiseaseIndicatorService.getVeggiesByHDPositive(epsilon);
    }

    @RequestMapping(value = "/heavy-alcohol-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getHeavyAlcoholConsumptionByHDPositive(@RequestBody Double epsilon) {
        return heartDiseaseIndicatorService.getHeavyAlcoholConsumptionByHDPositive(epsilon);
    }

    @RequestMapping(value = "/any-healthcare-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getAnyHealthcareByHDPositive(@RequestBody Double epsilon) {
        return heartDiseaseIndicatorService.getAnyHealthcareByHDPositive(epsilon);
    }

    @RequestMapping(value = "/no-doc-cost-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getNoDoctorBCofCostByHDPositiveQuery(@RequestBody Double epsilon) {
        return heartDiseaseIndicatorService.getNoDoctorBCofCostByHDPositiveQuery(epsilon);
    }
}
