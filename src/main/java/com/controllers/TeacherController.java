package com.controllers;

import com.dao.TeacherDAO;
import com.models.Teacher;
import com.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/create")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Teacher teacher) {
        this.teacherService.save(teacher);
    }

    @GetMapping(value = "/get/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.FOUND)
    public ArrayList<Teacher> get() {
        return teacherService.getAll();
    }

    @GetMapping(value = "/get/{request_data}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.FOUND)
    public Teacher get(@PathVariable("request_data") String request_data)  {
        return teacherService.get(request_data);
    }

    @GetMapping(value = "/subject/{request_data}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.FOUND)
    public ArrayList<Teacher> findBySubject(@PathVariable("request_data") String request_data)  {
        return teacherService.findBySubject(request_data);
    }

    @PatchMapping("/update/{request_data}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("request_data") String requestData, @RequestBody Teacher teacher) {
        teacherService.update(teacher, requestData);
    }


    @DeleteMapping("/delete/{request_data}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("request_data") String requestData)  {
        teacherService.delete(requestData);
    }
}
