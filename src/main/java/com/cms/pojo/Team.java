package com.cms.pojo;

public class Team {
    private int tNo;
    private String name;
    private String account;
    private String password;

    public int gettNo() {
        return tNo;
    }

    public void settNo(int tNo) {
        this.tNo = tNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
