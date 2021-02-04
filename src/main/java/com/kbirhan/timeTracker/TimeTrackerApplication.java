package com.kbirhan.timeTracker;

import com.kbirhan.timeTracker.model.DayTracker;
import com.kbirhan.timeTracker.model.TimeLogs;
import com.kbirhan.timeTracker.repository.DateTabelRepository;
import com.kbirhan.timeTracker.repository.TimeTableRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TimeTrackerApplication implements CommandLineRunner {
	@Autowired
	DateTabelRepository dateTabelRepository;
	@Autowired
	TimeTableRepository timeTableRepository;
	private static Logger LOG = LoggerFactory
			.getLogger(TimeTrackerApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(TimeTrackerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("EXECUTING : command line runner");
		for(int i=0; i<20; i++){
			List<TimeLogs> timeTabelList= new ArrayList<>();
			DayTracker dateTable= DayTracker.builder()
					.localDate(LocalDate.now().minusDays(i)).build();
			dateTable= dateTabelRepository.save(dateTable);
			for(int j=1;j<12; j++){
				TimeLogs timeTabelBuilder= new TimeLogs();
				timeTabelBuilder.setTaskAssigned("first Thirty minute task " + i );
				timeTabelBuilder.setTaskStatusProgress("last Thirty minute task " + i );
				timeTabelBuilder.setDateTable(dateTabelRepository.findById(dateTable.getId()).get());
				timeTableRepository.save(timeTabelBuilder);
			}


		}
		LOG.info("data inserted");
	}
}
