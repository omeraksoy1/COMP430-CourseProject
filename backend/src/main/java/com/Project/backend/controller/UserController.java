package com.Project.backend.controller;


import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;

@RestController // This means that this class is a Controller
@RequestMapping("/api")
@CrossOrigin
public class UserController {
    @RequestMapping(value= "/login", method = RequestMethod.GET)
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
}
