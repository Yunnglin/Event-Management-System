package com.cms.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GameGroupMapper {
    List<Map> queryByGameId(@Param("gid") int gameId);
}
