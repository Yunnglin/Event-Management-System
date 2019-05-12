package com.cms.util;

import com.alibaba.fastjson.JSONObject;
import com.cms.pojo.Game;

public class JSONUtil {
    public static Game JSONObjtoGame(JSONObject obj){
        Game game = new Game();
        if(obj.getInteger("eventid")!=null)
            game.setEventId(obj.getInteger("eventid"));
        if(obj.getInteger("id")!=null)
            game.setGameId(obj.getInteger("id"));
        if(obj.getString("groupAge")!=null)
            game.setGroupAge(obj.getString("groupAge"));
        if(obj.getString("lv")!=null)
            game.setLevel(obj.getString("lv"));
        if(obj.getString("ridnum")!=null)
            game.setrIdNum(obj.getString("ridnum"));

        return game;
    }
}
