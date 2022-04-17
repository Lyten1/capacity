package com.models;

import org.hibernate.boot.model.relational.Database;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Statement;

public class Capacity {
    int id, id_teacher, semester, year, all_hours,theory_hours,lab_hours, pract_hours;
    String teachers_name, subject, groupe, control_type;



    public void setData(int id, int id_teacher,String teachers_name, String subject, String groupe,  int semester, int year, int all_hours, int theory_hours, int lab_hours, int pract_hours, String control_type){
        this.id = id;
        this.id_teacher = id_teacher;
        this.semester = semester;
        this.year = year;
        this.all_hours = all_hours;
        this.theory_hours = theory_hours;
        this.lab_hours = lab_hours;
        this.pract_hours = pract_hours;
        this.subject = subject;
        this.groupe = groupe;
        this.control_type = control_type;
        this.teachers_name = teachers_name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_teacher() {
        return id_teacher;
    }

    public void setId_teacher(int id_teacher) {
        this.id_teacher = id_teacher;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAll_hours() {
        return all_hours;
    }

    public void setAll_hours(int all_hours) {
        this.all_hours = all_hours;
    }

    public int getTheory_hours() {
        return theory_hours;
    }

    public void setTheory_hours(int theory_hours) {
        this.theory_hours = theory_hours;
    }

    public int getLab_hours() {
        return lab_hours;
    }

    public void setLab_hours(int lab_hours) {
        this.lab_hours = lab_hours;
    }

    public int getPract_hours() {
        return pract_hours;
    }

    public void setPract_hours(int pract_hours) {
        this.pract_hours = pract_hours;
    }

    public String getTeachers_name() {
        return teachers_name;
    }

    public void setTeachers_name(String teachers_name) {
        this.teachers_name = teachers_name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public String getControl_type() {
        return control_type;
    }

    public void setControl_type(String control_type) {
        this.control_type = control_type;
    }

}
