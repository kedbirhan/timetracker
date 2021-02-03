package com.kbirhan.timeTracker.service;

import com.kbirhan.timeTracker.repository.TimeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeService {

    private final TimeTableRepository repository;
    @Autowired
    public TimeService(TimeTableRepository repository) {
        this.repository = repository;
    }
}
