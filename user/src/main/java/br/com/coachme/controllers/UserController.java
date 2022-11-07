package br.com.coachme.controllers;

import br.com.coachme.dtos.UserDto;
import br.com.coachme.exceptions.UserAlreadyRegisteredException;
import br.com.coachme.exceptions.UserNotFoundException;
import br.com.coachme.models.User;
import br.com.coachme.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody @Valid UserDto userDto) throws JsonProcessingException {
        try {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);

            return ResponseEntity.ok().body(userService.save(user));

        }catch (UserAlreadyRegisteredException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{email}")
    public ResponseEntity<?> getByEmail(@PathVariable("email") String email){
        try {
            User user = userService.getByEmail(email);
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(user, userDto);

            return ResponseEntity.ok().body(userDto);

        } catch (UserNotFoundException e){

            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/edit/{email}")
    public ResponseEntity<?> update(@PathVariable("email")String email, @RequestBody @Valid UserDto userDto) throws JsonProcessingException {

    try {
        return new ResponseEntity<>(userService.updateUser(email, userDto), HttpStatus.OK);

    } catch (UserNotFoundException e){

        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    }

}
