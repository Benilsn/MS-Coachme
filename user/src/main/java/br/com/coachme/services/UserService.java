package br.com.coachme.services;

import br.com.coachme.dtos.UserDto;
import br.com.coachme.exceptions.UserAlreadyRegisteredException;
import br.com.coachme.exceptions.UserNotFoundException;
import br.com.coachme.models.Elo;
import br.com.coachme.models.Position;
import br.com.coachme.models.Role;
import br.com.coachme.models.User;
import br.com.coachme.repositories.EloRepository;
import br.com.coachme.repositories.PositionRepository;
import br.com.coachme.repositories.RoleRepository;
import br.com.coachme.repositories.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private EloRepository eloRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    public User save(User user) throws JsonProcessingException {

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyRegisteredException("E-mail already taken!");
        }

        Role userRole = roleRepository.findById(1L).orElseThrow();
        Elo noElo = eloRepository.findById(1L).orElseThrow();
        Position noPosition = positionRepository.findById(6L).orElseThrow();

        user.setRole(userRole);
        user.setElo(noElo);
        user.setPosition(noPosition);

        sendEmail(user.getName(),
                user.getEmail(),
                "Account Created!",
                "Your Account was created on lol coach service. \n Enjoy!");

        return userRepository.save(user);
    }

    public User getByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User Not Found!"));
    }

    public User updateUser(String email, UserDto userDto) throws JsonProcessingException {

        User userToUpdate = getByEmail(email);

        userToUpdate.setName(userDto.getName());
        userToUpdate.setEmail(userDto.getEmail());
        userToUpdate.setPassword(userDto.getPassword());
        userToUpdate.setDescription(userDto.getDescription());

        sendEmail(userToUpdate.getName(),
                userToUpdate.getEmail(),
                "Account Information updated!",
                "Your account settings from lol coach was updated!\n" +
                        "Name:" + userToUpdate.getName() + "\n" +
                        "E-mail: " + userToUpdate.getEmail() + "\n " +
                        "Password: " + userToUpdate.getPassword() +"\n" +
                        "Description: " + userToUpdate.getDescription() + "\n\n" +
                        "If you did'nt made these change contact our support.");

        return userRepository.save(userToUpdate);
    }

    public void sendEmail(String ownerRef, String emailTo, String subject, String text) throws JsonProcessingException {
        Map<String, String> emailMap = Map.ofEntries(
                Map.entry("ownerRef", ownerRef),
                Map.entry("emailTo", emailTo),
                Map.entry("subject", subject),
                Map.entry("text", text));

        emailSenderService.sendEmail(emailMap);
    }
}
