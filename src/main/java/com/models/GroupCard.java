package com.models;

public class GroupCard {
    private int id;
    private int id_group;
    private int discipline;
    private int gradebook_hours;
    private int theory_hours1;
    private int lab_hours1;
    private int pract_hours1;
    private int coursework1;
    private int all_hours1;
    private int theory_hours2;
    private int lab_hours2;
    private int pract_hours2;
    private int coursework2;
    private int all_hours2;
    private int all_hours_in_year;
    private int id_teacher;

    public void setData(int id, int id_group, int discipline, int gradebook_hours,
                        int theory_hours1, int lab_hours1, int pract_hours1,
                        int coursework1, int all_hours1, int theory_hours2,
                        int lab_hours2, int pract_hours2, int coursework2,
                        int all_hours2, int all_hours_in_year, int id_teacher) {
        this.id = id;
        this.id_group = id_group;
        this.discipline = discipline;
        this.gradebook_hours = gradebook_hours;
        this.theory_hours1 = theory_hours1;
        this.lab_hours1 = lab_hours1;
        this.pract_hours1 = pract_hours1;
        this.coursework1 = coursework1;
        this.all_hours1 = all_hours1;
        this.theory_hours2 = theory_hours2;
        this.lab_hours2 = lab_hours2;
        this.pract_hours2 = pract_hours2;
        this.coursework2 = coursework2;
        this.all_hours2 = all_hours2;
        this.all_hours_in_year = all_hours_in_year;
        this.id_teacher = id_teacher;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_group(int id_group) {
        this.id_group = id_group;
    }

    public void setDiscipline(int discipline) {
        this.discipline = discipline;
    }

    public void setGradebook_hours(int gradebook_hours) {
        this.gradebook_hours = gradebook_hours;
    }

    public void setTheory_hours1(int theory_hours1) {
        this.theory_hours1 = theory_hours1;
    }

    public void setLab_hours1(int lab_hours1) {
        this.lab_hours1 = lab_hours1;
    }

    public void setPract_hours1(int pract_hours1) {
        this.pract_hours1 = pract_hours1;
    }

    public void setCoursework1(int coursework1) {
        this.coursework1 = coursework1;
    }

    public void setAll_hours1(int all_hours1) {
        this.all_hours1 = all_hours1;
    }

    public void setTheory_hours2(int theory_hours2) {
        this.theory_hours2 = theory_hours2;
    }

    public void setLab_hours2(int lab_hours2) {
        this.lab_hours2 = lab_hours2;
    }

    public void setPract_hours2(int pract_hours2) {
        this.pract_hours2 = pract_hours2;
    }

    public void setCoursework2(int coursework2) {
        this.coursework2 = coursework2;
    }

    public void setAll_hours2(int all_hours2) {
        this.all_hours2 = all_hours2;
    }

    public void setAll_hours_in_year(int all_hours_in_year) {
        this.all_hours_in_year = all_hours_in_year;
    }

    public void setId_teacher(int id_teacher) {
        this.id_teacher = id_teacher;
    }

    public int getId() {
        return id;
    }

    public int getId_group() {
        return id_group;
    }

    public int getDiscipline() {
        return discipline;
    }

    public int getGradebook_hours() {
        return gradebook_hours;
    }

    public int getTheory_hours1() {
        return theory_hours1;
    }

    public int getLab_hours1() {
        return lab_hours1;
    }

    public int getPract_hours1() {
        return pract_hours1;
    }

    public int getCoursework1() {
        return coursework1;
    }

    public int getAll_hours1() {
        return all_hours1;
    }

    public int getTheory_hours2() {
        return theory_hours2;
    }

    public int getLab_hours2() {
        return lab_hours2;
    }

    public int getPract_hours2() {
        return pract_hours2;
    }

    public int getCoursework2() {
        return coursework2;
    }

    public int getAll_hours2() {
        return all_hours2;
    }

    public int getAll_hours_in_year() {
        return all_hours_in_year;
    }

    public int getId_teacher() {
        return id_teacher;
    }
}
