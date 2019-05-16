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

    int queryIsExist(Game game);

<<<<<<< HEAD
    public List<Game> getGamesList();

    List<HashMap> getSpecialGamesList(String teamAccount);

    List<HashMap> queryAll();
=======
    String queryName(Game game);
    String queryNameById(int gid);
>>>>>>> 6797d14c0e346a8b63523567eb7ecfa0d53c567a
}
