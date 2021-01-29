package com.kbirhan.timeTracker.controller;

import com.kbirhan.timeTracker.model.DayTracker;
import com.kbirhan.timeTracker.model.TimeLogs;
import com.kbirhan.timeTracker.repository.DateTabelRepository;
import com.kbirhan.timeTracker.repository.TimeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class homeController {
    @Autowired
    DateTabelRepository repository;
    @Autowired
    TimeTableRepository timeTableRepository;


    @GetMapping("/")
    public String homePage(Model model){
        List<DayTracker> data= repository.findAll();
        model.addAttribute("listDate",data);
        return "index";
    }

    @GetMapping(path = "/getTimeDate/{id}",  produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<TimeLogs> findByDateIds(@PathVariable("id") int id){
        List<TimeLogs> timeLogs =  timeTableRepository.findByDateTableIdOrderByTimeVal((long) id);
        System.out.println(timeLogs);
        return timeLogs;
    }

}
