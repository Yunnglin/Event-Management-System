package com.mao.service;

import com.mao.Entity.Athletes;

import java.util.List;

public interface AthletesService {
    List<Athletes> getAthletes();
    Athletes selectById(String name);
}
