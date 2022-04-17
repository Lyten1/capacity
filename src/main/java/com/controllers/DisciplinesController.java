package com.controllers;

import com.dao.DisciplinesDAO;
import com.models.Disciplines;
import com.services.DisciplinesServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@RequestMapping("/disciplines")
public class DisciplinesController {


    private DisciplinesServise disciplinesServise;

    @Autowired
    public DisciplinesController(DisciplinesServise disciplinesServise) {
        this.disciplinesServise = disciplinesServise;
    }

    @GetMapping(value = "/get/{request_data}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.FOUND)
    public Disciplines get(@PathVariable("request_data") String id)  {
        return disciplinesServise.get(id); }

    @GetMapping(value = "/get/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.FOUND)
    public ArrayList<Disciplines> getAll()  { return disciplinesServise.getAll(); }

    @GetMapping(value = "/speciality/{request_data}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.FOUND)
    public ArrayList<Disciplines> getDisciplinesByIDSpecialty(@PathVariable("request_data") String specialty)  {
        return disciplinesServise.getDisciplinesByIDSpecialty(specialty);
    }

    @PostMapping("/create")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Disciplines disciplines) {
        this.disciplinesServise.save(disciplines);
    }

    @DeleteMapping("/delete/{request_data}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("request_data") String id) {
        this.disciplinesServise.delete(id); }

    @PatchMapping("/update/{request_data}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("request_data") String id, @RequestBody Disciplines disciplines) {
        disciplinesServise.update(disciplines, id);
    }
}
