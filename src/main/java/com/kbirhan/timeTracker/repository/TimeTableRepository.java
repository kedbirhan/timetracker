package com.kbirhan.timeTracker.repository;

import com.kbirhan.timeTracker.model.TimeLogs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimeTableRepository extends JpaRepository<TimeLogs, Long> {
    List<TimeLogs> findByDateTableIdOrderByTimeVal(Long id);

}
