package com.cms.mapper;

import com.cms.pojo.Athlete;
import com.cms.pojo.Game;
import com.cms.pojo.Participation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParticipationMapper {
    int inserP(Participation participationMapper);

    List<Athlete> queryAthletesByGame(Game game);
    List<Athlete> queryAthletesByGameID(int id);

    List<Participation> queryParticipationByGame(Game game);
    List<Participation> queryParticipationByGameID(int id);

    int updateScores(@Param("ano") int ano, @Param("gid") int gid, @Param("score") double score, @Param("p") double penalty, @Param("b") double bonus);
}
