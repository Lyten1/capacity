package com.models;

public class Specialities {
    private int id;
    private int id_faculty;
    private String speciality;
    private String specialty_abbreviation;

    public void setData(int id, int id_faculty, String speciality, String specialty_abbreviation) {
        this.id = id;
        this.id_faculty = id_faculty;
        this.speciality = speciality;
        this.specialty_abbreviation = specialty_abbreviation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_faculty() {
        return id_faculty;
    }

    public void setId_faculty(int id_faculty) {
        this.id_faculty = id_faculty;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getSpecialty_abbreviation() {
        return specialty_abbreviation;
    }

    public void setSpecialty_abbreviation(String specialty_abbreviation) {
        this.specialty_abbreviation = specialty_abbreviation;
    }
}
