package com.mao.controller;

import com.mao.pojo.Athlete;
import com.mao.service.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller

public class AthleteController {
    @Autowired
    private AthleteService athleteService;


}
