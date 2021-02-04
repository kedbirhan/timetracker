package com.kbirhan.timeTracker.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "DATETABEL")
@Builder(toBuilder = true)
@AllArgsConstructor()
@Setter()
@Getter
//this represent the day11
public class DayTracker {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idColumn")
    @Id
    private Long id ;
//    @OneToMany(mappedBy = "dateTable",cascade = {CascadeType.ALL})
//    private List<TimeTable> timeTabelSet;
    @Column(name = "local_date", columnDefinition = "DATE")
    private LocalDate localDate;
    private String total_hours_wasted;
    private int total_productive_hours;


    public DayTracker() {

    }
}
