package com.cms.pojo;

public class TeamScore
{
    private String teamName;
    private  String teamId;
    private  double teamScore;
    private  int Order;

    public void setOrder(int a)
    {
        this.Order = a;
    }
    public  int getOrder()
    {
        return Order;
    }
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public double getTeamScore() {
        return teamScore;
    }

    public void setTeamScore(double teamScore) {
        this.teamScore = teamScore;
    }
}
