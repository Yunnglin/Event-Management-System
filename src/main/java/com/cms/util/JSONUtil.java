package com.cms.util;

import com.alibaba.fastjson.JSONObject;
import com.cms.pojo.Game;

public class JSONUtil {
    public static Game JSONObjtoGame(JSONObject obj){
        Game game = new Game();
        if(obj.getInteger("eventId")!=null)
            game.setEventId(obj.getInteger("eventId"));
        if(obj.getInteger("gameId")!=null)
            game.setGameId(obj.getInteger("gameId"));
        if(obj.getString("groupAge")!=null)
            game.setGroupAge(obj.getString("groupAge"));
        if(obj.getString("level")!=null)
            game.setLevel(obj.getString("lv"));
        if(obj.getString("rIdNum")!=null)
            game.setrIdNum(obj.getString("ridnum"));

        return game;
    }
}
