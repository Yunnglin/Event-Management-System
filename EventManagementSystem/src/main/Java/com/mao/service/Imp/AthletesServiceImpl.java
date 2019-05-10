package com.mao.service.Imp;

import com.mao.Entity.Athletes;
import com.mao.mapper.AthletesMapper;
import com.mao.service.AthletesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AthletesService")
public class AthletesServiceImpl implements AthletesService {

    @Autowired
    private AthletesMapper athletesMapper;

    @Override
    public List<Athletes> getAthletes() {
        return athletesMapper.athletesList();
    }

    @Override
    public Athletes selectById(String name) {
        return athletesMapper.selectId(name,'男');
    }

}
