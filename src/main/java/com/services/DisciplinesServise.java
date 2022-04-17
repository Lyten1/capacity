package com.services;

import com.dao.DisciplinesDAO;
import com.models.Disciplines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component

public class DisciplinesServise implements Servises<Disciplines> {

    private DisciplinesDAO disciplinesDAO;

    @Autowired
    public DisciplinesServise(DisciplinesDAO disciplinesDAO) {
        this.disciplinesDAO = disciplinesDAO;
    }


    @Override
    public void save(Disciplines data) {
        disciplinesDAO.save(data);
    }

    @Override
    public Disciplines get(String pattern) {
        return disciplinesDAO.get(pattern);
    }

    @Override
    public ArrayList<Disciplines> getAll() {
        return disciplinesDAO.getAll();
    }

    @Override
    public void delete(String pattern) {
        disciplinesDAO.delete(pattern);
    }

    @Override
    public void update(Disciplines data, String pattern) {
        disciplinesDAO.update(data,pattern);
    }

    public ArrayList<Disciplines> getDisciplinesByIDSpecialty(String speciality_number){
        return disciplinesDAO.getDisciplinesByIDSpecialty(speciality_number);
    }
}
