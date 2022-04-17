package com.services;

import com.dao.TeacherDAO;
import com.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class TeacherService implements Servises<Teacher>{
private TeacherDAO teacherDAO;

@Autowired
    public TeacherService(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    @Override
    public void save(Teacher data) {
        teacherDAO.save(data);
    }

    @Override
    public Teacher get(String pattern) {
        return teacherDAO.get(pattern);
    }

    @Override
    public ArrayList<Teacher> getAll() {
        return teacherDAO.getAll();
    }

    @Override
    public void delete(String pattern) {
        teacherDAO.delete(pattern);
    }

    @Override
    public void update(Teacher data, String pattern) {
        teacherDAO.update(data,pattern);
    }

    public ArrayList<Teacher> findBySubject(String pattern) {
        return teacherDAO.findBySubject(pattern);
    }
}
