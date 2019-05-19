package com.cms.mapper;

import com.cms.pojo.Coach;

public interface CoachMapper {
    int insert(Coach coach);

    Coach queryById(String id);

    String queryNameById(String id);
}
