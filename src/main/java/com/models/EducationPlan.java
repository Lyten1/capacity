package com.models;

public class EducationPlan {
    //TODO maybe add name
    int id;
    int id_speciality;
    int week1, week2, week3, week4,
            week5, week6, week7, week8;

    public void setData(int id,int id_speciality, int w1, int w2, int w3, int w4, int w5, int w6
            , int w7, int w8){
        this.id=id;
        this.id_speciality=id_speciality;
        this.week1 = w1;
        this.week2 = w2;
        this.week3 = w3;
        this.week4 = w4;
        this.week5 = w5;
        this.week6 = w6;
        this.week7 = w7;
        this.week8 = w8;
    }

    public int getId_speciality() {
        return id_speciality;
    }

    public void setId_speciality(int id_speciality) {
        this.id_speciality = id_speciality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeek1() {
        return week1;
    }

    public void setWeek1(int week1) {
        this.week1 = week1;
    }

    public int getWeek2() {
        return week2;
    }

    public void setWeek2(int week2) {
        this.week2 = week2;
    }

    public int getWeek3() {
        return week3;
    }

    public void setWeek3(int week3) {
        this.week3 = week3;
    }

    public int getWeek4() {
        return week4;
    }

    public void setWeek4(int week4) {
        this.week4 = week4;
    }

    public int getWeek5() {
        return week5;
    }

    public void setWeek5(int week5) {
        this.week5 = week5;
    }

    public int getWeek6() {
        return week6;
    }

    public void setWeek6(int week6) {
        this.week6 = week6;
    }

    public int getWeek7() {
        return week7;
    }

    public void setWeek7(int week7) {
        this.week7 = week7;
    }

    public int getWeek8() {
        return week8;
    }

    public void setWeek8(int week8) {
        this.week8 = week8;
    }
}
