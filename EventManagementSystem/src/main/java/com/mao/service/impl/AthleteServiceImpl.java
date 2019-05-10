package com.mao.service.impl;

import com.mao.mapper.AthleteMapper;
import com.mao.pojo.Athlete;
import com.mao.service.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("athleteService")
public class AthleteServiceImpl implements AthleteService {

    @Autowired
    private AthleteMapper athleteMapper;

    @Override
    public List<Athlete> showAthlete() {
        return athleteMapper.queryAll();
    }
}
