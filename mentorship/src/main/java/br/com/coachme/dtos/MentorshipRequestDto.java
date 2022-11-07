package br.com.coachme.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MentorshipRequestDto {

    private Boolean confirmation;

    private Long disponibilityId;

    private Long studentId;
}
