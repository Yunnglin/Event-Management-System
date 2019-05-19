package com.cms.mapper;
import com.cms.pojo.PersonScore;
import  com.cms.pojo.TeamScore;

import java.util.HashMap;
import java.util.List;

public interface ScoreMapper
{

    List<HashMap> Competition1();
    List<HashMap> Competition2();
    List<HashMap> Competition3();
    List<HashMap> Competition4();
    List<HashMap> Competition5();
    List<HashMap> Competition6();
    List<HashMap> Competition7();
    List<HashMap> Competition8();
    List<HashMap> Competition9();
    List<HashMap> Competition10();
    List<HashMap> Competition11();
    List<HashMap> Competition12();
    List<HashMap> TeamPerson(String account);
    List<HashMap> TeamScore();
    List<HashMap> PersonSum();

}