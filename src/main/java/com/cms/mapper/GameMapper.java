package com.cms.mapper;

import com.cms.pojo.Game;

import java.util.HashMap;
import java.util.List;

public interface GameMapper {
    int insetGame(Game game);

    int updateRId(Game game);

    int queryGameCount();



    List<HashMap> queryAll();

    Game queryById(int id);

    String queryIsExist(Game game);

    List<Game> getGamesList();

    List<HashMap> getSpecialGamesList(String teamAccount);


    String queryName(Game game);
    String queryNameById(int gid);
}
