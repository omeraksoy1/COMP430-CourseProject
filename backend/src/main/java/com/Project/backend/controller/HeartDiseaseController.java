package com.Project.backend.controller;

import com.Project.backend.service.HeartDiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // This means that this class is a Controller
@RequestMapping("/api")
public class HeartDiseaseController {
    @Autowired
    private HeartDiseaseService heartDiseaseService;

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String getParticipant (){
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        System.out.println("girdi");
        return "hello";
    }
}

