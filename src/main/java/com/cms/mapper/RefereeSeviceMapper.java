package com.cms.mapper;

import com.cms.pojo.Referee;

import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface RefereeSeviceMapper {

    List<Referee> queryRelatedReferee(int gid);


    int insert(@Param("ridNum") String ridNum,@Param("gid") int gid );
    Object isExit(@Param("ridNum") String ridNum,@Param("gid") int gid );
    int delete(@Param("ridNum") String ridNum,@Param("gid") int gid);

    int queryRefereeCount(@Param("gid") int gid);
}
