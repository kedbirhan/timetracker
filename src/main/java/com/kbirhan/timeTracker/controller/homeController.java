package com.kbirhan.timeTracker.controller;

import com.kbirhan.timeTracker.model.DayTracker;
import com.kbirhan.timeTracker.model.TimeLogs;
import com.kbirhan.timeTracker.repository.DateTabelRepository;
import com.kbirhan.timeTracker.repository.TimeTableRepository;
import com.kbirhan.timeTracker.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class homeController {
    @Autowired
    DateService dateService;
    @Autowired
    TimeTableRepository timeTableRepository;


    @GetMapping("/")
    public String homePage(Model model){

        return getPage(model,1);
    }
    @RequestMapping("/page/{pageNum}")
    public String getPage(Model model,@PathVariable(name = "pageNum") int pageNum){
        Page page= dateService.listDates(pageNum);
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalItems",page.getNumberOfElements());
        model.addAttribute("listDate",page);
       int paginator_start_point=dateService.findPageStartingPoint(pageNum);
        model.addAttribute("page_start", paginator_start_point);
        return "index";
    }

    @GetMapping(path = "/getTimeDate/{id}",  produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<TimeLogs> findByDateIds(@PathVariable("id") int id){
        List<TimeLogs> timeLogs =  timeTableRepository.findByDateTableIdOrderByTimeVal((long) id);
        System.out.println(timeLogs);
        return timeLogs;
    }



}
