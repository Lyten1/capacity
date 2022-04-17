package com.controllers;


import com.dao.AccountDAO;
import com.models.Account;
import com.services.AccountServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountServise accountServise;

    @PostMapping("/create")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Account account)  {
        this.accountServise.save(account);
    }

    @GetMapping(value = "/get/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.FOUND)
    public ArrayList<Account> get()  {
        return accountServise.getAll();
    }

    @GetMapping(value = "/get/{request_data}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.FOUND)
    public Account get(@PathVariable("request_data") String requestData) {
        return accountServise.get(requestData);
    }


    @GetMapping(value = "/status/{request_data}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.FOUND)
    public ArrayList<Account> findByStatus(@PathVariable("request_data") String requestData)  {
        return accountServise.findByStatus(requestData);
    }

    @GetMapping(value = "/login/{request_data}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.FOUND)
    public ArrayList<Account> findByLogin(@PathVariable("request_data") String requestData)  {
        return accountServise.findByLogin(requestData);
    }


    @PatchMapping("/update/{request_data}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("request_data") String requestData, @RequestBody Account account)  {
        accountServise.update(account, requestData);
    }


    @DeleteMapping("/delete/{request_data}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("request_data") String requestData) {
        accountServise.delete(requestData);
    }
}
