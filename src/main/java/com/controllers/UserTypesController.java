package com.controllers;


import com.dao.UserTypesDAO;
import com.models.Teacher;
import com.models.UserTypes;
import com.services.UserTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@RequestMapping("/usertypes")
public class UserTypesController {

    private UserTypesService userTypesService;

    @Autowired
    public UserTypesController(UserTypesService userTypesService) {
        this.userTypesService = userTypesService;
    }

    @PostMapping("/create")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody UserTypes userTypes){
        this.userTypesService.save(userTypes);
    }

    @GetMapping(value = "/get/{request_data}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.FOUND)
    public UserTypes get(@PathVariable("request_data") String request_data) {
        return userTypesService.get(request_data);
    }

    @GetMapping(value = "/get/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.FOUND)
    public ArrayList<UserTypes> get() throws SQLException {
        return userTypesService.getAll();
    }

    @GetMapping(value = "/permit/{request_data}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.FOUND)
    public ArrayList<UserTypes> findByPermit(@PathVariable("request_data") String request_data) {
        return userTypesService.findByPermit(request_data);
    }

    @PatchMapping("/update/{request_data}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("request_data") String requestData, @RequestBody UserTypes userTypes) {
        userTypesService.update(userTypes, requestData);
    }

    @DeleteMapping( "/delete/{request_data}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("request_data") String requestData)  {
        userTypesService.delete(requestData);
    }

}
