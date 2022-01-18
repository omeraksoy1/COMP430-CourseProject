package com.Project.backend.resources;

public class OutOfBudgetException extends Exception {

    private String message;

    public OutOfBudgetException(String message) {
        this.message = message;
    }

}
