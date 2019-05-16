package com.cms.mapper;
import com.cms.pojo.PersonScore;
import  com.cms.pojo.TeamScore;

import java.util.HashMap;
import java.util.List;

public interface ScoreMapper
{
    List<HashMap> TeamScore();
    List<HashMap> Competition1();
    List<HashMap> Competition2();
    List<HashMap> PersonSum();

}