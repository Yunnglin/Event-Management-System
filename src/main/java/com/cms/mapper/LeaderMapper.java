package com.cms.mapper;

import com.cms.pojo.Leader;

public interface LeaderMapper {
    int insert(Leader leader);

    Leader queryById(String id);

    String queryNameById(String id);
}
