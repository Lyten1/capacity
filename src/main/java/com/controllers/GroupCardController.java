package com.controllers;

import com.dao.GroupCardDAO;
import com.models.GroupCard;
import com.services.GroupCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@RequestMapping("/group_card")
public class GroupCardController {

    private GroupCardService groupCardService;

    @Autowired
    public GroupCardController(GroupCardService groupCardService) {
        this.groupCardService = groupCardService;
    }

    @GetMapping(value = "/get/{request_data}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.FOUND)
    public GroupCard get(@PathVariable("request_data") String id)  { return groupCardService.get(id); }

    @GetMapping(value = "/get/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.FOUND)
    public ArrayList<GroupCard> getAll() { return groupCardService.getAll(); }

    @GetMapping(value = "/teacher/{request_data}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.FOUND)
    public ArrayList<GroupCard> getByTeacher(@PathVariable("request_data") String teacher)
    { return groupCardService.getByTeacher(teacher); }

    @PostMapping("/create")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody GroupCard groupCard)  { this.groupCardService.save(groupCard); }

    @DeleteMapping("/delete/{request_data}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("request_data") String id)  { this.groupCardService.delete(id); }

    @PatchMapping("/update/{request_data}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("request_data") String id, @RequestBody GroupCard groupCard) {
        groupCardService.update(groupCard, id);
    }
}
