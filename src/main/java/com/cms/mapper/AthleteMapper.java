package com.cms.mapper;

import com.cms.pojo.Athlete;

import java.util.List;

public interface AthleteMapper {

    int insert(Athlete athlete);

    Athlete queryById(String id);

    String queryNameById(String id);

    int queryAthleteCount();

    List<Athlete> queryAll();
}
