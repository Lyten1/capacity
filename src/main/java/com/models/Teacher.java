package com.models;


import java.util.ArrayList;

public class Teacher {
    private int  id;
    private String name,surname,fathersname, shortname;
    private ArrayList<String> subjects= new ArrayList<>();


    public void setData(int id, String name, String surname, String fathersname, ArrayList<String> subjects) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.fathersname = fathersname;
        this.subjects = subjects;
    }

    public String getShortName(String name, String surname, String fathesname){

        char n = name.charAt(0);
        char f = fathesname.charAt(0);
        shortname = surname + " " + n + ". " + f + ".";
        return shortname;
    }

    public ArrayList<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFathersname() {
        return fathersname;
    }

    public void setFathersname(String fathersname) {
        this.fathersname = fathersname;
    }

}
