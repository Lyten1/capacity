package com.services;

import com.dao.SubjectDAO;
import com.models.Subject;
import org.jetbrains.annotations.ApiStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class SubjectService implements Servises<Subject>{

    private SubjectDAO subjectDAO;

    @Autowired
    public SubjectService(SubjectDAO subjectDAO) {
        this.subjectDAO = subjectDAO;
    }

    @Override
    public void save(Subject data) {
        subjectDAO.save(data);
    }

    @Override
    public Subject get(String pattern) {
        return subjectDAO.get(pattern);
    }

    @Override
    public ArrayList<Subject> getAll() {
        return subjectDAO.getAll();
    }

    @Override
    public void delete(String pattern) {
        subjectDAO.delete(pattern);
    }

    @Override
    public void update(Subject data, String pattern) {
        subjectDAO.update(data, pattern);
    }
}
