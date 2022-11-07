package br.com.coachme.controllers;

import br.com.coachme.dtos.RatingDto;
import br.com.coachme.models.MentorshipRequest;
import br.com.coachme.models.Rating;
import br.com.coachme.services.RatingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;


    @PostMapping("/save")
    public ResponseEntity<Rating> save(@RequestBody RatingDto ratingDto){

        System.out.println(ratingDto);
        System.out.println(ratingDto);
        System.out.println(ratingDto);

        Rating rating = new Rating();
        BeanUtils.copyProperties(ratingDto, rating);

        return new ResponseEntity<>(ratingService.save(rating), HttpStatus.OK);
    }
}
