package com.cms;

import com.cms.mapper.GameGroupMapper;
import com.cms.util.MybatiesUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestMao {
    @Test
    public void m1(){
        SqlSession sqlSession= MybatiesUtil.getSession();
        GameGroupMapper gameGroupMapper=sqlSession.getMapper(GameGroupMapper.class);
        gameGroupMapper.delete(5,2);
        int i=gameGroupMapper.groupMemberCount(1,0);
        System.out.println(gameGroupMapper.isExists(1,0));
        System.out.println(i);
        sqlSession.commit();
    }
    @Test
    public void m2(){
        SqlSession sqlSession= MybatiesUtil.getSession();
        GameGroupMapper gameGroupMapper=sqlSession.getMapper(GameGroupMapper.class);
        System.out.println(gameGroupMapper.isTurnExistis(1,1,1));
    }
}
