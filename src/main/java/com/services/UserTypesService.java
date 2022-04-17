package com.services;

import com.dao.UserTypesDAO;
import com.models.UserTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserTypesService implements Servises<UserTypes>{
    private UserTypesDAO userTypesDAO;

    @Autowired
    public UserTypesService(UserTypesDAO userTypesDAO) {
        this.userTypesDAO = userTypesDAO;
    }

    @Override
    public void save(UserTypes data) {
        userTypesDAO.save(data);
    }

    @Override
    public UserTypes get(String pattern) {
        return userTypesDAO.get(pattern);
    }

    @Override
    public ArrayList<UserTypes> getAll() {
        return userTypesDAO.getAll();
    }

    @Override
    public void delete(String pattern) {
        userTypesDAO.delete(pattern);
    }

    @Override
    public void update(UserTypes data, String pattern) {
        userTypesDAO.update(data, pattern);
    }

    public ArrayList<UserTypes> findByPermit(String pattern) {
        return userTypesDAO.findByPermit(pattern);
    }
}
