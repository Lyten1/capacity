package com.models;

public class Group {
    private int id;
    private int id_speciality;
    private String group_name;
    private int students_amount;

    public void setData(int id, int id_speciality, String group_name, int student_amount) {
        this.id = id;
        this.id_speciality = id_speciality;
        this.group_name = group_name;
        this.students_amount = student_amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_speciality() {
        return id_speciality;
    }

    public void setId_speciality(int id_speciality) {
        this.id_speciality = id_speciality;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public int getStudents_amount() {
        return students_amount;
    }

    public void setStudents_amount(int students_amount) {
        this.students_amount = students_amount;
    }
}
