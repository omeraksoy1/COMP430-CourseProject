package com.Project.backend.controller;

import com.Project.backend.resources.SingleColumn;
import com.Project.backend.service.HeartDiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController // This means that this class is a Controller
@RequestMapping("/api")
public class HeartDiseaseController {
    @Autowired
    private HeartDiseaseService heartDiseaseService;

    @RequestMapping(value = "/average-age", method = RequestMethod.GET)
    public Double getAverageAge () {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        return heartDiseaseService.averageAge();
    }

    @RequestMapping(value = "/get-num-records-by-sex", method = RequestMethod.GET)
    public Double getNumHDbySex (@RequestParam String sex) {
        return heartDiseaseService.getNumRecordsBySex(sex);
    }
}

