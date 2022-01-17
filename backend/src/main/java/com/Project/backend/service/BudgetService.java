package com.Project.backend.service;

public class BudgetService {
    private Double budget;
    public BudgetService(){
        this.budget =100d;
    }
    public void decrementBudget(Double epsilon){
        budget -= epsilon;
    }

    public Double getBudget(){
        return budget;
    }
}
