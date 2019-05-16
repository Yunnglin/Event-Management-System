package com.cms;

import com.cms.mapper.GameGroupMapper;
import com.cms.util.MybatiesUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Test2 {
    @Test
    public void m1(){
        SqlSession sqlSession= MybatiesUtil.getSession();
        GameGroupMapper gameGroupMapper=sqlSession.getMapper(GameGroupMapper.class);
        gameGroupMapper.insert(5,2,2,4);
    }
}
