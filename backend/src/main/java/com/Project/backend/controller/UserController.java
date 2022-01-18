package com.Project.backend.controller;


import com.Project.backend.resources.OutOfBudgetException;
import com.Project.backend.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;

@RestController // This means that this class is a Controller
@RequestMapping("/api")
@CrossOrigin
public class UserController {

    @Autowired
    private BudgetService budgetService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public boolean login(HttpServletRequest request) {
        System.out.println("giriyo");
        String authToken = request.getHeader("Authorization")
                .substring("Basic".length()).trim();
        String[] info = new String(Base64.getDecoder()
                .decode(authToken)).split(":");


        if(info[0].equals("a") && info[1].equals("a")) {
            return true;
        }else{ return false;}

    }

    @RequestMapping(value = "/budget/get", method = RequestMethod.GET)
    public Double getBudget(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
                .substring("Basic".length()).trim();

        return budgetService.getBudget(authToken);
    }

}
