package com.controllers;


import com.models.EducationPlan;
import com.services.EducationPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@RequestMapping("/educationplan")
public class EducationPlanController {


    private EducationPlanService educationPlanService;

    @Autowired
    public EducationPlanController(EducationPlanService educationPlanService) {
        this.educationPlanService = educationPlanService;
    }

    @PostMapping("/create")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody EducationPlan educationPlan)  {
        this.educationPlanService.save(educationPlan);
    }

    @GetMapping(value = "/get/{request_data}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.FOUND)
    public EducationPlan get(@PathVariable("request_data") String request_data)  {
        return educationPlanService.get(request_data);
    }

    @GetMapping(value = "/get/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.FOUND)
    public ArrayList<EducationPlan> get()  {
        return educationPlanService.getAll();
    }

    @GetMapping(value = "/speciality/{request_data}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.FOUND)
    public ArrayList<EducationPlan> findBySpeciality(@PathVariable("request_data") String request_data) {
        return educationPlanService.findBySpeciality(request_data);
    }

    @PatchMapping("/update/{request_data}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("request_data") String requestData, @RequestBody EducationPlan educationPlan)  {
        educationPlanService.update(educationPlan, requestData);
    }

    @DeleteMapping( "/delete/{request_data}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("request_data") String requestData)  {
        educationPlanService.delete(requestData);
    }

}
