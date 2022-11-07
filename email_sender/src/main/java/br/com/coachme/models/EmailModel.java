package br.com.coachme.models;

import java.time.LocalDateTime;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "tb_emails")
public class EmailModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String ownerRef;

    @Column
    private String emailFrom;

    @Column
    private String emailTo;

    @Column
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String text;

    @Column
    private LocalDateTime sentDate;

    @Column
    private StatusEmail statusEmail;

}
