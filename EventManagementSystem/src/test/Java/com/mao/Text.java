package com.mao;

import com.mao.Entity.Athletes;
import com.mao.mapper.AthletesMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class Text {

    @Autowired
    private AthletesMapper athletesMapper;

    @Test
    public void getAthletes() {
        System.out.println(athletesMapper.athletesList());
    }

}
