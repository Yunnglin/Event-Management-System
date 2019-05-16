package com.cms.mapper;

import com.cms.pojo.Game;

import java.util.HashMap;
import java.util.List;

public interface GameMapper {
    int insetGame(Game game);

    int updateRId(Game game);

    int queryGameCount();

    int queryIsExist(Game game);

    public List<Game> getGamesList();

    List<HashMap> getSpecialGamesList(String teamAccount);

    List<HashMap> queryAll();
}
