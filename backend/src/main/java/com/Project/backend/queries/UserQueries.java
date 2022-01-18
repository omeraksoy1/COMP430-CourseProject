package com.Project.backend.queries;

public class UserQueries {
    public static final String GetBudgetByTokenQuery = "SELECT budget FROM userdetails WHERE token=:usertoken";
    public static final String DecrementBudgetByTokenQuery = "UPDATE userdetails SET budget=budget-:epsilon WHERE token = :usertoken";
}
