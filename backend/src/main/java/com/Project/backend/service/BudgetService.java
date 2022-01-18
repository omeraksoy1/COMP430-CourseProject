package com.Project.backend.service;
import com.Project.backend.repository.UserRepository;
import com.Project.backend.resources.OutOfBudgetException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetService {
    private Double budget;
    public BudgetService(){
        this.budget =100d;
    }

    public void decrementBudget(String token, Double epsilon) throws OutOfBudgetException {
        if (this.getBudget(token) < epsilon) {
            throw new OutOfBudgetException("User does not have enough budget.");
        }
        userRepository.decrementBudget(token, epsilon);
    }

    public Double getBudget(String token) {

        return userRepository.getByToken(token);
    }
}
