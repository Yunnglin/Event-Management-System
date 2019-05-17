package com.cms.mapper;

import org.apache.ibatis.annotations.Param;

public interface EventMapper {
    int queryIDbyName(@Param("s") String s);
}
