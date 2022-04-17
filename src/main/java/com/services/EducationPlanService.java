package com.services;

import com.dao.EducationPlanDAO;
import com.models.EducationPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class EducationPlanService implements Servises<EducationPlan>{

    private EducationPlanDAO educationPlanDAO;

    @Autowired
    public EducationPlanService(EducationPlanDAO educationPlanDAO) {
        this.educationPlanDAO = educationPlanDAO;
    }

    @Override
    public void save(EducationPlan data) {
        educationPlanDAO.save(data);
    }

    @Override
    public EducationPlan get(String pattern) {
        return educationPlanDAO.get(pattern);
    }

    @Override
    public ArrayList<EducationPlan> getAll() {
        return educationPlanDAO.getAll();
    }

    @Override
    public void delete(String pattern) {
        educationPlanDAO.delete(pattern);
    }

    @Override
    public void update(EducationPlan data, String pattern) {
        educationPlanDAO.update(data, pattern);
    }

    public ArrayList<EducationPlan> findBySpeciality(String pattern){
        return educationPlanDAO.findBySpeciality(pattern);
    }
}
