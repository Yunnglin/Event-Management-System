package com.cms.mapper;

import com.cms.pojo.Team;

import java.util.List;

public interface TeamMapper {
    String queryPassword(String s);
    int queryIdByAccount(String s);
    List<Team> queryAll();
    int insert(Team team);
    Team queryById(int tno);

    Team queryByAccount(String account);
}
