package com.mao.controller;

import com.mao.Entity.Athletes;
import com.mao.service.AthletesService;
import com.mao.service.Imp.AthletesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
//@RequestMapping("")
public class AthletesController {
    //注入service
    @Autowired
    private AthletesService athletesService;

    @RequestMapping(value = "/ath")
    public ModelAndView getIndex(){
        ModelAndView modelAndView = new ModelAndView("/appAccount/index");
        List<Athletes> athletes=athletesService.getAthletes();
        Athletes athletes1=athletesService.selectById("小明");
       modelAndView.addObject("athletes", athletes1);
        return modelAndView;
    }
    @RequestMapping(value = "/test")
    public String test(){

        return "/appAccount/index";
    }

}
