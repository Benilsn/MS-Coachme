package br.com.coachme.services;

import br.com.coachme.models.MentorshipRequest;
import br.com.coachme.repositories.MentorshipRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MentorshipRequestService {

    @Autowired
    private MentorshipRequestRepository mentorshipRequestRepository;


    public MentorshipRequest save(MentorshipRequest mentorshipRequest){
        return mentorshipRequestRepository.save(mentorshipRequest);
    }

    public List<MentorshipRequest> getByStudentId(Long id){
        return mentorshipRequestRepository.findAllByStudentId(id);
    }

    public List<MentorshipRequest> getByDisponibilityId(Long id){
        return mentorshipRequestRepository.findAllByDisponibilityId(id);
    }

}
