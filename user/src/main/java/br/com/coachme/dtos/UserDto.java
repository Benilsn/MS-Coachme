package br.com.coachme.dtos;

import br.com.coachme.models.Elo;
import br.com.coachme.models.Position;
import br.com.coachme.models.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class UserDto {

    @JsonIgnore
    private Long id;

    @NotEmpty(message = "Name cannot be empty!")
    @Length(min = 3, message = "Name must contain atleast 3 characteres!")
    private String name;

    @Email(message = "Please insert e valid e-mail!")
    private String email;

    @NotEmpty(message = "Password cannot be empty!")
    @Size(min = 3, message = "Password must contain atleast 3 characteres!")
    private String password;

    private String description;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String user_image;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Float average_rating;

    private Role role;

    private Position position;

    private Elo elo;

}
