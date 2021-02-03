package com.kbirhan.timeTracker.repository;

import com.kbirhan.timeTracker.model.DayTracker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DateTabelRepository extends PagingAndSortingRepository<DayTracker,Long> {
//   Optional<DateTable> findByLocalDate(LocalDate localDate);
    Page<DayTracker> findAllByOrderByLocalDate(Pageable pageable);
}
