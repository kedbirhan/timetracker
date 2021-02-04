package com.kbirhan.timeTracker.service;

import com.kbirhan.timeTracker.dto.TimeLogDto;
import com.kbirhan.timeTracker.model.TimeLogs;
import com.kbirhan.timeTracker.repository.TimeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TimeService {

    private  TimeTableRepository repository;
    @Autowired
    public TimeService(TimeTableRepository repository) {

        this.repository = repository;
    }
    @Transactional
    public void updateTimeValue(TimeLogDto timeLogs){
        TimeLogs t=repository.findById(timeLogs.getId()).get();
        t.setFocusLevel(timeLogs.getFocusLevel());
        t.setTaskAssigned(timeLogs.getTaskAssigned());
        t.setTaskStatusProgress(timeLogs.getTaskStatusProgress());
//        TimeLogs timeLogs1= repository.save(newTimeLog);
        TimeLogs timeLogs1= repository.save(t);
        System.out.printf("done");


    }


}
