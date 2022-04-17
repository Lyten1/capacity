package com.models;

public class Disciplines {
    private int id;
    private int id_education;
    private int id_speciality;
    private String discipline;
    private int sem_exam;
    private int sem_zal;
    private int sem_kp;
    private int all_hours;
    private int theory_hours;
    private int lab_hours;
    private int pract_hours;
    private int hours_first;
    private int hours_second;
    private int hours_third;
    private int hours_forth;
    private int hours_fifth;
    private int hours_sixth;
    private int hours_seventh;
    private int hours_eighth;

    public void setData(int id, int id_education, int id_speciality, String discipline,
                        int sem_exam, int sem_zal, int sem_kp,
                        int all_hours, int theory_hours, int lab_hours,
                        int pract_hours, int hours_first, int hours_second,
                        int hours_third, int hours_forth, int hours_fifth,
                        int hours_sixth, int hours_seventh, int hours_eighth) {
        this.id = id;
        this.id_education = id_education;
        this.id_speciality = id_speciality;
        this.discipline = discipline;
        this.sem_exam = sem_exam;
        this.sem_zal = sem_zal;
        this.sem_kp = sem_kp;
        this.all_hours = all_hours;
        this.theory_hours = theory_hours;
        this.lab_hours = lab_hours;
        this.pract_hours = pract_hours;
        this.hours_first = hours_first;
        this.hours_second = hours_second;
        this.hours_third = hours_third;
        this.hours_forth = hours_forth;
        this.hours_fifth = hours_fifth;
        this.hours_sixth = hours_sixth;
        this.hours_seventh = hours_seventh;
        this.hours_eighth = hours_eighth;
    }

    public int getId() {
        return id;
    }

    public int getId_education() {
        return id_education;
    }

    public int getId_speciality() {
        return id_speciality;
    }

    public String getDiscipline() {
        return discipline;
    }

    public int getSem_exam() {
        return sem_exam;
    }

    public int getSem_zal() {
        return sem_zal;
    }

    public int getSem_kp() {
        return sem_kp;
    }

    public int getAll_hours() {
        return all_hours;
    }

    public int getTheory_hours() {
        return theory_hours;
    }

    public int getLab_hours() {
        return lab_hours;
    }

    public int getPract_hours() {
        return pract_hours;
    }

    public int getHours_first() {
        return hours_first;
    }

    public int getHours_second() {
        return hours_second;
    }

    public int getHours_third() {
        return hours_third;
    }

    public int getHours_forth() {
        return hours_forth;
    }

    public int getHours_fifth() {
        return hours_fifth;
    }

    public int getHours_sixth() {
        return hours_sixth;
    }

    public int getHours_seventh() {
        return hours_seventh;
    }

    public int getHours_eighth() {
        return hours_eighth;
    }
}
