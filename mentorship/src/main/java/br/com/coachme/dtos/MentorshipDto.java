package br.com.coachme.dtos;

import br.com.coachme.models.MentorshipRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MentorshipDto {

    private String start_date;

    private MentorshipRequest mentorshipRequest;
}
