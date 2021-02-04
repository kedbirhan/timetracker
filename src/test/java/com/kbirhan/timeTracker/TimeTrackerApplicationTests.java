package com.kbirhan.timeTracker;

import com.kbirhan.timeTracker.dto.TimeLogDto;
import com.kbirhan.timeTracker.model.TimeLogs;
import com.kbirhan.timeTracker.repository.TimeTableRepository;
import com.kbirhan.timeTracker.service.TimeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class TimeTrackerApplicationTests {
@Autowired
	TimeService timeService;
@Autowired
	TimeTableRepository repository;
	@Test
	void contextLoads() {
		TimeLogDto timeLogDto=new TimeLogDto();
		timeLogDto.setTaskAssigned("t1");
		TimeLogs timeLogs= repository.findById(210L).get();
		timeLogs.setFocusLevel("hh");
		timeLogs.setTaskStatusProgress("tt");
		timeLogs.setTaskAssigned("ty");
		repository.save(timeLogs);
		Assertions.assertEquals("hh", repository.findById(210L).get().getFocusLevel());
		Assertions.assertEquals("tt", repository.findById(210L).get().getTaskStatusProgress());
		Assertions.assertEquals("ty", repository.findById(210L).get().getTaskAssigned());

	}

}
