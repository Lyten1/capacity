package com.models;

public class UserTypes{
    int id;
    String name;
    boolean permit1, permit2, permit3, permit4,
            permit5, permit6, permit7, permit8;
    //TODO connect user and user_types

    public void setData(int id,String name, boolean p1, boolean p2, boolean p3, boolean p4, boolean p5, boolean p6
            , boolean p7, boolean p8){
        this.id=id;
        this.name = name;
        this.permit1 = p1;
        this.permit2 = p2;
        this.permit3 = p3;
        this.permit4 = p4;
        this.permit5 = p5;
        this.permit6 = p6;
        this.permit7 = p7;
        this.permit8 = p8;
    }

    public int getId() {
        return id;
    }

    public boolean isPermit4() {
        return permit4;
    }

    public void setPermit4(boolean permit4) {
        this.permit4 = permit4;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPermit1() {
        return permit1;
    }

    public void setPermit1(boolean permit1) {
        this.permit1 = permit1;
    }

    public boolean isPermit2() {
        return permit2;
    }

    public void setPermit2(boolean permit2) {
        this.permit2 = permit2;
    }

    public boolean isPermit3() {
        return permit3;
    }

    public void setPermit3(boolean permit3) {
        this.permit3 = permit3;
    }

    public boolean isPermit5() {
        return permit5;
    }

    public void setPermit5(boolean permit5) {
        this.permit5 = permit5;
    }

    public boolean isPermit6() {
        return permit6;
    }

    public void setPermit6(boolean permit6) {
        this.permit6 = permit6;
    }

    public boolean isPermit7() {
        return permit7;
    }

    public void setPermit7(boolean permit7) {
        this.permit7 = permit7;
    }

    public boolean isPermit8() {
        return permit8;
    }

    public void setPermit8(boolean permit8) {
        this.permit8 = permit8;
    }
}
