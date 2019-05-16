package com.cms.pojo;

public class GameResult
{
    private String eventName;
    private String groupAge;
    private String level;
    private int gameId;
    private String rIdNum;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventId) {
        this.eventName = eventId;
    }

    public String getGroupAge() {
        return groupAge;
    }

    public void setGroupAge(String groupAge) {
        this.groupAge = groupAge;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getrIdNum() {
        return rIdNum;
    }

    public void setrIdNum(String rIdNum) {
        this.rIdNum = rIdNum;
    }

}
