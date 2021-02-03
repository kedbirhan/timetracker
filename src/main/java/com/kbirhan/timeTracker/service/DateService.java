package com.kbirhan.timeTracker.service;

import com.kbirhan.timeTracker.model.DayTracker;
import com.kbirhan.timeTracker.repository.DateTabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DateService {

    private final DateTabelRepository repository;
    @Autowired
    public DateService(DateTabelRepository repository) {
        this.repository = repository;
    }
public Page<DayTracker> listDates(int pageNum){
    Pageable pageable= PageRequest.of(pageNum-1,2);
        return repository.findAllByOrderByLocalDate(pageable);
}

public int findPageStartingPoint(int pageNum){

int current=pageNum;
while(current%5!=0){
    current--;
}
if(current==pageNum)return current;
    return current+1;
}
    public int findPageEndingPoint(int pageNum){
        int current=pageNum;
        while(current%5!=0){
            current++;
        }
        return current+1;
    }
}
