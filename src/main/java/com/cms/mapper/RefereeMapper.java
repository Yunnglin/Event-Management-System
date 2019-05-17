package com.cms.mapper;

import com.cms.pojo.Referee;
import org.apache.ibatis.annotations.Param;

public interface RefereeMapper {
    int insert(Referee leader);

    Referee queryById(String id);

    String queryNameById(String id);

    Referee queryByAccountName(@Param("account") String account, @Param("name") String name);
}
