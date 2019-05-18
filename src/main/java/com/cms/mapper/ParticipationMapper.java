package com.cms.mapper;

import com.cms.pojo.Athlete;
import com.cms.pojo.Game;
import com.cms.pojo.Participation;

import java.util.List;

public interface ParticipationMapper {
    int inserPar(Participation participationMapper);

    List<Athlete> queryAthletesByGame(Game game);
    List<Athlete> queryAthletesByGameID(int id);

    List<Participation> queryParticipationByGame(Game game);
    List<Participation> queryParticipationByGameID(int id);
}
