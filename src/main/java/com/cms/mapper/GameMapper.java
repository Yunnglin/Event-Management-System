package com.cms.mapper;

import com.cms.pojo.Game;

public interface GameMapper {
    int insetGame(Game game);

    int updateRId(Game game);

    int queryGameCount();

    int queryIsExist(Game game);
}
