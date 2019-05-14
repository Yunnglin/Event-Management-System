package com.cms;

import com.cms.mapper.RefereeSeviceMapper;
import com.cms.pojo.Referee;
import com.cms.util.MybatiesUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.function.Consumer;

public class Test2 {

    @Test
    public void t1(){
        SqlSession sqlSession = MybatiesUtil.getSession();
        RefereeSeviceMapper mapper = sqlSession.getMapper(RefereeSeviceMapper.class);
        List<Referee> referees = mapper.queryRelatedReferee(1);
        System.out.println(referees.size());
        for(int i=0; i<referees.size(); i++){
            System.out.println(referees.get(i).getIdNum());
        }
    }


}
