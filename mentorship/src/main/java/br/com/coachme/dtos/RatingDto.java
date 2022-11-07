package br.com.coachme.dtos;

import br.com.coachme.models.Mentorship;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingDto {

    private Integer note;

    private String comentary;

    private Mentorship mentorship;
}
