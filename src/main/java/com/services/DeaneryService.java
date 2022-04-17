package com.services;

import com.dao.DeaneryDAO;
import com.models.Deanery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DeaneryService implements Servises<Deanery>{


    private DeaneryDAO deaneryDAO;

    @Autowired
    public DeaneryService(DeaneryDAO deaneryDAO) {
                this.deaneryDAO = deaneryDAO;
    }

    @Override
    public void save(Deanery data) {
       deaneryDAO.save(data);
    }

    @Override
    public Deanery get(String pattern) {
        return deaneryDAO.get(pattern);
    }

    @Override
    public ArrayList<Deanery> getAll() {
        return deaneryDAO.getAll();
    }

    @Override
    public void delete(String pattern) {
        deaneryDAO.delete(pattern);
    }

    @Override
    public void update(Deanery data, String pattern) {
        deaneryDAO.update(data, pattern);
    }

    public Deanery getFaculty(String faculty){
        return deaneryDAO.getFaculty(faculty);
    }


}
