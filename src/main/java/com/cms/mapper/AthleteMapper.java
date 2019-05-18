package com.cms.mapper;

import com.cms.pojo.Athlete;

import java.util.List;
import java.util.Map;

public interface AthleteMapper {

    int insert(Athlete athlete);

    int insertNotGrade(Athlete athlete);

    Athlete queryById(String id);

    String queryNameById(String id);

    int queryAthleteCount();

    List<Athlete> queryAll();

    int deleteByIdNum(String id);

    int queryGirlCount();

    int queryBoyCount();
}
