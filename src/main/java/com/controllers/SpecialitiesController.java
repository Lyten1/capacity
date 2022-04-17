package com.controllers;

import com.dao.SpecialitiesDAO;
import com.models.Specialities;
import com.services.SpecialitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@RequestMapping("/specialities")
public class SpecialitiesController {

    private SpecialitiesService specialitiesService;

    @Autowired
    public SpecialitiesController(SpecialitiesService specialitiesService) {
        this.specialitiesService = specialitiesService;
    }

    @GetMapping(value = "/get/{request_data}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.FOUND)
    public Specialities get(@PathVariable("request_data") String id)  { return specialitiesService.get(id); }

    @GetMapping(value = "/get/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.FOUND)
    public ArrayList<Specialities> getall()  { return specialitiesService.getAll(); }

    @GetMapping(value = "/id_faculty/{request_data}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.FOUND)
    public ArrayList<Specialities> getSpecialtiesByIdFaculty(@PathVariable("request_data") String id_faculty)
    { return specialitiesService.getSpecialtiesByIdFaculty(id_faculty); }

    @PostMapping("/create")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Specialities specialities) { this.specialitiesService.save(specialities); }

    @DeleteMapping("/delete/{request_data}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("request_data") String id)  { this.specialitiesService.delete(id); }

    @PatchMapping("/update/{request_data}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("request_data") String id, @RequestBody Specialities specialities) {
        specialitiesService.update(specialities, id);
    }
}
