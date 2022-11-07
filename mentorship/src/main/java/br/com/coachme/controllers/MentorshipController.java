package br.com.coachme.controllers;

import br.com.coachme.dtos.MentorshipDto;
import br.com.coachme.models.Mentorship;
import br.com.coachme.models.MentorshipRequest;
import br.com.coachme.services.MentorshipService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/v1/mentorship")
public class MentorshipController {

    @Autowired
    private MentorshipService mentorshipService;


    @PostMapping("save")
    public ResponseEntity<Mentorship> save(MentorshipDto mentorshipDto){

        Mentorship mentorship = new Mentorship();
        mentorship.setStart_date(LocalDate.now());
        BeanUtils.copyProperties(mentorshipDto, mentorship);

        return new ResponseEntity<>(mentorshipService.save(mentorship), HttpStatus.OK);
    }


}
