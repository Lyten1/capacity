package com.controllers;

import com.models.Deanery;
import com.services.DeaneryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/deanery")
public class DeaneryController {


    private DeaneryService deaneryService;

    @Autowired
    public DeaneryController(DeaneryService deaneryService) {
        this.deaneryService = deaneryService;
    }

    @GetMapping(value = "/get/{request_data}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.FOUND)
    public Deanery get(@PathVariable("request_data") String id) { return deaneryService.get(id); }

    @GetMapping(value = "/get/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.FOUND)
    public ArrayList<Deanery> getAll()  { return deaneryService.getAll(); }

    @GetMapping(value = "/faculty/{request_data}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.FOUND)
    public Deanery getFaculty(@PathVariable("request_data") String faculty) { return deaneryService.getFaculty(faculty); }

    @PostMapping("/create")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Deanery deanery) { this.deaneryService.save(deanery); }

    @DeleteMapping("/delete/{request_data}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("request_data") String id) { this.deaneryService.delete(id); }

    @PatchMapping("/update/{request_data}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("request_data") String id, @RequestBody Deanery deanery){
        deaneryService.update(deanery, id);
    }
}
