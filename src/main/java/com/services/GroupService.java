package com.services;


import com.dao.GroupDAO;
import com.models.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class GroupService implements Servises<Group>{
    private GroupDAO groupDAO;

    @Autowired
    public GroupService(GroupDAO groupCardDAO) {
        this.groupDAO = groupCardDAO;
    }


    @Override
    public void save(Group data) {
        groupDAO.save(data);
    }

    @Override
    public Group get(String pattern) {
        return groupDAO.get(pattern);
    }

    @Override
    public ArrayList<Group> getAll() {
        return groupDAO.getAll();
    }

    @Override
    public void delete(String pattern) {
        groupDAO.delete(pattern);
    }

    @Override
    public void update(Group data, String pattern) {
        groupDAO.update(data, pattern);
    }

    public ArrayList<Group> getGroupByIdSpecialty(String id_speciality){
        return groupDAO.getGroupByIdSpecialty(id_speciality);
    }
}
