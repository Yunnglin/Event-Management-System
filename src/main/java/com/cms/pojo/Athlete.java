package com.cms.pojo;

public class Athlete {
    private String name;
    private String idNum;
    private String sex;
    private int age;
    private int ac_record;
    private int Team_No;
    private int No;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return idNum;
    }

    public void setId(String idNum) {
        this.idNum = idNum;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAc_record() {
        return ac_record;
    }

    public void setAc_record(int ac_record) {
        this.ac_record = ac_record;
    }

    public int getTeam_No() {
        return Team_No;
    }

    public void setTeam_No(int team_No) {
        Team_No = team_No;
    }

    public int getNo() {
        return No;
    }

    public void setNo(int no) {
        No = no;
    }
}
