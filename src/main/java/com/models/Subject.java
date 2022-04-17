package com.models;

public class Subject {
    private int id, id_teacher;
    private String name;

    public void setData(int id, String name, int id_teacher) {
        this.id = id;
        this.name = name;
        this.id_teacher = id_teacher;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
