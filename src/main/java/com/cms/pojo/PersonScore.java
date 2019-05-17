package com.cms.pojo;

public class PersonScore
{
    private  double SumScore;
    private  String Name;
    private  String PersonId;
    private  String TeamName;

    public double getScore() {
        return SumScore;
    }

    public void setScore(double score) {
        SumScore = score;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPersonId() {
        return PersonId;
    }

    public void setPersonId(String teamId) {
        PersonId = teamId;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }
}