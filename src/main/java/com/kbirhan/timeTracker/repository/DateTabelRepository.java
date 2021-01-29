package com.kbirhan.timeTracker.repository;

import com.kbirhan.timeTracker.model.DayTracker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DateTabelRepository extends JpaRepository<DayTracker,Long> {
//   Optional<DateTable> findByLocalDate(LocalDate localDate);
}
