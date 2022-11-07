package br.com.coachme.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_disponibilities")
public class Disponibility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_hour", nullable = false)
    private LocalDateTime start_hour;

    @Column(name = "end_hour", nullable = false)
    private LocalDateTime end_hour;

    @Column(name = "available", nullable = false)
    private Boolean available;

    @Column(name = "number_of_weeks", nullable = false)
    private Integer number_of_weeks;

    @Column(name = "disponibility_day", nullable = false)
    private DayOfWeek disponibility_day;

    @Column(name = "id_mentor", nullable = false)
    private Long id_mentor;
}
