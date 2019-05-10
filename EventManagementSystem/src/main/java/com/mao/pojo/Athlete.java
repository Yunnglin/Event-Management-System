package com.mao.pojo;

public class Athlete {
    private Short no;

    private String name;

    private String idnum;

    private String sex;

    private Short age;

    private Short acRecord;

    private Short teamNo;

    public Short getNo() {
        return no;
    }

    public void setNo(Short no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdnum() {
        return idnum;
    }

    public void setIdnum(String idnum) {
        this.idnum = idnum == null ? null : idnum.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public Short getAcRecord() {
        return acRecord;
    }

    public void setAcRecord(Short acRecord) {
        this.acRecord = acRecord;
    }

    public Short getTeamNo() {
        return teamNo;
    }

    public void setTeamNo(Short teamNo) {
        this.teamNo = teamNo;
    }
}