package com.Project.backend.controller;

import com.Project.backend.resources.OutOfBudgetException;
import com.Project.backend.service.BudgetService;
import com.Project.backend.service.HeartDiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;

@CrossOrigin(origins = "http://localhost:4200")
@RestController // This means that this class is a Controller
@RequestMapping("/api/db1")
public class HeartDiseaseController {
    @Autowired
    private HeartDiseaseService heartDiseaseService;

    @Autowired
    private BudgetService budgetService;

    @RequestMapping(value = "/average-age", method = RequestMethod.POST)
    public ArrayList<Double> getAverageAge (@RequestHeader("Authorization") String token, @RequestBody Double epsilon) {
        String authToken = token.substring("Basic".length()).trim();
        try {
            budgetService.decrementBudget(authToken, epsilon);
        } catch (OutOfBudgetException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User does not have enough budget.");
        }
        return heartDiseaseService.averageAge(epsilon);
    }

    @RequestMapping(value = "/num-records-by-sex", method = RequestMethod.POST)
    public HashMap<String, Double> getNumHDbySex (@RequestHeader("Authorization") String token, @RequestBody Double epsilon) {
        String authToken = token.substring("Basic".length()).trim();
        try {
            budgetService.decrementBudget(authToken, epsilon);
        } catch (OutOfBudgetException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User does not have enough budget.");
        }
        return heartDiseaseService.getNumRecordsBySex(epsilon);
    }

    @RequestMapping(value = "/chest-pain-type-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getChestPainTypeByHDPositive(@RequestHeader("Authorization") String token, @RequestBody Double epsilon) {
        String authToken = token.substring("Basic".length()).trim();
        try {
            budgetService.decrementBudget(authToken, epsilon);
        } catch (OutOfBudgetException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User does not have enough budget.");
        }
        return heartDiseaseService.getChestPainTypeByHDPositive(epsilon);
    }

    @RequestMapping(value = "/age-groups-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getAgeGroupsByHDPositive(@RequestHeader("Authorization") String token, @RequestBody Double epsilon) {
        String authToken = token.substring("Basic".length()).trim();
        try {
            budgetService.decrementBudget(authToken, epsilon);
        } catch (OutOfBudgetException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User does not have enough budget.");
        }
        return heartDiseaseService.getAgeGroupsByHDPositive(epsilon);
    }

    @RequestMapping(value = "/bp-groups-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getBPGroupsByHDPositive(@RequestHeader("Authorization") String token, @RequestBody Double epsilon) {
        String authToken = token.substring("Basic".length()).trim();
        try {
            budgetService.decrementBudget(authToken, epsilon);
        } catch (OutOfBudgetException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User does not have enough budget.");
        }
        return heartDiseaseService.getBPGroupsByHDPositive(epsilon);
    }

    @RequestMapping(value = "/st-slope-groups-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getSTSlopeGroupsByHDPositive(@RequestHeader("Authorization") String token, @RequestBody Double epsilon) {
        String authToken = token.substring("Basic".length()).trim();
        try {
            budgetService.decrementBudget(authToken, epsilon);
        } catch (OutOfBudgetException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User does not have enough budget.");
        }
        return heartDiseaseService.getSTSlopeGroupsByHDPositive(epsilon);
    }

    @RequestMapping(value = "/cholesterol-groups-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getCholesterolGroupsByHDPositive(@RequestHeader("Authorization") String token, @RequestBody Double epsilon) {
        String authToken = token.substring("Basic".length()).trim();
        try {
            budgetService.decrementBudget(authToken, epsilon);
        } catch (OutOfBudgetException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User does not have enough budget.");
        }
        return heartDiseaseService.getCholesterolGroupsByHDPositive(epsilon);
    }

    @RequestMapping(value = "/resting-ecg-groups-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getRestingECGGroupsByHDPositive(@RequestHeader("Authorization") String token, @RequestBody Double epsilon) {
        String authToken = token.substring("Basic".length()).trim();
        try {
            budgetService.decrementBudget(authToken, epsilon);
        } catch (OutOfBudgetException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User does not have enough budget.");
        }
        return heartDiseaseService.getRestingECGGroupsByHDPositive(epsilon);
    }
    @RequestMapping(value = "/max-hr-groups-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getMaxHRGroupsByHDPositive(@RequestHeader("Authorization") String token, @RequestBody Double epsilon) {
        String authToken = token.substring("Basic".length()).trim();
        try {
            budgetService.decrementBudget(authToken, epsilon);
        } catch (OutOfBudgetException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User does not have enough budget.");
        }
        return heartDiseaseService.getMaxHRGroupsByHDPositive(epsilon);
    }

    @RequestMapping(value = "/exercise-angina-groups-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getExerciseAnginaGroupsByHDPositive(@RequestHeader("Authorization") String token, @RequestBody Double epsilon) {
        String authToken = token.substring("Basic".length()).trim();
        try {
            budgetService.decrementBudget(authToken, epsilon);
        } catch (OutOfBudgetException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User does not have enough budget.");
        }
        return heartDiseaseService.getExerciseAnginaGroupsByHDPositive(epsilon);
    }
}

