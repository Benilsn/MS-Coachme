package br.com.coachme.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DisponibilityDto {

    private LocalDateTime start_hour;

    private LocalDateTime end_hour;

    private Boolean available;

    private Integer number_of_weeks;

    private DayOfWeek disponibility_day;

    private Long id_mentor;
}
