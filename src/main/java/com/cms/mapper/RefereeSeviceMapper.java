package com.cms.mapper;

import com.cms.pojo.Referee;
<<<<<<< HEAD
import org.apache.ibatis.annotations.Param;
=======
>>>>>>> socket

import java.util.List;

public interface RefereeSeviceMapper {

    List<Referee> queryRelatedReferee(int gid);

<<<<<<< HEAD
    int insert(@Param("ridNum") String ridNum,@Param("gid") int gid );
    Object isExit(@Param("ridNum") String ridNum,@Param("gid") int gid );
    int delete(@Param("ridNum") String ridNum,@Param("gid") int gid);
=======
>>>>>>> socket
}
