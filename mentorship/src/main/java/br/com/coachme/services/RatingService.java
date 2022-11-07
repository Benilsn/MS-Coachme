package br.com.coachme.services;

import br.com.coachme.dtos.RatingDto;
import br.com.coachme.models.Rating;
import br.com.coachme.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public Rating save(Rating rating){
        return ratingRepository.save(rating);
    }
}
