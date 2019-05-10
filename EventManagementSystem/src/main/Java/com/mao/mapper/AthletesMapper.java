package com.mao.mapper;

import com.mao.Entity.Athletes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AthletesMapper {
    int insert(Athletes athlete);
    /**
     *  加上注解
     * @param name
     * @param sex
     * @return
     */
    Athletes selectId(@Param("name") String name,@Param("sex") char sex);
    int update(Athletes athletes);
    List<Athletes> athletesList();
}
