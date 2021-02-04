package com.kbirhan.timeTracker.dto;

import com.kbirhan.timeTracker.model.DayTracker;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;
@Getter
@Setter
@NoArgsConstructor
public class TimeLogDto {
    private Long id ;
    private String taskStatusProgress;
    private String taskAssigned;
    private String focusLevel;


}
