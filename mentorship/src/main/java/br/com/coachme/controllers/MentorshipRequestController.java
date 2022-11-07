package br.com.coachme.controllers;

import br.com.coachme.dtos.MentorshipRequestDto;
import br.com.coachme.models.MentorshipRequest;
import br.com.coachme.services.MentorshipRequestService;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/request")
public class MentorshipRequestController {

    @Autowired
    private MentorshipRequestService mentorshipRequestService;


    @PostMapping("/save")
    public ResponseEntity<MentorshipRequest> save(@RequestBody MentorshipRequestDto mentorshipRequestDto){

        MentorshipRequest mentorshipRequest = new MentorshipRequest();
        BeanUtils.copyProperties(mentorshipRequestDto, mentorshipRequest);

        return new ResponseEntity<>(mentorshipRequestService.save(mentorshipRequest), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<MentorshipRequest>> getByStudentId(@PathVariable("id") Long id){

        return new ResponseEntity<>(mentorshipRequestService.getByStudentId(id), HttpStatus.OK);
    }

    @GetMapping("/disponibility/{id}")
    public ResponseEntity<List<MentorshipRequest>> getByDisponibilityId(@PathVariable("id") Long id){

        return new ResponseEntity<>(mentorshipRequestService.getByDisponibilityId(id), HttpStatus.OK);
    }

}
