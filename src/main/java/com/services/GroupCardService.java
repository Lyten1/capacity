package com.services;


import com.dao.GroupCardDAO;
import com.models.GroupCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class GroupCardService implements Servises<GroupCard> {
    private GroupCardDAO groupCardDAO;

    @Autowired
    public GroupCardService(GroupCardDAO groupCardDAO) {
        this.groupCardDAO = groupCardDAO;
    }

    @Override
    public void save(GroupCard data) {
        groupCardDAO.save(data);
    }

    @Override
    public GroupCard get(String pattern) {
        return groupCardDAO.get(pattern);
    }

    @Override
    public ArrayList<GroupCard> getAll() {
        return groupCardDAO.getAll();
    }

    @Override
    public void delete(String pattern) {
        groupCardDAO.delete(pattern);
    }

    @Override
    public void update(GroupCard data, String pattern) {
        groupCardDAO.update(data, pattern);
    }

    public ArrayList<GroupCard> getByTeacher(String teacher){
        return groupCardDAO.getByTeacher(teacher);
    }
}
