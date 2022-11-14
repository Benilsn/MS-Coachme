package br.com.coachme.models;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_emails")
public class EmailModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

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
    private Date sentDate;

    @Column
    private StatusEmail statusEmail;

}
