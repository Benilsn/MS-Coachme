package br.com.coachme.services;

import br.com.coachme.models.Mentorship;
import br.com.coachme.repositories.MentorshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MentorshipService {

    @Autowired
    private MentorshipRepository mentorshipRepository;


    public Mentorship save (Mentorship mentorship){
        return mentorshipRepository.save(mentorship);
    }

}
