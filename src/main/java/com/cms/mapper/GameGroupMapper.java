package com.cms.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GameGroupMapper {
    List<Map> queryByGameId(@Param("gid") int gameId);

    int insert(@Param("ano") int ano,@Param("groupId") int groupId,@Param("gId") int gId,@Param("turn") int turn);

    Object isExists(@Param("ano") int ano,@Param("gId") int gId);

    int groupMemberCount(@Param("groupId") int groupId,@Param("gId") int gId);

    int delete(@Param("ano") int ano,@Param("gId") int gId);

    Object isTurnExistis(@Param("groupId") int groupId,@Param("gId") int gId,@Param("turn") int turn);

}

