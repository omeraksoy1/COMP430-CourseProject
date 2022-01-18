package com.Project.backend.controller;

import com.Project.backend.resources.OutOfBudgetException;
import com.Project.backend.service.BudgetService;
import com.Project.backend.service.HeartDiseaseIndicatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;

@CrossOrigin
@RestController // This means that this class is a Controller
@RequestMapping("/api/db3")

public class HeartDiseaseIndicatorController {
    @Autowired
    private HeartDiseaseIndicatorService heartDiseaseIndicatorService;

    @Autowired
    private BudgetService budgetService;

    @RequestMapping(value = "/high-bp-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getHighBloodPressureByHDPositive(@RequestHeader("Authorization") String token, @RequestBody Double epsilon) {
        String authToken = token.substring("Basic".length()).trim();
        try {
            budgetService.decrementBudget(authToken, epsilon);
        } catch (OutOfBudgetException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User does not have enough budget.");
        }
        return heartDiseaseIndicatorService.getHighBloodPressureByHDPositive(epsilon);
    }

    @RequestMapping(value = "/high-chol-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getHighCholesterolByHDPositive(@RequestHeader("Authorization") String token, @RequestBody Double epsilon) {
        String authToken = token.substring("Basic".length()).trim();
        try {
            budgetService.decrementBudget(authToken, epsilon);
        } catch (OutOfBudgetException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User does not have enough budget.");
        }
        return heartDiseaseIndicatorService.getHighCholesterolByHDPositive(epsilon);
    }

    @RequestMapping(value = "/bmi-groups-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getBMIGroupsByHDPositive(@RequestHeader("Authorization") String token, @RequestBody Double epsilon) {
        String authToken = token.substring("Basic".length()).trim();
        try {
            budgetService.decrementBudget(authToken, epsilon);
        } catch (OutOfBudgetException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User does not have enough budget.");
        }
        return heartDiseaseIndicatorService.getBMIGroupsByHDPositive(epsilon);
    }

    @RequestMapping(value = "/smoker-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getSmokerByHDPositive(@RequestHeader("Authorization") String token, @RequestBody Double epsilon) {
        String authToken = token.substring("Basic".length()).trim();
        try {
            budgetService.decrementBudget(authToken, epsilon);
        } catch (OutOfBudgetException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User does not have enough budget.");
        }
        return heartDiseaseIndicatorService.getSmokerByHDPositive(epsilon);
    }

    @RequestMapping(value = "/stroke-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getStrokeByHDPositive(@RequestHeader("Authorization") String token, @RequestBody Double epsilon) {
        String authToken = token.substring("Basic".length()).trim();
        try {
            budgetService.decrementBudget(authToken, epsilon);
        } catch (OutOfBudgetException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User does not have enough budget.");
        }
        return heartDiseaseIndicatorService.getStrokeByHDPositive(epsilon);
    }

    @RequestMapping(value = "/diabetes-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getDiabetesByHDPositive(@RequestHeader("Authorization") String token, @RequestBody Double epsilon) {
        String authToken = token.substring("Basic".length()).trim();
        try {
            budgetService.decrementBudget(authToken, epsilon);
        } catch (OutOfBudgetException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User does not have enough budget.");
        }
        return heartDiseaseIndicatorService.getDiabetesByHDPositive(epsilon);
    }

    @RequestMapping(value = "/physical-activity-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getPhysActivityByHDPositive(@RequestHeader("Authorization") String token, @RequestBody Double epsilon) {
        String authToken = token.substring("Basic".length()).trim();
        try {
            budgetService.decrementBudget(authToken, epsilon);
        } catch (OutOfBudgetException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User does not have enough budget.");
        }
        return heartDiseaseIndicatorService.getPhysActivityByHDPositive(epsilon);
    }

    @RequestMapping(value = "/fruits-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getFruitsByHDPositive(@RequestHeader("Authorization") String token, @RequestBody Double epsilon) {
        String authToken = token.substring("Basic".length()).trim();
        try {
            budgetService.decrementBudget(authToken, epsilon);
        } catch (OutOfBudgetException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User does not have enough budget.");
        }
        return heartDiseaseIndicatorService.getFruitsByHDPositive(epsilon);
    }

    @RequestMapping(value = "/veggies-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getVeggiesByHDPositive(@RequestHeader("Authorization") String token, @RequestBody Double epsilon) {
        String authToken = token.substring("Basic".length()).trim();
        try {
            budgetService.decrementBudget(authToken, epsilon);
        } catch (OutOfBudgetException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User does not have enough budget.");
        }
        return heartDiseaseIndicatorService.getVeggiesByHDPositive(epsilon);
    }

    @RequestMapping(value = "/heavy-alcohol-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getHeavyAlcoholConsumptionByHDPositive(@RequestHeader("Authorization") String token, @RequestBody Double epsilon) {
        String authToken = token.substring("Basic".length()).trim();
        try {
            budgetService.decrementBudget(authToken, epsilon);
        } catch (OutOfBudgetException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User does not have enough budget.");
        }
        return heartDiseaseIndicatorService.getHeavyAlcoholConsumptionByHDPositive(epsilon);
    }

    @RequestMapping(value = "/any-healthcare-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getAnyHealthcareByHDPositive(@RequestHeader("Authorization") String token, @RequestBody Double epsilon) {
        String authToken = token.substring("Basic".length()).trim();
        try {
            budgetService.decrementBudget(authToken, epsilon);
        } catch (OutOfBudgetException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User does not have enough budget.");
        }
        return heartDiseaseIndicatorService.getAnyHealthcareByHDPositive(epsilon);
    }

    @RequestMapping(value = "/no-doc-cost-by-hd-positive", method = RequestMethod.POST)
    public HashMap<String, Double> getNoDoctorBCofCostByHDPositiveQuery(@RequestHeader("Authorization") String token, @RequestBody Double epsilon) {
        String authToken = token.substring("Basic".length()).trim();
        try {
            budgetService.decrementBudget(authToken, epsilon);
        } catch (OutOfBudgetException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User does not have enough budget.");
        }
        return heartDiseaseIndicatorService.getNoDoctorBCofCostByHDPositiveQuery(epsilon);
    }
}
