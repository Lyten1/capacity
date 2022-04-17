package com.services;


import com.dao.CapacityDAO;
import com.dao.TeacherDAO;
import com.models.Capacity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CapacityServise implements Servises<Capacity>{

        private CapacityDAO capacityDAO;
        private TeacherDAO teacherDAO;

        @Autowired
        public CapacityServise(CapacityDAO capacityDAO, TeacherDAO teacherDAO) {
            this.capacityDAO = capacityDAO;
            this.teacherDAO = teacherDAO;
        }

        public void save(Capacity data) {
            String shortname =  teacherDAO.makeShortName(data);
            capacityDAO.save(data, shortname);
        }

        public Capacity get(String pattern) {
            return capacityDAO.get(pattern);
        }

        public ArrayList<Capacity> getAll()  {
            return capacityDAO.getAll();
        }

        public void delete(String pattern) {
            capacityDAO.delete(pattern);
        }

        public void update(Capacity data, String pattern) {
            String shortname =  teacherDAO.makeShortName(data);
            capacityDAO.update(data,pattern,shortname);
        }

}
