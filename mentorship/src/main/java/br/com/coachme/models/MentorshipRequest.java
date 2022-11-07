package br.com.coachme.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_mentorship_request")
public class MentorshipRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "confirmation", nullable = false)
    private Boolean confirmation;

    @OneToOne
    private Disponibility disponibility;

    @Column(name = "studentId", nullable = false)
    private Long studentId;
}
