package com.kbirhan.timeTracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "timetracker")
@Builder(toBuilder = true)
@AllArgsConstructor()
@Setter()
@Getter
// this represent the time by 1 hour increment
public class TimeLogs implements Serializable {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id ;

//@ManyToOne(fetch = FetchType.LAZY, optional = false)
//@JoinColumn(name="date_id", nullable = false)
//@JoinColumn(name="date_id", nullable = false)
    // this is basically a column to the foreign key
    @ManyToOne(fetch = FetchType.LAZY,optional = false, cascade = {CascadeType.REMOVE})
    @JoinColumn(name="date_id", nullable = false)
@JsonIgnore
    private DayTracker dateTable;
@Size(max=500)
    private String task;
    private String distractions;
    private int timeVal;

    public TimeLogs() {

    }
}
