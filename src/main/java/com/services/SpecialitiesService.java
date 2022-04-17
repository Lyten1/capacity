package com.services;

import com.dao.SpecialitiesDAO;
import com.models.Specialities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class SpecialitiesService implements Servises<Specialities> {

    private SpecialitiesDAO specialitiesDAO;

    @Autowired
    public SpecialitiesService(SpecialitiesDAO specialitiesDAO) {
        this.specialitiesDAO = specialitiesDAO;
    }

    @Override
    public void save(Specialities data) {
        specialitiesDAO.save(data);
    }

    @Override
    public Specialities get(String pattern) {
        return specialitiesDAO.get(pattern);
    }

    @Override
    public ArrayList<Specialities> getAll() {
        return specialitiesDAO.getAll();
    }

    @Override
    public void delete(String pattern) {
        specialitiesDAO.delete(pattern);
    }

    @Override
    public void update(Specialities data, String pattern) {
        specialitiesDAO.update(data, pattern);
    }

    public ArrayList<Specialities> getSpecialtiesByIdFaculty(String id_faculty){
        return specialitiesDAO.getSpecialtiesByIdFaculty(id_faculty);
    }
}
