package com.Project.backend.controller;

import com.Project.backend.resources.OutOfBudgetException;
import com.Project.backend.service.BudgetService;
import com.Project.backend.service.HeartDiseasePredictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;

@CrossOrigin(origins = "http://localhost:4200")
@RestController // This means that this class is a Controller
@RequestMapping("/api/db2")

public class HeartDiseasePredictController {
    @Autowired
    private HeartDiseasePredictService heartDiseasePredictService;

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
        return heartDiseasePredictService.averageAge(epsilon);
    }

    @RequestMapping(value = "/num-records-by-sex", method = RequestMethod.POST)
    public HashMap<String, Double> getNumHDbySex (@RequestHeader("Authorization") String token, @RequestBody Double epsilon) {
        String authToken = token.substring("Basic".length()).trim();
        try {
            budgetService.decrementBudget(authToken, epsilon);
        } catch (OutOfBudgetException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User does not have enough budget.");
        }
        return heartDiseasePredictService.getNumRecordsBySex(epsilon);
    }

    @RequestMapping(value = "/education-groups-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getEducationGroupsByHDPositive (@RequestHeader("Authorization") String token, @RequestBody Double epsilon) {
        String authToken = token.substring("Basic".length()).trim();
        try {
            budgetService.decrementBudget(authToken, epsilon);
        } catch (OutOfBudgetException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User does not have enough budget.");
        }
        return heartDiseasePredictService.getEducationGroupsByHDPositive(epsilon);
    }

    @RequestMapping(value = "/current-smoker-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getCurrentSmokerByHDPositive (@RequestHeader("Authorization") String token, @RequestBody Double epsilon) {
        String authToken = token.substring("Basic".length()).trim();
        try {
            budgetService.decrementBudget(authToken, epsilon);
        } catch (OutOfBudgetException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User does not have enough budget.");
        }
        return heartDiseasePredictService.getCurrentSmokerByHDPositive(epsilon);
    }

    @RequestMapping(value = "/cigs-per-day-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getCigsPerDayGroupsByHDPositive (@RequestHeader("Authorization") String token, @RequestBody Double epsilon) {
        String authToken = token.substring("Basic".length()).trim();
        try {
            budgetService.decrementBudget(authToken, epsilon);
        } catch (OutOfBudgetException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User does not have enough budget.");
        }
        return heartDiseasePredictService.getCigsPerDayGroupsByHDPositive(epsilon);
    }

    @RequestMapping(value = "/bp-meds-groups-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getBPMedsGroupsByHDPositive (@RequestHeader("Authorization") String token, @RequestBody Double epsilon) {
        String authToken = token.substring("Basic".length()).trim();
        try {
            budgetService.decrementBudget(authToken, epsilon);
        } catch (OutOfBudgetException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User does not have enough budget.");
        }
        return heartDiseasePredictService.getBPMedsGroupsByHDPositive(epsilon);
    }

    @RequestMapping(value = "/prevalent-stroke-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getPrevalentStrokeByHDPositive (@RequestHeader("Authorization") String token, @RequestBody Double epsilon) {
        String authToken = token.substring("Basic".length()).trim();
        try {
            budgetService.decrementBudget(authToken, epsilon);
        } catch (OutOfBudgetException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User does not have enough budget.");
        }
        return heartDiseasePredictService.getPrevalentStrokeByHDPositive(epsilon);
    }

    @RequestMapping(value = "/prevalent-hypertension-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getPrevalentHypertensionBinaryByHDPositive (@RequestHeader("Authorization") String token, @RequestBody Double epsilon) {
        String authToken = token.substring("Basic".length()).trim();
        try {
            budgetService.decrementBudget(authToken, epsilon);
        } catch (OutOfBudgetException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User does not have enough budget.");
        }
        return heartDiseasePredictService.getPrevalentHypertensionBinaryByHDPositive(epsilon);
    }

    @RequestMapping(value = "/diabetes-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getDiabetesByHDPositive (@RequestHeader("Authorization") String token, @RequestBody Double epsilon) {
        String authToken = token.substring("Basic".length()).trim();
        try {
            budgetService.decrementBudget(authToken, epsilon);
        } catch (OutOfBudgetException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User does not have enough budget.");
        }
        return heartDiseasePredictService.getDiabetesByHDPositive(epsilon);
    }

    @RequestMapping(value = "/cholesterol-groups-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getCholesterolGroupsByHDPositive (@RequestHeader("Authorization") String token, @RequestBody Double epsilon) {
        String authToken = token.substring("Basic".length()).trim();
        try {
            budgetService.decrementBudget(authToken, epsilon);
        } catch (OutOfBudgetException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User does not have enough budget.");
        }
        return heartDiseasePredictService.getCholesterolGroupsByHDPositive(epsilon);
    }

    @RequestMapping(value = "/bmi-groups-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getBMIGroupsByHDPositive (@RequestHeader("Authorization") String token, @RequestBody Double epsilon) {
        String authToken = token.substring("Basic".length()).trim();
        try {
            budgetService.decrementBudget(authToken, epsilon);
        } catch (OutOfBudgetException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User does not have enough budget.");
        }
        return heartDiseasePredictService.getBMIGroupsByHDPositive(epsilon);
    }
}
