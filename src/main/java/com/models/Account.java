package com.models;

public class Account {
    private int id;
    private int id_status;
    private String login,password;

    public void setData(int id, int id_status, String login, String password) {
        this.id = id;
        this.id_status = id_status;
        this.login = login;
        this.password = password;
    }

    public int getId_status() {
        return id_status;
    }

    public void setId_status(int id_status) {
        this.id_status = id_status;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
