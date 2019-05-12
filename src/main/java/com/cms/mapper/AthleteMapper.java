package com.cms.mapper;

import com.cms.pojo.Athlete;

public interface AthleteMapper {

    int insert(Athlete athlete);

    int insertNotGrade(Athlete athlete);

    Athlete queryById(String id);

    String queryNameById(String id);

    int queryAthleteCount();
}
