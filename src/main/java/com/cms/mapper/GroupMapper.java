package com.cms.mapper;

import com.cms.pojo.Athlete;
import com.cms.pojo.Game;

import java.util.List;

public interface GroupMapper {

    List<Athlete> queryAthletesOrdered(Game game);

    List<Athlete> queryAthletesOrderedByGID(int id);

}
