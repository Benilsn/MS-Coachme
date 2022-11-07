package br.com.coachme.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailDto {

    @NotBlank(message = "Owner Ref cannot be empty!")
    private String ownerRef;

    @NotBlank(message = "E-mail to cannot be empty!")
    @Email(message = "Please insert a valid e-mail!")
    private String emailTo;

    @NotBlank(message = "Subject cannot be empty!")
    private String subject;

    @NotBlank(message = "Text cannot be empty!")
    private String text;
}
