package com.mao.mapper;

import com.mao.pojo.Athlete;import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AthleteMapper {
    Athlete queryByIdNum(@Param("idnum")char[] idnum);
    List<Athlete> queryAll();
}
