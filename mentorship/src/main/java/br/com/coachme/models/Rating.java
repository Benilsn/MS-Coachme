package br.com.coachme.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "note", nullable = false)
    private Integer note;

    @Column(name = "comentary", columnDefinition = "TEXT")
    private String comentary;

    @OneToOne
    private Mentorship mentorship;
}
