package com.controllers;

import com.dao.GroupDAO;
import com.models.Group;
import com.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@RequestMapping("/group")
public class GroupController {

    private GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping(value = "/get/{request_data}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.FOUND)
    public Group get(@PathVariable("request_data") String id) throws SQLException { return groupService.get(id); }

    @GetMapping(value = "/get/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.FOUND)
    public ArrayList<Group> getall() throws SQLException { return groupService.getAll(); }

    @GetMapping(value = "/id_speciality/{request_data}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.FOUND)
    public ArrayList<Group> getGroupByIdSpecialty(@PathVariable("request_data") String id_speciality)
    { return groupService.getGroupByIdSpecialty(id_speciality); }

    @PostMapping("/create")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Group group) { this.groupService.save(group); }

    @DeleteMapping("/delete/{request_data}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("request_data") String id) { this.groupService.delete(id); }

    @PatchMapping("/update/{request_data}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("request_data") String id, @RequestBody Group group)  {
        groupService.update(group, id);
    }
}
