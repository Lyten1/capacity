package com.models;

public class Deanery {
    private int id;
    private String faculty;
    private String dean;

    public void setData(int id, String faculty, String dean) {
        this.id = id;
        this.faculty = faculty;
        this.dean = dean;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDean() {
        return dean;
    }

    public void setDean(String dean) {
        this.dean = dean;
    }
}
