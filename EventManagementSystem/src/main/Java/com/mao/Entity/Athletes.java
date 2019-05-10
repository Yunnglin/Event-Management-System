package com.mao.Entity;

public class Athletes {
    private String name;
    private char sex;
    private String id;
    private int age;
    private String number;
    private int teamno;

    public String getNumber() {
        return number;
    }

    public int getTeamno() {
        return teamno;
    }

    public void setTeamno(int teamno) {
        this.teamno = teamno;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
