package com.cms.mapper;

import com.cms.pojo.Referee;

public interface RefereeMapper {
    int insert(Referee leader);

    Referee queryById(String id);

    String queryNameById(String id);
}
