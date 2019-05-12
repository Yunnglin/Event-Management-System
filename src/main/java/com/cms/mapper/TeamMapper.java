package com.cms.mapper;

import com.cms.pojo.Team;

public interface TeamMapper {
    String queryPassword(String s);
    int queryIdByAccount(String s);
    int insertAttachment(Team team);

    int updatePassword(Team team);
}
