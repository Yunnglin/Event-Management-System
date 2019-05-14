package com.cms.mapper;

import com.cms.pojo.Referee;

import java.util.List;

public interface RefereeSeviceMapper {

    List<Referee> queryRelatedReferee(int gid);

}
