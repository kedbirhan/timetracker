package com.kbirhan.timeTracker.controller;

import com.kbirhan.timeTracker.dto.TimeLogDto;
import com.kbirhan.timeTracker.model.TimeLogs;
import com.kbirhan.timeTracker.repository.TimeTableRepository;
import com.kbirhan.timeTracker.service.DateService;
import com.kbirhan.timeTracker.service.TimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.Map;

@RestController
public class homeRestController {
    Logger logger= LoggerFactory.getLogger(this.getClass());
@Autowired
    TimeService timeService;
    @PostMapping(value = "/updateTime")
    public void findTimeById( @RequestBody TimeLogDto timeLogs) {
   timeService.updateTimeValue(timeLogs);
    }
}
